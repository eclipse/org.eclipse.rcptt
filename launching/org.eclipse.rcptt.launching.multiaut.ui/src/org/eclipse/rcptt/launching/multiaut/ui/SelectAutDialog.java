package org.eclipse.rcptt.launching.multiaut.ui;

import org.eclipse.jface.window.Window;
import org.eclipse.rcptt.launching.Aut;
import org.eclipse.rcptt.ui.launching.aut.AutContentProvider;
import org.eclipse.rcptt.ui.launching.aut.AutElement;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;


/**
 * Not a dialog actually, though basic usage is the same
 */
public class SelectAutDialog {
	/**
	 * @return <code>null</code> if canceled
	 */
	public static Aut selectAut(Shell shell) {
		ListDialog dialog = new ListDialog(shell);
		dialog.setTitle("Select AUT");
		dialog.setInput(new Object());
		dialog.setContentProvider(new AutContentProvider());
		dialog.setLabelProvider(new AUTLabelProvider());

		if (dialog.open() != Window.OK) {
			return null;
		}

		Object[] result = dialog.getResult();
		if (result.length != 1) {
			return null;
		}

		Object first = result[0];
		if (!(first instanceof AutElement)) {
			return null;
		}

		return ((AutElement) first).getAut();
	}
}