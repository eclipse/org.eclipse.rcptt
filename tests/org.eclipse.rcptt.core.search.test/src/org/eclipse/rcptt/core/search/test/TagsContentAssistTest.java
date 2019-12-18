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
package org.eclipse.rcptt.core.search.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.eclipse.rcptt.core.search.tags.TagsContentAssist;
import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.core.tags.TagsFactory;
import org.junit.Test;

public class TagsContentAssistTest {

	@Test
	public void testEmpty() {
		ArrayList<String> offers = TagsContentAssist.getOffers("", getTags());

		assertEquals(4, offers.size());
		assertEquals("tag1", offers.get(0));
		assertEquals("\"tag with spaces\"", offers.get(1));
		assertEquals("\"!tag\"", offers.get(2));
		assertEquals("Tag&Tag", offers.get(3));
	}

	@Test
	public void testTag() {
		ArrayList<String> offers = TagsContentAssist.getOffers("tag", getTags());

		assertEquals(4, offers.size());
		assertEquals("tag1", offers.get(0));
		assertEquals("tag1/tag2", offers.get(1));
		assertEquals("\"tag with spaces\"", offers.get(2));
		assertEquals("Tag&Tag", offers.get(3));
	}

	@Test
	public void testTagWithOpenParenthesis() {
		ArrayList<String> offers = TagsContentAssist.getOffers("(tag", getTags());

		assertEquals(4, offers.size());
		assertEquals("(tag1", offers.get(0));
		assertEquals("(tag1/tag2", offers.get(1));
		assertEquals("(\"tag with spaces\"", offers.get(2));
		assertEquals("(Tag&Tag", offers.get(3));
	}

	@Test
	public void testTagWithCloseParenthesis() {
		ArrayList<String> offers = TagsContentAssist.getOffers("(tag) ", getTags());

		assertEquals(2, offers.size());
		assertEquals("(tag) OR", offers.get(0));
		assertEquals("(tag) AND", offers.get(1));
	}

	@Test
	public void testTag1() {
		ArrayList<String> offers = TagsContentAssist.getOffers("tag1", getTags());

		assertEquals(2, offers.size());
		assertEquals("tag1", offers.get(0));
		assertEquals("tag1/tag2", offers.get(1));
	}

	@Test
	public void testTag1Space() {
		ArrayList<String> offers = TagsContentAssist.getOffers("tag1 ", getTags());

		assertEquals(2, offers.size());
		assertEquals("tag1 OR", offers.get(0));
		assertEquals("tag1 AND", offers.get(1));
	}

	@Test
	public void testTag2() {
		ArrayList<String> offers = TagsContentAssist.getOffers("tag1/", getTags());

		assertEquals(1, offers.size());
		assertEquals("tag1/tag2", offers.get(0));
	}

	@Test
	public void testTagSpace() {
		ArrayList<String> offers = TagsContentAssist.getOffers("tag ", getTags());

		assertEquals(3, offers.size());
		assertEquals("\"tag with spaces\"", offers.get(0));
		assertEquals("tag OR", offers.get(1));
		assertEquals("tag AND", offers.get(2));
	}

	@Test
	public void testTag1And() {
		ArrayList<String> offers = TagsContentAssist.getOffers("tag1 AND ", getTags());

		assertEquals(4, offers.size());
		assertEquals("tag1 AND tag1", offers.get(0));
		assertEquals("tag1 AND \"tag with spaces\"", offers.get(1));
		assertEquals("tag1 AND \"!tag\"", offers.get(2));
		assertEquals("tag1 AND Tag&Tag", offers.get(3));
	}

	@Test
	public void testTag1AndNot() {
		ArrayList<String> offers = TagsContentAssist.getOffers("tag1 AND !", getTags());

		assertEquals(4, offers.size());
		assertEquals("tag1 AND !tag1", offers.get(0));
		assertEquals("tag1 AND !\"tag with spaces\"", offers.get(1));
		assertEquals("tag1 AND !\"!tag\"", offers.get(2));
		assertEquals("tag1 AND !Tag&Tag", offers.get(3));
	}

	/**
	 * Fills tags.
	 * 
	 * tag1
	 * tag1/tag2
	 * tag with spaces
	 * !tag
	 * Tag&Tag
	 * 
	 * @return ArrayList<Tag>
	 */
	private ArrayList<Tag> getTags() {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		Tag tag1 = TagsFactory.eINSTANCE.createTag();
		Tag tag2 = TagsFactory.eINSTANCE.createTag();
		Tag tagWs = TagsFactory.eINSTANCE.createTag();
		Tag tagNot = TagsFactory.eINSTANCE.createTag();
		Tag tagAnd = TagsFactory.eINSTANCE.createTag();

		tag1.setValue("tag1");
		tag2.setValue("tag2");
		tagWs.setValue("tag with spaces");
		tagNot.setValue("!tag");
		tagAnd.setValue("Tag&Tag");

		tag1.getTags().add(tag2);

		tags.add(tag1);
		tags.add(tagWs);
		tags.add(tagNot);
		tags.add(tagAnd);

		return tags;
	}
}
