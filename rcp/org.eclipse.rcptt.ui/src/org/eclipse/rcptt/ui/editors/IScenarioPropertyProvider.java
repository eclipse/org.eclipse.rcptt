package org.eclipse.rcptt.ui.editors;

import java.util.List;

import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.ui.controls.SuggestionItem;

public interface IScenarioPropertyProvider {

	public List<SuggestionItem> getProperties(Scenario scenario);

	public List<SuggestionItem> getPropertyValues(String name);

}
