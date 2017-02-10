/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.ecl.model;

import static org.eclipse.rcptt.core.workspace.Q7Utils.safeGetId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.core.scenario.ScenarioProperty;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.core.ecl.model.providers.DeclarationFactory;
import org.eclipse.rcptt.core.ecl.parser.ast.Parser;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;
import org.eclipse.rcptt.core.ecl.parser.model.LocalContainer;
import org.eclipse.rcptt.core.internal.ecl.parser.Q7EclParserPlugin;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.core.model.Q7InternalTestCase;

public class Q7ElementContainer implements IDeclContainer {
	private IDeclContainer composite;
	private String resource;

	public final Script script;
	public int offset;
	private LocalContainer localDeclarations = null;
	private LocalContainer propertyDeclarations = null;
	private List<IDeclContainer> referenceDeclarations = new ArrayList<IDeclContainer>();
	private boolean buildins = true;
	private String text;
	private String referencesList;

	public Q7ElementContainer(IQ7NamedElement element, String text, int offset, boolean includeBuiltin) {
		resource = safeGetId(element);
		script = Parser.parse(text);
		this.text = text;
		this.offset = offset;
		this.buildins = includeBuiltin;
		localDeclarations = LocalContainer.fromScript(script, offset, resource);

		calculatePropertyDeclarations(element);

		referenceDeclarations = new ArrayList<IDeclContainer>();
		referencesList = calculateDependenciesHash(element);
		initReferences(element);

		initComposite();
	}

	/**
	* Add a testcase property declarations.
	*/
	private void calculatePropertyDeclarations(IQ7NamedElement element) {
		if( element == null) {
			return;
		}
		try {
			
			propertyDeclarations = new LocalContainer();
			NamedElement namedElement = element.getNamedElement();
			if (namedElement instanceof Scenario) {
				EList<ScenarioProperty> properties = ((Scenario) namedElement).getProperties();
				for (ScenarioProperty sp : properties) {
					propertyDeclarations.addVar(new VarDecl(sp.getName(), new SrcLoc(0, 0)));
				}
			}
		} catch (ModelException e) {
			Q7EclParserPlugin.log(e);
		}
	}

	public boolean isSameContent(String value, IQ7NamedElement element) {
		String hash = calculateDependenciesHash(element);
		return this.text.equals(value) && this.referencesList.equals(hash);
	}

	private String calculateDependenciesHash(IQ7NamedElement element) {
		StringBuilder bb = new StringBuilder();
		for (IContext context : getReferencedContexts(element)) {
			try {
				bb.append("_").append(context.getID());
			} catch (ModelException e) {
				RcpttPlugin.log(e);
			}
		}
		if (element != null && element.isWorkingCopy() && element instanceof ITestCase) {
			String[] ctxs;
			try {
				ctxs = ((ITestCase) element).getContexts();
				if (ctxs != null) {
					for (String ctx : ctxs) {
						bb.append("_").append(ctx);
					}
				}
			} catch (ModelException e) {
				RcpttPlugin.log(e);
			}
		}
		return bb.toString();
	}

	public void setOffset(int offset) {
		this.offset = offset;
		localDeclarations = LocalContainer.fromScript(script, offset, resource);
		initComposite();
	}

	private void initComposite() {
		List<IDeclContainer> all = new ArrayList<IDeclContainer>();
		if (localDeclarations != null) {
			all.add(localDeclarations);
		}
		all.addAll(referenceDeclarations);
		if (buildins) {
			all.add(BuiltinContainer.INSTANCE);
		}
		all.add(propertyDeclarations);
		composite = new CompositeContainer(all.toArray(new IDeclContainer[0]));
	}

	private void initReferences(IQ7NamedElement element) {
		IContext[] referenced = getReferencedContexts(element);
		for (IContext context : referenced) {
			IDeclContainer container = DeclarationFactory.INSTANCE.safeFromContext(context);
			if (container != null) {
				referenceDeclarations.add(container);
			}
		}
	}

	private static IContext[] getReferencedContexts(IQ7NamedElement element) {
		if (element == null) {
			return new IContext[0];
		}

		try {
			List<IContext> result = new ArrayList<IContext>();
			if (element instanceof Q7InternalTestCase) {
				Scenario scenario = ((Q7InternalTestCase) element).getNamedElement();
				for (String id : scenario.getContexts()) {
					IQ7NamedElement ref = Q7SearchCore.findById(id);
					if (!(ref instanceof IContext)) {
						continue;
					}
					result.add((IContext) ref);
				}
				return result.toArray(new IContext[result.size()]);

			}
			if (element instanceof ITestCase) {

				String[] ids = ((ITestCase) element).getContexts();
				return RcpttCore.getInstance().getContexts((ITestCase) element, Arrays.asList(ids), null, true);
			}

			IQ7ProjectMetadata metadata = element.getQ7Project().getMetadata();
			if (metadata.exists()) {
				String[] ids = metadata.getContexts();

				for (String id : ids) {
					IQ7NamedElement ref = Q7SearchCore.findById(id);
					if (!(ref instanceof IContext)) {
						continue;
					}
					result.add((IContext) ref);
				}
			}
			return result.toArray(new IContext[result.size()]);
		} catch (ModelException e) {
			return new IContext[0];
		}
	}

	@Override
	public String getResource() {
		return resource;
	}

	@Override
	public ProcDecl resolveProc(String name) {
		return composite.resolveProc(name);
	}

	@Override
	public VarDecl resolveVar(String name) {
		return composite.resolveVar(name);
	}

	@Override
	public ProcDecl[] getProcs() {
		return composite.getProcs();
	}

	@Override
	public VarDecl[] getVars() {
		return composite.getVars();
	}

	public void includeBuildins(boolean b) {
		this.buildins = b;
	}

}
