package org.eclipse.rcptt.ui.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.ui.controls.SuggestionItem;

public class ScenarioPropertySuggestionProvider implements IScenarioPropertyProvider {

	@Override
	public List<SuggestionItem> getProperties(Scenario scenario) {
		List<SuggestionItem> properties = new ArrayList<SuggestionItem>();
		properties.add(new SuggestionItem("Issue-ID"));
		properties.add(new SuggestionItem("Creator"));
		properties.add(new SuggestionItem("Version"));
		return properties;
	}

	@Override
	public List<SuggestionItem> getPropertyValues(String name) {
		return null;
	}

}
