package org.eclipse.rcptt.launching.multiaut.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.AllProjectScope;
import org.eclipse.rcptt.launching.Aut;
import org.eclipse.rcptt.launching.multiaut.LaunchStoreEntry;
import org.eclipse.rcptt.ui.controls.TestSuiteButtonsPanel;
import org.eclipse.rcptt.ui.launching.aut.AutContentProvider;
import org.eclipse.rcptt.ui.launching.aut.AutElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class MultiAutLaunchTab extends AbstractLaunchConfigurationTab {
	private TableViewer entriesViewer;

	private static class ColumnManager {
		private final TableColumnLayout columnLayout = new TableColumnLayout();
		private final TableViewer viewer;

		ColumnManager(TableViewer viewer) {
			this.viewer = viewer;
			this.viewer.getTable().getParent().setLayout(columnLayout);
		}

		TableViewerColumn add(String name) {
			final TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText(name);
			columnLayout.setColumnData(column.getColumn(), new ColumnWeightData(1));
			return column;
		}

	}
	@Override
	public void createControl(Composite parent) {
		Composite content = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(content);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(content);

		Composite tableContainer = new Composite(content, SWT.NONE);
		GridLayoutFactory.swtDefaults().applyTo(tableContainer);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(tableContainer);
		entriesViewer = new TableViewer(tableContainer);

		ColumnManager columns = new ColumnManager(entriesViewer);

		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).hint(1, 1)
				.applyTo(entriesViewer.getControl());

		final TableViewerColumn testColumn = columns.add("Test");
		final TableViewerColumn autColumn = columns.add("AUT");
		final TableViewerColumn restartColumn = columns.add("Restart");
		restartColumn.getColumn().setToolTipText("Whether to restart AUT before test case");
		entriesViewer.getTable().setHeaderVisible(true);
		entriesViewer.getTable().setLinesVisible(true);
		entriesViewer.getTable().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateButtons();
			}
		});
		Composite buttons = new Composite(content, SWT.NONE);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, true).applyTo(buttons);
		GridLayoutFactory.swtDefaults().numColumns(1).applyTo(buttons);
		Button add = new Button(buttons, SWT.PUSH);
		add.setText("Add test...");
		add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addTestCase();
			}
		});

		remove = new Button(buttons, SWT.PUSH);
		remove.setText("Remove");
		remove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeSelectedTests();
			}
		});

		setAut = new Button(buttons, SWT.PUSH);
		setAut.setText("Set AUT...");
		setAut.setToolTipText("Set AUT for selected test cases");
		setAut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setAut();
			}

		});

		up = new Button(buttons, SWT.PUSH);
		up.setText("Move up");
		up.setToolTipText("Move selected test up");
		up.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveUp();
			}
		});

		down = new Button(buttons, SWT.PUSH);
		down.setText("Move down");
		down.setToolTipText("Move selected test down");
		down.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveDown();
			}
		});

		GridDataFactory buttonsFactory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false);
		buttonsFactory.applyTo(add);
		buttonsFactory.applyTo(remove);
		buttonsFactory.applyTo(setAut);
		buttonsFactory.applyTo(up);
		buttonsFactory.applyTo(down);

		entriesViewer.setContentProvider(new MultiAutContentProvider());
		entriesViewer.setLabelProvider(new MultiAutLabelProvider());
		entriesViewer.setInput(entries);

		testColumn.getColumn().pack();
		autColumn.getColumn().pack();
		restartColumn.getColumn().pack();
		restartColumn.setEditingSupport(new EditingSupport(entriesViewer) {
			@Override
			protected void setValue(Object element, Object value) {
				((LaunchUIEntry) element).restart = (Boolean) value;
				entriesViewer.refresh(element);
				updateLaunchConfigurationDialog();
			}

			@Override
			protected Object getValue(Object element) {
				return ((LaunchUIEntry) element).restart;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return new CheckboxCellEditor(entriesViewer.getTable());
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});

		autColumn.setEditingSupport(new EditingSupport(entriesViewer) {
			@Override
			protected void setValue(Object element, Object value) {
				((LaunchUIEntry) element).aut = ((AutElement) value).getAut();
				entriesViewer.refresh(element);
				updateLaunchConfigurationDialog();
			}

			@Override
			protected Object getValue(Object element) {
				LaunchUIEntry entry = (LaunchUIEntry) element;
				return entry.aut == null ? null : new AutElement(entry.aut);
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				ComboBoxViewerCellEditor result = new ComboBoxViewerCellEditor(entriesViewer.getTable());
				result.setContentProvider(new AutContentProvider());
				result.setLabelProvider(new AUTLabelProvider());
				result.setInput(new Object());
				return result;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}
		});
		setControl(content);
		refreshViewer();
	}

	protected void moveDown() {
		LaunchUIEntry entry = (LaunchUIEntry) ((IStructuredSelection) entriesViewer.getSelection()).getFirstElement();
		int index = entries.indexOf(entry);
		Collections.swap(entries, index, index + 1);
		refreshViewer();
		entriesViewer.setSelection(new StructuredSelection(entry), true);
	}

	protected void moveUp() {
		LaunchUIEntry entry = (LaunchUIEntry) ((IStructuredSelection) entriesViewer.getSelection()).getFirstElement();
		int index = entries.indexOf(entry);
		Collections.swap(entries, index - 1, index);
		refreshViewer();
		entriesViewer.setSelection(new StructuredSelection(entry), true);
	}

	private List<LaunchUIEntry> entries = new ArrayList<LaunchUIEntry>();
	private Button up;
	private Button down;
	private Button setAut;
	private Button remove;

	private void setAut() {
		Aut aut = SelectAutDialog.selectAut(getShell());
		if (aut == null) {
			return;
		}

		for (Object entry : ((IStructuredSelection) entriesViewer.getSelection()).toArray()) {
			((LaunchUIEntry) entry).aut = aut;
		}
		refreshViewer();
	}

	private void updateButtons() {
		// IStructuredSelection selection = (IStructuredSelection) entriesViewer.getSelection();
		int[] selectionIndices = entriesViewer.getTable().getSelectionIndices();
		up.setEnabled(selectionIndices.length == 1 && selectionIndices[0] > 0);
		down.setEnabled(selectionIndices.length == 1 && selectionIndices[0] < entries.size() - 1);
		setAut.setEnabled(selectionIndices.length > 0);
		remove.setEnabled(selectionIndices.length > 0);
	}

	private void addTestCase() {
		IQ7NamedElement[] selected = TestSuiteButtonsPanel.selectTestCase(new AllProjectScope(),
				Collections.<IQ7NamedElement> emptyList(), false);
		boolean changed = false;
		for (IQ7NamedElement element : selected) {
			LaunchUIEntry uiEntry = LaunchUIEntry.fromNamedElement(element);
			if (uiEntry != null) {
				entries.add(uiEntry);
				changed = true;
			}
		}

		if (changed) {
			refreshViewer();
		}
	}

	private void removeSelectedTests() {
		IStructuredSelection selection = (IStructuredSelection) entriesViewer.getSelection();
		boolean changed = false;
		for (Object element : selection.toArray()) {
			entries.remove(element);
			changed = true;
		}
		if (changed) {
			refreshViewer();
		}
	}

	private void refreshViewer() {
		entriesViewer.refresh();
		updateButtons();
		updateLaunchConfigurationDialog();
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// Nothing to do
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		configToUI(LaunchStoreEntry.entriesFromConfig(configuration));
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		LaunchStoreEntry.entriesToConfig(entriesFromUI(), configuration);
	}

	@Override
	public String getName() {
		return "Test Cases";
	}

	private void configToUI(LaunchStoreEntry[] entries) {
		this.entries.clear();
		for (LaunchStoreEntry storeEntry : entries) {
			LaunchUIEntry uiEntry = LaunchUIEntry.fromStoreEntry(storeEntry);
			if (uiEntry == null) {
				continue;
			}
			this.entries.add(uiEntry);
		}
		refreshViewer();
	}

	private LaunchStoreEntry[] entriesFromUI() {
		List<LaunchStoreEntry> result = new ArrayList<LaunchStoreEntry>();
		for (LaunchUIEntry entry : entries) {
			LaunchStoreEntry storeEntry = entry.toStoreEntry();
			if (storeEntry != null) {
				result.add(storeEntry);
			}
		}
		return result.toArray(new LaunchStoreEntry[result.size()]);
	}
}