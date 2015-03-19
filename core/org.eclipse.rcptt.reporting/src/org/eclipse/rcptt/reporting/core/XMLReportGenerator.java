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
package org.eclipse.rcptt.reporting.core;

import static org.eclipse.rcptt.util.StringUtils.getUtf8Bytes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.Q7Statistics;
import org.eclipse.rcptt.reporting.internal.Q7ReportingPlugin;
import org.eclipse.rcptt.reporting.internal.XMLUtils;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XMLReportGenerator {
	private Document newDocument;
	private Report report;

	public String generateContent(Report report) throws CoreException {
		this.report = report;
		newDocument = XMLUtils.createDocument();
		Node nodes = report.getRoot();
		Element rootElement = newDocument.createElement("node");
		newDocument.appendChild(rootElement);

		EList<EventSource> sources = report.getSources();
		for (EventSource source : sources) {
			Element cElement = newDocument.createElement("eventSource");
			cElement.setAttribute("name", source.getName());

			processAttributes(cElement, source.getProperties());
			int val = sources.indexOf(source);
			cElement.setAttribute("index", Integer.toString(val));
			rootElement.appendChild(cElement);
		}
		
		processAttributes(rootElement, nodes.getProperties());				
		rootElement.setAttribute("name", getCombinedVariantName(nodes));
		
		EList<Node> children = nodes.getChildren();
		for (Node node : children) {
			printNode(node, rootElement);
		}

		return XMLUtils.toString(newDocument);
	}

	private void processAttributes(Element cElement, EMap<String, EObject> list) {
		for (String key : list.keySet()) {
			EObject obj = list.get(key);
			if (obj instanceof Q7Info) {
				toStringAttrs(cElement, obj, "");
			} else if (obj instanceof Q7Statistics) {
				toStringAttrs(cElement, obj, "");
			} else {
				toString(cElement, obj);
			}
		}
	}

	private String getCombinedVariantName(Node node) {
		Q7Info info = (Q7Info) node.getProperties()
				.get(IQ7ReportConstants.ROOT);
		String name;		
		if (info != null && info.getVariant() != null && info.getVariant().size() != 0) {			
			name = node.getName() + "_" + ReportUtils.combineNames(info.getVariant(),"_");
		} else {
			name = node.getName();
		}				
		return name;
	}
	
	private void printNode(Node infoNode, Element element) {

		Element nodeElement = newDocument.createElement("node");
		element.appendChild(nodeElement);
				
		nodeElement.setAttribute("name", getCombinedVariantName(infoNode));
		// nodeElement.setAttribute("startTime",
		// Long.toString(infoNode.getStartTime()));
		// nodeElement.setAttribute("terminateTime",
		// Long.toString(infoNode.getEndTime()));
		nodeElement.setAttribute("totalTime",
				Long.toString(infoNode.getEndTime() - infoNode.getStartTime()));

		processAttributes(nodeElement, infoNode.getProperties());
		if (!infoNode.getChildren().isEmpty()) {
			// Element childrenElement = newDocument.createElement("children");
			// nodeElement.appendChild(childrenElement);
			for (Node child : infoNode.getChildren()) {
				printNode(child, nodeElement);
			}
		}
		if (!infoNode.getEvents().isEmpty()) {
			Element childrenElement = newDocument.createElement("events");
			nodeElement.appendChild(childrenElement);
			for (Event child : infoNode.getEvents()) {
				printEvent(child, childrenElement);
			}
		}

		if (!infoNode.getSnapshots().isEmpty()) {
			Element childrenElement = newDocument.createElement("snapshots");
			nodeElement.appendChild(childrenElement);
			for (Snaphot child : infoNode.getSnapshots()) {
				printSnapshot(child, childrenElement);
			}
		}
	}

	private void printEvent(Event child, Element childrenElement) {
		Element eventElement = newDocument.createElement("event");
		childrenElement.appendChild(eventElement);

		eventElement.setAttribute("time", Long.toString(child.getTime()));
		if (child.getSource() != null) {
			eventElement.setAttribute(
					"source",
					Integer.toString(report.getSources().indexOf(
							child.getSource())));
		}
		if (child.getKind() != null) {
			eventElement.setAttribute("kind", child.getKind().name());
		}
		if (child.getColor() != null) {
			eventElement.setAttribute("color", child.getColor());
		}

		processAttributes(eventElement, child.getProperties());
		if (child.getData() != null) {
			toString(eventElement, child.getData());
		}
	}

	private void printSnapshot(Snaphot child, Element element) {
		Element e = newDocument.createElement("snapshot");
		element.appendChild(e);

		processAttributes(e, child.getProperties());
		if (child.getData() != null) {
			toString(e, child.getData());
		}
	}

	@SuppressWarnings("rawtypes")
	public void toString(Element element, EObject obj, String... ignores) {
		if (obj == null) {
			return;
		}
		EClass eClass = obj.eClass();

		Element eobjElement = newDocument.createElement("eobject");
		element.appendChild(eobjElement);

		eobjElement.setAttribute("class", eClass.getName());
		// eobjElement.setAttribute("ePackage",
		// eClass.getEPackage().getNsURI());

		EList<EAttribute> eAllAttributes = eClass.getEAllAttributes();
		for (EAttribute eAttribute : eAllAttributes) {
			Object eGet = obj.eGet(eAttribute);
			if (eGet != null) {
				boolean needArg = true;
				Object defaultValue = eAttribute.getDefaultValue();
				needArg = (defaultValue == null || !defaultValue.equals(eGet));

				if (eGet instanceof List && ((List<?>) eGet).size() == 0) {
					needArg = false;
				}
				for (String ignore : ignores) {
					if (ignore.equals(eAttribute.getName())) {
						needArg = false;
						break;
					}
				}
				if (needArg) {
					if (eGet instanceof List) {
						for (Object o : (List) eGet) {
							Element ee = newDocument.createElement(eAttribute
									.getName());
							eobjElement.appendChild(ee);
							Text e = newDocument.createTextNode(o.toString());
							ee.appendChild(e);
						}
					} else {
						eobjElement.setAttribute(eAttribute.getName(),
								eGet.toString());
					}
				}
			}
		}
		EList<EReference> features = eClass.getEAllReferences();
		for (EReference f : features) {
			Object eGet = obj.eGet(f);
			boolean needArg = true;
			for (String ignore : ignores) {
				if (ignore.equals(f.getName())) {
					needArg = false;
					break;
				}
			}
			if (!needArg) {
				continue;
			}
			if (eGet != null && needArg) {
				Element e = newDocument.createElement(f.getName());
				eobjElement.appendChild(e);

				if (eGet instanceof EObject) {
					toString(e, (EObject) eGet, "eFactoryInstance");
				} else if (eGet instanceof EList) {
					EList l = (EList) eGet;
					for (int i = 0; i < l.size(); i++) {
						Object va = l.get(i);
						if (va instanceof EObject) {
							toString(e, (EObject) va, "eFactoryInstance");
						}
					}
				}
			}
		}
	}

	public void toStringAttrs(Element element, EObject obj, String prefix,
			String... ignores) {
		if (obj == null) {
			return;
		}
		EClass eClass = obj.eClass();

		EList<EAttribute> eAllAttributes = eClass.getEAllAttributes();
		for (EAttribute eAttribute : eAllAttributes) {
			Object eGet = obj.eGet(eAttribute);
			if (eGet != null) {
				boolean needArg = true;
				Object defaultValue = eAttribute.getDefaultValue();
				needArg = (defaultValue == null || !defaultValue.equals(eGet));

				if (eGet instanceof List && ((List<?>) eGet).size() == 0) {
					needArg = false;
				}
				for (String ignore : ignores) {
					if (ignore.equals(eAttribute.getName())) {
						needArg = false;
						break;
					}
				}
				if (needArg) {
					if (!(eGet instanceof List)) {
						element.setAttribute(prefix + eAttribute.getName(),
								eGet.toString());
					}
				}
			}
		}
	}

	public void generateContent(OutputStream stream, String reportName,
			Iterable<Report> reports, Q7Statistics statistics)
			throws CoreException {
		try {
			stream.write(getUtf8Bytes("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>\n"));
			stream.write(getUtf8Bytes(String.format("<report name=\"%s\">",
					reportName)));
			Iterator<Report> report = reports.iterator();
			while (report.hasNext()) {
				Report r = report.next();
				String s = generateContent(r);
				int pos = s.indexOf("?>");
				s = s.substring(pos + 2);
				stream.write(getUtf8Bytes(s));
			}
			stream.write(getUtf8Bytes("\n</report>"));
		} catch (IOException e) {
			Q7ReportingPlugin.log(e);
		}
	}
}
