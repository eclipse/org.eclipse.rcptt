/*******************************************************************************
 * Copyright (c) 2009, 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.resources.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.zip.ZipInputStream;

import org.eclipse.compare.rangedifferencer.IRangeComparator;
import org.eclipse.compare.rangedifferencer.RangeDifference;
import org.eclipse.compare.rangedifferencer.RangeDifferencer;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.rcptt.core.Q7Features;
import org.eclipse.rcptt.resources.WSUtils;
import org.eclipse.rcptt.resources.impl.WSOptions;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.util.resources.ResourcesUtil;
import org.eclipse.rcptt.verifications.resources.internal.impl.Activator;
import org.eclipse.rcptt.verifications.runtime.ErrorList;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSFolder;
import org.eclipse.rcptt.workspace.WSProject;
import org.eclipse.rcptt.workspace.WSRoot;
import org.eclipse.rcptt.workspace.WorkspaceVerification;

public class WorkspaceVerificationChecker {

	private final WorkspaceVerification verification;

	private WSRoot root;
	private String location;
	private boolean allowUncapturedFiles;
	private String[] notAllowedPatterns;
	private boolean ignoreWhiteSpace;
	private Pattern[] ignoredLinePatterns;

	private ErrorList errors;
	private int maxFileDiffsCount;

	public WorkspaceVerificationChecker(WorkspaceVerification verification) {
		this.verification = verification;
	}

	private void initialize() throws CoreException {
		this.root = verification.getContent();
		this.location = verification.getLocation();
		this.ignoreWhiteSpace = verification.isIgnoreWhiteSpace();
		this.allowUncapturedFiles = verification.isAllowUncapturedFiles();
		this.notAllowedPatterns = WSOptions.resolveIgnoredPattern("", verification.getNotAllowedPatterns());

		if (verification.getIgnoredLines() != null) {
			final List<Pattern> patterns = new ArrayList<Pattern>();
			final String ignoredLines = verification.getIgnoredLines().replaceAll("\\r", "");
			for (String skippedline : ignoredLines.split("\n")) {
				try {
					patterns.add(Pattern.compile(skippedline));
				} catch (PatternSyntaxException e) {
					String message = String.format("Invalid '%s' regex", skippedline);
					IStatus status = Activator.createStatus(message, e);
					throw new CoreException(status);
				}
			}
			this.ignoredLinePatterns = patterns.toArray(new Pattern[patterns.size()]);
		}

		this.errors = new ErrorList();
		this.maxFileDiffsCount = TeslaFeatures.getInstance()
				.getIntValue(TeslaFeatures.RESOURCES_VERIFICATION_HUNKS_COUNT);
	}

	public void verifyWorkspace() throws CoreException {
		initialize();

		final IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
		verifyProjects(root, wsRoot);

		errors.throwIfAny(String.format("Workspace verification '%s' failed:", verification.getName()),
				this.getClass().getPackage().getName(), verification.getId());
	}

	private void verifyProjects(final WSRoot root, final IWorkspaceRoot rRoot)
			throws CoreException {
		final List<IProject> rProjects = new ArrayList<IProject>();
		Collections.addAll(rProjects, rRoot.getProjects());

		for (final WSProject project : root.getProjects()) {
			final IProject rProject = ResourcesUtil.getCaseInsensitiveChild(rRoot,
					project.getName(), IProject.class);
			if (rProject == null) {
				reportError(String.format("Project '%s' is not found", project.getName()));
				continue;
			}
			if (!rProject.exists()) {
				reportError(String.format("Project '%s' does not exist", project.getName()));
				continue;
			}
			if (!rProject.isOpen()) {
				reportError(String.format("Project '%s' is not open", project.getName()));
				continue;
			}
			rProjects.remove(rProject);
			verifyContainer(project, rProject, "", true);
		}

		if (!isUncapturedFilesAllowed()) {
			for (IProject rChild : rProjects) {
				if (isAllowedFile(rChild.getName())) {
					continue;
				}
				reportError(String.format("Unexpected '%s' project", rChild.getName()));
			}
		}
	}

	private void verifyContainers(final WSFolder folder, final IContainer rFolder,
			final String path, boolean isUncapturedAllowedInFolder) throws CoreException {
		final List<IFolder> rFolders = new ArrayList<IFolder>();
		for (IResource rResource : rFolder.members()) {
			if (rResource instanceof IFolder) {
				rFolders.add((IFolder) rResource);
			}
		}
		for (final WSFolder child : folder.getFolders()) {
			final IFolder rChild = rFolder.getFolder(new Path(child.getName()));
			if (!rChild.exists()) {
				reportError(String.format("Folder '%s%s/' does not exist", path, rChild.getName()));
				continue;
			}
			rFolders.remove(rChild);
			verifyContainer(child, rChild, path, isUncapturedAllowedInFolder);
		}
		if (!isUncapturedFilesAllowed()) {
			for (IFolder rChild : rFolders) {
				if (isAllowedFile(rChild.getName()) && isUncapturedAllowedInFolder) {
					continue;
				}
				reportError(String.format("Unexpected '%s%s/' folder", path, rChild.getName()));
			}
		}
	}

	private void verifyFiles(final WSFolder folder, final IContainer rFolder,
			final String path, boolean isUncapturedAllowedInFolder) throws CoreException {
		final List<IFile> rFiles = new ArrayList<IFile>();
		for (IResource rResource : rFolder.members()) {
			if (rResource instanceof IFile) {
				rFiles.add((IFile) rResource);
			}
		}
		for (final WSFile child : folder.getFiles()) {
			final IFile rChild = rFolder.getFile(new Path(child.getName()));
			if (!rChild.exists()) {
				reportError(String.format("File '%s%s' does not exist", path, child.getName()));
				continue;
			}
			rFiles.remove(rChild);
			verifyFile(child, rChild, path);
		}
		if (!isUncapturedFilesAllowed()) {
			for (IFile rChild : rFiles) {
				if (isAllowedFile(rChild.getName()) && isUncapturedAllowedInFolder) {
					continue;
				}
				reportError(String.format("Unexpected '%s%s' file", path, rChild.getName()));
			}
		}
	}

	private void verifyContainer(final WSFolder folder, final IContainer rFolder,
			final String path, boolean isUncapturedAllowedInFolder) throws CoreException {
		isUncapturedAllowedInFolder &= isAllowedFile(folder.getName());

		verifyContainers(folder, rFolder, getFullPath(path, rFolder), isUncapturedAllowedInFolder);
		verifyFiles(folder, rFolder, getFullPath(path, rFolder), isUncapturedAllowedInFolder);
	}

	private void verifyFile(final WSFile file, final IFile rFile,
			final String path) throws CoreException {
		try {
			final InputStream stream = getWSFileStream(file);
			final InputStream rStream = rFile.getContents();
			try {
				verifyLineByLine(stream, rStream, path + file.getName());
			} catch (CoreException e) {
				String message = String.format("Error while verifying '%s%s' file:\n%s", path, file.getName(),
						e.getMessage());
				IStatus status = Activator.createStatus(message, e);
				throw new CoreException(status);
			} finally {
				WSUtils.safeClose(stream);
				WSUtils.safeClose(rStream);
			}
		} catch (final IOException e) {
			IStatus status = Activator.createStatus(e.getMessage(), e);
			throw new CoreException(status);
		}
	}

	private void verifyLineByLine(final InputStream stream, final InputStream rStream,
			final String fileName) throws IOException, CoreException {
		final LineComparator comparator = new LineComparator(stream, ignoreWhiteSpace);
		final LineComparator rComparator = new LineComparator(rStream, ignoreWhiteSpace);

		final RangeDifference[] diffs = RangeDifferencer.findRanges((IRangeComparator) null, comparator, rComparator);

		int diffsCount = 0;
		int prevDiffEnd = -1;
		List<Integer> unprintedRows = new ArrayList<Integer>();

		final StringBuilder result = new StringBuilder();
		for (RangeDifference diff : diffs) {
			int kind = diff.kind();
			if (kind != RangeDifference.CHANGE) {
				continue;
			}

			final StringBuilder leftBuilder = new StringBuilder();
			final StringBuilder rightBuilder = new StringBuilder();

			int rightStart = -1, rightEnd = -1;
			int lastChangedLine = -1, lastUnchangedLine = -1;
			for (int i = 0; i < Math.max(diff.leftLength(), diff.rightLength()); i++) {
				int left = diff.leftStart() + i;
				int right = diff.rightStart() + i;
				boolean concatDiffs = false;

				if (right < diff.rightEnd()) {
					final String line = rComparator.getLine(right);
					if (!isSkippedLine(line)) {
						if (rightStart == -1) {
							rightStart = right;
						}
						rightEnd = right + 1;
						rightBuilder.append("+").append(right + 1)
								.append(" >").append(line).append("\n");
						lastChangedLine = right;
					} else {
						if (rightStart != -1 && right < rightEnd + 3) {
							rightBuilder.append(" ").append(right + 1)
									.append(" >").append(line).append("\n");
							lastUnchangedLine = right;
							concatDiffs = true;
						}
					}
				}

				if (left < diff.leftEnd()) {
					final String line = comparator.getLine(left);
					if (!isSkippedLine(line)) {
						leftBuilder.append("-").append(left + 1)
								.append(" >").append(line).append("\n");
					} else {
						concatDiffs = true;
					}
				}

				if (concatDiffs) {
					if (rightBuilder.length() != 0) {
						leftBuilder.append(rightBuilder.toString());
						rightBuilder.setLength(0);
					}
				}

			}

			if (leftBuilder.length() == 0 && rightBuilder.length() == 0) {
				continue;
			}

			final StringBuilder diffBuilder = new StringBuilder();
			if (rightStart == -1) {
				rightStart = diff.rightStart();
				rightEnd = diff.rightEnd();
			}
			// append upper context
			for (int i = Math.max(0, rightStart - 3); i < rightStart; i++) {
				if (!unprintedRows.isEmpty()) {
					if (diffsCount <= maxFileDiffsCount) {
						for (int row : unprintedRows) {
							if (row < i) {
								result.append(" ").append(row + 1)
										.append(" >").append(rComparator.getLine(row)).append("\n");
							}
						}
						if (i > prevDiffEnd + 3) {
							result.append("\n");
						}
					}
					unprintedRows.clear();
				}
				if (i > prevDiffEnd) {
					diffBuilder.append(" ").append(i + 1)
							.append(" >").append(rComparator.getLine(i)).append("\n");
				}
			}
			// append deletions
			if (leftBuilder.length() != 0)
				diffBuilder.append(leftBuilder.toString());
			// append insertions
			if (rightBuilder.length() != 0)
				diffBuilder.append(rightBuilder.toString());
			// append lower context
			for (int i = rightEnd; i < Math.min(rComparator.getRangeCount(), rightEnd + 3); i++) {
				if (i > lastUnchangedLine) {
					unprintedRows.add(i);
				}
			}
			prevDiffEnd = lastChangedLine + 1;

			if (++diffsCount > maxFileDiffsCount) {
				// max diffs count exceeded, do not append the result
				continue;
			}
			result.append(diffBuilder.toString());
		}

		if (diffsCount == 0) {
			return;
		}
		result.insert(0, String.format("%d difference%s in '%s' file:\n", diffsCount,
				diffsCount > 1 ? "s" : "", fileName));
		if (diffsCount <= maxFileDiffsCount && !unprintedRows.isEmpty()) {
			for (int row : unprintedRows) {
				result.append(" ").append(row + 1)
						.append(" >").append(rComparator.getLine(row)).append("\n");
			}
			unprintedRows.clear();
			result.append("\n");
		}
		if (diffsCount > maxFileDiffsCount) {
			result.append("... ").append(diffsCount - maxFileDiffsCount)
					.append(" more differences in the file").append("\n");
		}
		reportError(result.toString());
	}

	private boolean isUncapturedFilesAllowed() {
		return allowUncapturedFiles && (notAllowedPatterns == null || notAllowedPatterns.length == 0);
	}

	private boolean isAllowedFile(String fileName) {
		if (!allowUncapturedFiles) {
			return false;
		}
		return !WSOptions.isIgnored(fileName, notAllowedPatterns);
	}

	private boolean isSkippedLine(final String line) {
		if (line == null) {
			return false;
		}
		if (ignoredLinePatterns == null) {
			return false;
		}
		for (Pattern ignoredLine : ignoredLinePatterns) {
			Matcher matcher = ignoredLine.matcher(line);
			if (matcher.matches()) {
				return true;
			}
		}
		return false;
	}

	private InputStream getWSFileStream(final WSFile file)
			throws IOException {
		if (file.getContent() == null) {
			return WSUtils.getFileStream(location, file, null);
		} else {
			if (Q7Features.getInstance().isTrue(
					Q7Features.Q7_CONTEXTS_RESOURCES_ZIPPED_TRANSFER)) {

				ZipInputStream zin = new ZipInputStream(
						new ByteArrayInputStream(file.getContent()));
				zin.getNextEntry();
				return zin;
			} else {
				return new ByteArrayInputStream(file.getContent());
			}
		}
	}

	private String getFullPath(final String path, final IContainer folder) {
		return String.format("%s%s/", path, folder.getName());
	}

	private void reportError(String message) throws CoreException {
		message = message.replaceAll("%", "%%");
		errors.add(message);
	}

}
