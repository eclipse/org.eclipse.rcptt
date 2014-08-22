package org.eclipse.rcptt.ecl.filesystem.internal.commands;

import static org.eclipse.rcptt.ecl.filesystem.EclFilesystemPlugin.createError;

import java.io.File;
import java.net.URI;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.filesystem.DeleteFile;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class DeleteFileService implements ICommandService {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		DeleteFile deleteFile = (DeleteFile) command;
		String uriString = deleteFile.getUri();

		if (uriString == null || uriString.length() == 0)
			return createError("No uri argument for delete-file command.");

		try {
			URI uri = new URI(uriString);
			File file = FileResolver.resolve(uri);
			if (file != null) {
				uri = file.toURI();
			}

			IFileStore input = EFS.getStore(uri);
			if (!input.fetchInfo().exists()) {
				return createError("\"%s\" not found.", uriString);
			}

			input.delete(EFS.NONE, null);

			return Status.OK_STATUS;
		} catch (Exception e) {
			return createError(e.getMessage(), e);
		}
	}

}
