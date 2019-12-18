/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.interop.internal.commands;

import static org.eclipse.rcptt.ecl.interop.internal.EclInteropPlugin.error;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.interop.ExecProcess;
import org.eclipse.rcptt.ecl.interop.ExecProcessResult;
import org.eclipse.rcptt.ecl.interop.InteropFactory;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

public class ExecProcessService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {

		ExecProcess cmd = (ExecProcess) command;
		List<String> cmdArray = new ArrayList<String>();
		cmdArray.add(cmd.getCommand());
		for (String arg : cmd.getArgs())
			cmdArray.add(arg);

		Runtime runtime = Runtime.getRuntime();
		ExecProcessResult result = InteropFactory.eINSTANCE
				.createExecProcessResult();

		try {

			Process process = runtime.exec(
					cmdArray.toArray(new String[cmdArray.size()]), null, null);

			if (cmd.getStdin() != null && cmd.getStdin().length() > 0) {
				Writer stdin = new BufferedWriter(new OutputStreamWriter(
						process.getOutputStream()));
				stdin.write(cmd.getStdin());
				stdin.flush();
			}
			process.getOutputStream().close();

			Executor executor = new Executor(process);
			executor.start();
			try {
				if (cmd.getTimeout() > 0) {
					executor.join(cmd.getTimeout() * 1000);
					executor.interrupt(); // To sync exitCode and output streams
					executor.join();
				} else
					executor.join();

				if (executor.exitCode == null)
					return error("Timeout period elapsed. Terminating.");
				else {
					result.setExitCode(process.exitValue());
					result.setStdout(executor.stdout);
					result.setStderr(executor.stderr);

					if (!cmd.isIgnoreExitCode() && result.getExitCode() != 0)
						return error("Execution failed, exit code: %s. stderr:\n %s",
								result.getExitCode(), result.getStderr());

					if (!cmd.isIgnoreStderr()
							&& result.getStderr().length() > 0)
						return error("Execution failed, stderr:\n%s.",
								result.getStderr());
				}
			} catch (InterruptedException e) {
				executor.interrupt();
				return error(e.getMessage());
			} finally {
				process.destroy();
			}

		} catch (IOException e) {
			return error(e.getMessage());
		}

		context.getOutput().write(result);
		return Status.OK_STATUS;
	}

	private static class ReaderReader extends Thread {

		private Reader reader;
		private StringBuffer buffer;

		private ReaderReader(Reader reader, StringBuffer buffer) {
			this.reader = reader;
			this.buffer = buffer;
		}

		@Override
		public void run() {
			char[] chars = new char[4 * 1024];
			while (!isInterrupted()) {
				try {
					int read = reader.read(chars);
					if (read == -1)
						break;
					buffer.append(chars, 0, read);
				} catch (IOException e) {
					break;
				}
			}
		}

	}

	private static class Executor extends Thread {

		private final Process process;

		public Integer exitCode = null;
		public String stdout = "";
		public String stderr = "";

		private Executor(Process process) {
			this.process = process;
		}

		@Override
		public void run() {
			StringBuffer stdoutBuffer = new StringBuffer();
			ReaderReader stdoutReader = new ReaderReader(new BufferedReader(
					new InputStreamReader(process.getInputStream())),
					stdoutBuffer);

			StringBuffer stderrBuffer = new StringBuffer();
			ReaderReader stderrReader = new ReaderReader(new BufferedReader(
					new InputStreamReader(process.getErrorStream())),
					stderrBuffer);

			try {
				stdoutReader.start();
				stderrReader.start();

				exitCode = process.waitFor();

				stdoutReader.join();
				stderrReader.join();
			} catch (InterruptedException ignore) {
				return;
			} finally {
				stdoutReader.interrupt();
				stderrReader.interrupt();

				stdout = stdoutBuffer.toString();
				stderr = stderrBuffer.toString();
			}
		}

	}
}
