package org.eclipse.rcptt.tesla.recording.aspects.swt.rap;

import org.eclipse.rap.rwt.SingletonUtil;
import org.eclipse.rap.rwt.scripting.ClientListener;

public class AssertionClientListener extends ClientListener {

	private static final long serialVersionUID = 1L;

	public static AssertionClientListener getInstance() {
		return SingletonUtil.getSessionInstance(AssertionClientListener.class);
	}

	private AssertionClientListener() {
		super(getCode());
	}

	private static String getCode() {
		return "var handleEvent = function( event ) {"
				+ "console.log(event.widget.getData('myOtherWidget'));"
				+" var id = rwt.remote.ObjectRegistry.getId( event.widget); " + System.lineSeparator()
				+ "rwt.client.rcptt.Assertion.getInstance().setActiveWidget(id);" + " };";
	}

}
