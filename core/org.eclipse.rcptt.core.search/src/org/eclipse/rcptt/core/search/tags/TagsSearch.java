/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.search.tags;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.search.tags.parser.TagsLexer;
import org.eclipse.rcptt.core.search.tags.parser.TagsParser;

public class TagsSearch {
	
	private static List<RecognitionException> errors = new ArrayList<RecognitionException>();

	/**
	 * Finds IQ7Elements by tags expression.
	 * 
	 * E.g.: tag1 OR ("tag 2" AND !tag3)
	 * 
	 * @param expression
	 * @return
	 */
	public static IQ7NamedElement[] findAllByExpression(String expression) {
		CommonTree tree = createTree(expression);
		if (tree == null) {
			return new IQ7NamedElement[0];
		}
		
		List<IQ7NamedElement> result = new ArrayList<IQ7NamedElement>();
		Map<IQ7NamedElement, List<String>> tagsRefsMap = Q7SearchCore.findAllTagReferences();
		for (Map.Entry<IQ7NamedElement, List<String>> entry : tagsRefsMap.entrySet()) {
			if (eval(tree, entry.getValue())) {
				result.add(entry.getKey());
			}
		}
		
		return result.toArray(new IQ7NamedElement[result.size()]);
	}
	
	/**
	 * Creates boolean AST.
	 * 
	 * @param expression
	 * @return
	 */
	private static CommonTree createTree(String expression) {
		CommonTree ast = null;
		errors.clear();
		try {
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TagsLexer lexer = new TagsLexer(input);
			TokenStream tokens = new CommonTokenStream(lexer);
			
			TagsParser parser = new TagsParser(tokens);
			TagsParser.expression_return ret = parser.expression();
			ast = (CommonTree) ret.getTree();

			if (lexer.hasErrors())
				errors.addAll(lexer.getAllErrors());
			if (parser.hasErrors())
				errors.addAll(parser.getAllErrors());
		} catch (RecognitionException e) {
		}
		
		return ast;
	}
	
	/**
	 * @return All errors found during last run.
	 */
	public static List<RecognitionException> getAllErrors() {
		return errors;
	}

	/**
	 * Checks if parentheses are not correct during last run.
	 * 
	 * @return
	 */
	public static boolean isParenthesesMissed() {
		for (RecognitionException e : getAllErrors()) {
			if (e instanceof MismatchedTokenException) {
				MismatchedTokenException mte = (MismatchedTokenException) e;
				if (mte.expecting == TagsParser.LPAREN || mte.expecting == TagsParser.RPAREN) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Evaluates boolean AST.
	 * 
	 * @param tree
	 * @param tags
	 * @return
	 */
	private static boolean eval(CommonTree tree, List<String> tags) {
		if (tree != null) {
			if (tree.getType() == TagsParser.NAME) {
				if (tags.contains(tree.getText())) {
					return true;
				} else {
					return false;
				}
			}
			
			if (tree.getType() == TagsParser.NOT && tree.getChildren() != null) {
				return !eval((CommonTree) tree.getChild(0), tags);
			}
			
			if (tree.getType() == TagsParser.AND && tree.getChildren() != null) {
				boolean result = true;
				for (Object subtree : tree.getChildren()) {
					if (eval((CommonTree) subtree, tags) == false) {
						result = false;
						break;
					}
				}
				return result;
			}
			
			if (tree.getType() == TagsParser.OR && tree.getChildren() != null) {
				boolean result = false;
				for (Object subtree : tree.getChildren()) {
					if (eval((CommonTree) subtree, tags) == true) {
						result = true;
						break;
					}
				}
				return result;
			}
		}
		
		return false;
	}

	/**
	 * For debug purposes.
	 * 
	 * @param ast
	 */
	private static void printTree(CommonTree ast) {
		print(ast, 0);
	}

	/**
	 * For debug purposes.
	 * 
	 * @param tree
	 * @param level
	 */
	private static void print(CommonTree tree, int level) {
		for (int i = 0; i < level; i++)
			System.out.print("--");

		if (tree == null) {
			System.out.println(" null tree");
			return ;
		}

		System.out.println(" " + tree.getType() + " " + tree.getText());
		
		if (tree.getChildren() != null) {
			for (Object ie : tree.getChildren()) {
				print((CommonTree) ie, level + 1);
			}
		}
	}
	
}