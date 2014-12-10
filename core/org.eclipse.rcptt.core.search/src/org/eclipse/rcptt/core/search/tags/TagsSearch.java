package org.eclipse.rcptt.core.search.tags;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.search.tags.parser.TagsLexer;
import org.eclipse.rcptt.core.search.tags.parser.TagsParser;

public class TagsSearch {
	
	/**
	 * Finds IQ7Elements by tags expression.
	 * 
	 * E.g.: tag1 OR tag2 AND "tag 3"
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
		try {
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new TagsLexer(input));
			
			TagsParser parser = new TagsParser(tokens);
			TagsParser.expression_return ret = parser.expression();
			ast = (CommonTree) ret.getTree();
		} catch (RecognitionException e) {
		}
		
		return ast;
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
			
			if (tree.getType() == TagsParser.AND) {
				if (tree.getChildren() == null) {
					return false;
				} else {
					boolean result = true;
					for (Object subtree : tree.getChildren()) {
						if (eval((CommonTree) subtree, tags) == false) {
							result = false;
							break;
						}
					}
					return result;
				}
			}
			
			if (tree.getType() == TagsParser.OR) {
				if (tree.getChildren() == null) {
					return false;
				} else {
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
		}
		
		return false;
	}
	
}