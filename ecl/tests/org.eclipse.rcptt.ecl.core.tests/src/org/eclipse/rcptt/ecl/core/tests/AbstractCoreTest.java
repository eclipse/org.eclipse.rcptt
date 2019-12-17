/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.core.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Exec;
import org.eclipse.rcptt.ecl.core.ExecutableParameter;
import org.eclipse.rcptt.ecl.core.LiteralParameter;
import org.eclipse.rcptt.ecl.core.Parallel;
import org.eclipse.rcptt.ecl.core.Pipeline;
import org.eclipse.rcptt.ecl.core.Sequence;
import org.eclipse.rcptt.ecl.core.tests.model.EmitData;
import org.eclipse.rcptt.ecl.core.tests.model.IsPipeEmpty;
import org.eclipse.rcptt.ecl.core.tests.model.ModelFactory;
import org.eclipse.rcptt.ecl.core.tests.model.SampleCommand;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;

public abstract class AbstractCoreTest extends TestCase {

	public final static String PLUGIN_ID = "org.eclipse.rcptt.ecl.core.tests";

	private final static String TEST_NS = "http://www.eclipse.org/ecl/tests/model.ecore";

	protected ISession session;

	private static int count;

	public static synchronized void inc() {
		count++;
	}

	public static synchronized void reset() {
		count = 0;
	}

	public static synchronized int getCount() {
		return count;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		session = createSession();
	}

	protected abstract ISession createSession() throws Exception;

	@Override
	protected void tearDown() throws Exception {
		if (session != null)
			session.close();
		super.tearDown();
	}

	private SampleCommand createTestCommand(String s) {
		SampleCommand testCommand = ModelFactory.eINSTANCE.createSampleCommand();
		testCommand.setHello(s);
		return testCommand;
	}

	public void testHWCommand() throws Exception {
		IProcess rc = session.execute(createTestCommand("world"));
		assertEquals("Hello, world", rc.waitFor().getMessage());
	}

	public void testExecSequence() throws Exception {
		reset();
		Sequence seq = CoreFactory.eINSTANCE.createSequence();
		seq.getCommands().add(createTestCommand("1"));
		seq.getCommands().add(createTestCommand("2"));
		seq.getCommands().add(createTestCommand("3"));
		IProcess rc = session.execute(seq);
		assertEquals("Hello, 3", rc.waitFor().getMessage());
		assertEquals(3, getCount());
	}

	public void testExecParallel() throws Exception {
		// ISession session = EclRuntime.createSession();
		reset();
		Parallel seq = CoreFactory.eINSTANCE.createParallel();
		seq.getCommands().add(createTestCommand("1"));
		seq.getCommands().add(ModelFactory.eINSTANCE.createSlowCommand());
		seq.getCommands().add(createTestCommand("3"));
		IProcess rc = session.execute(seq);
		Thread.sleep(1000);
		assertEquals(2, getCount());
		rc.waitFor();
		assertEquals(3, getCount());
	}

	public void testPipeline() throws Exception {
		Pipeline pipeline = CoreFactory.eINSTANCE.createPipeline();
		pipeline.getCommands().add(ModelFactory.eINSTANCE.createIncrementCommand());
		pipeline.getCommands().add(ModelFactory.eINSTANCE.createIncrementCommand());
		pipeline.getCommands().add(ModelFactory.eINSTANCE.createIncrementCommand());

		IPipe source = session.createPipe();
		IPipe sink = session.createPipe();

		source.write(new Integer(42));
		source.close(Status.OK_STATUS);

		session.execute(pipeline, source, sink);

		Integer res = (Integer) sink.take(Long.MAX_VALUE);
		assertEquals(45, res.intValue());
	}

	/*
	 * Execute "EmitData 42" via Exec
	 */
	public void testExec1() throws Exception {
		// ISession session = EclRuntime.createSession();
		Exec exec = CoreFactory.eINSTANCE.createExec();
		exec.setNamespace(TEST_NS);
		exec.setName("EmitData");
		LiteralParameter param = CoreFactory.eINSTANCE.createLiteralParameter();
		param.setLiteral("42");
		exec.getParameters().add(param);

		IPipe pipe = session.createPipe();
		session.execute(exec, null, pipe);

		Integer res = (Integer) pipe.take(ISession.DEFAULT_TAKE_TIMEOUT);
		assertEquals(42, res.intValue());
	}

	public void testReadFromFinishedCommand() throws Exception {
		// ISession session = EclRuntime.createSession();
		Exec exec = CoreFactory.eINSTANCE.createExec();
		exec.setNamespace(TEST_NS);
		exec.setName("EmitEMFData");
		LiteralParameter param = CoreFactory.eINSTANCE.createLiteralParameter();
		param.setLiteral("42");
		exec.getParameters().add(param);

		IProcess process = session.execute(exec);
		IStatus status = process.waitFor();
		assertTrue(status.isOK());
		IPipe pipe = process.getOutput();
		Object res = pipe.take(ISession.DEFAULT_TAKE_TIMEOUT);
		assertEquals(42, ((Integer) res).intValue());
	}

	/*
	 * Execute: "EmitData [EmitData 42]" via Exec
	 */
	public void testExec2() throws Exception {
		// ISession session = EclRuntime.createSession();

		EmitData subcommand = ModelFactory.eINSTANCE.createEmitData();
		subcommand.setParamInt(42);

		Exec exec = CoreFactory.eINSTANCE.createExec();
		exec.setNamespace(TEST_NS);
		exec.setName("EmitData");
		ExecutableParameter param = CoreFactory.eINSTANCE.createExecutableParameter();
		param.setCommand(subcommand);
		exec.getParameters().add(param);

		IPipe pipe = session.createPipe();
		session.execute(exec, null, pipe);

		Integer res = (Integer) pipe.take(ISession.DEFAULT_TAKE_TIMEOUT);
		assertEquals(42, res.intValue());
	}

	public void testIsPipeEmpty() throws Exception {
		// ISession session = EclRuntime.createSession();

		Exec exec = CoreFactory.eINSTANCE.createExec();
		exec.setNamespace(TEST_NS);
		exec.setName("IsPipeEmpty");

		IPipe pipe = session.createPipe();
		IProcess p = session.execute(exec, null, pipe); // ??
		assertTrue(p.waitFor().isOK());
		boolean res = (Boolean) pipe.take(ISession.DEFAULT_TAKE_TIMEOUT);
		assertEquals(true, res);
	}

	public void testIsPipeEmpty2() throws Exception {
		// ISession session = EclRuntime.createSession();

		IsPipeEmpty command = ModelFactory.eINSTANCE.createIsPipeEmpty();

		Pipeline pipeline = CoreFactory.eINSTANCE.createPipeline();
		pipeline.getCommands().add(command);
		pipeline.getCommands().add(command);

		IPipe pipe = session.createPipe();
		IProcess p = session.execute(pipeline, null, pipe);
		p.waitFor();
		boolean res = (Boolean) pipe.take(ISession.DEFAULT_TAKE_TIMEOUT);
		assertEquals(true, res);
	}

	public static void main(String[] args) throws Throwable {
		Integer i = 42;
		if (i instanceof Serializable) {
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ObjectOutputStream stream = new ObjectOutputStream(bout);
			stream.writeObject(i);
			bout.flush();
			bout.close();
			byte[] byteArray = bout.toByteArray();
			ByteArrayInputStream in = new ByteArrayInputStream(byteArray);
			ObjectInputStream oin = new ObjectInputStream(in);
			Object readObject = oin.readObject();
			System.out.println(readObject);
		}
	}

}
