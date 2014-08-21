package org.eclipse.rcptt.ecl.filesystem.internal.commands;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.filesystem.DeleteFile;
import org.eclipse.rcptt.ecl.filesystem.EclFilesystemPlugin;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class DeleteFileService implements ICommandService {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		DeleteFile deleteFile = (DeleteFile) command;
		String path = deleteFile.getPath();

		if (path == null || path.length() == 0)
			return error("File/directory is not specified.");

		try {
			File src = new File(path).getCanonicalFile();
			if (!src.exists())
				return error("File/directory \"%s\" does not exist.", src);

			if (src.isFile() || src.isDirectory()) {
				recursiveDelete(src);
				return Status.OK_STATUS;
			} else
				return error("Unsupported source type.");

		} catch (Exception e) {
			return error(e.getMessage());
		}
	}

	private static void recursiveDelete(File file) {
		if (!file.exists())
			return;

		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				recursiveDelete(f);
			}
		}

		file.delete();
	}

	private static Status error(String message, Object... args) {
		return new Status(Status.ERROR, EclFilesystemPlugin.PLUGIN_ID,
				String.format(message, args));
	}

}
