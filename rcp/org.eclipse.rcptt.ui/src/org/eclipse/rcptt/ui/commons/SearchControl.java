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
package org.eclipse.rcptt.ui.commons;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.ACC;
import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleControlAdapter;
import org.eclipse.swt.accessibility.AccessibleControlEvent;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;

/**
 * Design and behavior from org.eclipse.ui.dialogs.FilteredTree class
 */
public class SearchControl extends Composite {
	/**
	 * The filter text widget to be used by this tree. This value may be
	 * <code>null</code> if there is no filter widget, or if the controls have
	 * not yet been created.
	 */
	protected Text filterText;
	/**
	 * The control representing the clear button for the filter text entry. This
	 * value may be <code>null</code> if no such button exists, or if the
	 * controls have not yet been created.
	 * <p>
	 * <strong>Note:</strong> This is only used if the new look is chosen.
	 * </p>
	 * 
	 * @since 3.5
	 */
	protected Control clearButtonControl;
	/**
	 * The parent composite of the search control.
	 * 
	 * @since 3.3
	 */
	protected Composite parent;

	private Composite filterComposite;

	private Control searchResultControl;

	/**
	 * The text to initially show in the filter text control.
	 */
	protected String initialText = ""; //$NON-NLS-1$	

	public SearchControl(Composite parent) {
		super(parent, SWT.NONE);

		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		setLayout(layout);
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		if (useNativeSearchField(parent)) {
			filterComposite = new Composite(this, SWT.NONE);
		} else {
			filterComposite = new Composite(this, SWT.BORDER);
			filterComposite.setBackground(getDisplay().getSystemColor(
					SWT.COLOR_LIST_BACKGROUND));
		}
		GridLayout filterLayout = new GridLayout(2, false);
		filterLayout.marginHeight = 1;
		filterLayout.marginWidth = 1;
		filterComposite.setLayout(filterLayout);
		filterComposite.setFont(parent.getFont());

		createFilterControls(filterComposite);
		filterComposite.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING,
				true, false));
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);

		filterText.setEnabled(enabled);
		if (clearButtonControl != null) {
			clearButtonControl.setEnabled(enabled);
		}
		filterComposite.setEnabled(enabled);
	}

	protected void createFilterControls(Composite parent) {
		createFilterText(parent);
		createClearText(parent);
		if (clearButtonControl != null) {
			// initially there is no text to clear
			clearButtonControl.setVisible(false);
		}
		setInitialText(Messages.SearchControl_InitialText);
	}

	private void createFilterText(Composite parent) {
		filterText = doCreateFilterText(parent);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);

		if ((filterText.getStyle() & SWT.ICON_CANCEL) != 0)
			gridData.horizontalSpan = 2;
		filterText.setLayoutData(gridData);

		filterText.getAccessible().addAccessibleListener(
				new AccessibleAdapter() {
					public void getName(AccessibleEvent e) {
						String filterTextString = filterText.getText();
						if (filterTextString.length() == 0
								|| filterTextString.equals(initialText)) {
							e.result = initialText;
						} else {
							e.result = ""; //$NON-NLS-1$
						}
					}
				});

		filterText.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent e) {
				if (filterText.getText().equals(initialText)) {
					setFilterText(""); //$NON-NLS-1$
					textChanged();
				}
			}
		});

		filterText.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt
			 * .events.MouseEvent)
			 */
			public void mouseDown(MouseEvent e) {
				if (filterText.getText().equals(initialText)) {
					// XXX: We cannot call clearText() due to
					// https://bugs.eclipse.org/bugs/show_bug.cgi?id=260664
					setFilterText(""); //$NON-NLS-1$	
					textChanged();
				}
			}
		});

		filterText.addKeyListener(new KeyAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.KeyAdapter#keyReleased(org.eclipse.swt
			 * .events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				// on a CR we want to transfer focus to the list

				if (searchResultControl != null && e.keyCode == SWT.ARROW_DOWN) {
					searchResultControl.setFocus();
					return;
				}
			}
		});

		// enter key set focus to tree
		filterText.addTraverseListener(new TraverseListener() {
			public void keyTraversed(TraverseEvent e) {
				if (e.detail == SWT.TRAVERSE_RETURN) {
					e.doit = false;
					if (searchResultControl != null) {
						searchResultControl.setFocus();
						onCR();
					}
				}
			}
		});

		// if we're using a field with built in cancel we need to listen for
		// default selection changes (which tell us the cancel button has been
		// pressed)
		if ((filterText.getStyle() & SWT.ICON_CANCEL) != 0) {
			filterText.addSelectionListener(new SelectionAdapter() {
				public void widgetDefaultSelected(SelectionEvent e) {
					if (e.detail == SWT.ICON_CANCEL)
						clearText();
				}
			});
		}

		filterText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				textChanged();
			}
		});
	}

	public void onCR() {
	}

	protected Text doCreateFilterText(Composite parent) {
		if (useNativeSearchField(parent)) {
			return new Text(parent, SWT.SINGLE | SWT.BORDER | SWT.SEARCH
					| SWT.ICON_CANCEL);
		}
		return new Text(parent, SWT.SINGLE);
	}

	/**
	 * Create the button that clears the text.
	 * 
	 * @param parent
	 *            parent <code>Composite</code> of toolbar button
	 */
	private void createClearText(Composite parent) {
		// only create the button if the text widget doesn't support one
		// natively
		if ((filterText.getStyle() & SWT.ICON_CANCEL) == 0) {
			final ImageDescriptor inactiveImage = Images
					.getImageDescriptor(Images.DISABLED_SEARCH_CLEAR);
			final ImageDescriptor activeImageDescriptor = Images
					.getImageDescriptor(Images.SEARCH_CLEAR);

			final Label clearButton = new Label(parent, SWT.NONE);
			clearButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER,
					false, false));
			clearButton.setImage(inactiveImage.createImage());
			clearButton.setBackground(parent.getDisplay().getSystemColor(
					SWT.COLOR_LIST_BACKGROUND));
			clearButton.setToolTipText(Messages.SearchControl_ClearToolTip);
			clearButton.addMouseListener(new MouseAdapter() {
				private MouseMoveListener fMoveListener;

				public void mouseDown(MouseEvent e) {
					Image ac = activeImageDescriptor.createImage();
					clearButton.setImage(new Image(getDisplay(), ac,
							SWT.IMAGE_GRAY));
					ac.dispose();
					fMoveListener = new MouseMoveListener() {
						private boolean fMouseInButton = true;

						public void mouseMove(MouseEvent e) {
							boolean mouseInButton = isMouseInButton(e);
							if (mouseInButton != fMouseInButton) {
								fMouseInButton = mouseInButton;
								clearButton
										.setImage(mouseInButton ? (new Image(
												getDisplay(),
												activeImageDescriptor
														.createImage(),
												SWT.IMAGE_GRAY))
												: inactiveImage.createImage());
							}
						}
					};
					clearButton.addMouseMoveListener(fMoveListener);
				}

				public void mouseUp(MouseEvent e) {
					if (fMoveListener != null) {
						clearButton.removeMouseMoveListener(fMoveListener);
						fMoveListener = null;
						boolean mouseInButton = isMouseInButton(e);
						clearButton
								.setImage(mouseInButton ? activeImageDescriptor
										.createImage() : inactiveImage
										.createImage());
						if (mouseInButton) {
							clearText();
							filterText.setFocus();
						}
					}
				}

				private boolean isMouseInButton(MouseEvent e) {
					Point buttonSize = clearButton.getSize();
					return 0 <= e.x && e.x < buttonSize.x && 0 <= e.y
							&& e.y < buttonSize.y;
				}
			});
			clearButton.addMouseTrackListener(new MouseTrackListener() {
				public void mouseEnter(MouseEvent e) {
					clearButton.setImage(activeImageDescriptor.createImage());
				}

				public void mouseExit(MouseEvent e) {
					clearButton.setImage(inactiveImage.createImage());
				}

				public void mouseHover(MouseEvent e) {
				}
			});
			clearButton.getAccessible().addAccessibleListener(
					new AccessibleAdapter() {
						public void getName(AccessibleEvent e) {
							e.result = Messages.SearchControl_ClearResult;
						}
					});
			clearButton.getAccessible().addAccessibleControlListener(
					new AccessibleControlAdapter() {
						public void getRole(AccessibleControlEvent e) {
							e.detail = ACC.ROLE_PUSHBUTTON;
						}
					});
			this.clearButtonControl = clearButton;
		}
	}

	/**
	 * Get the initial text for the receiver.
	 * 
	 * @return String
	 */
	public String getInitialText() {
		return initialText;
	}

	/**
	 * Set the text that will be shown until the first focus. A default value is
	 * provided, so this method only need be called if overriding the default
	 * initial text is desired.
	 * 
	 * @param text
	 *            initial text to appear in text field
	 */
	public void setInitialText(String text) {
		initialText = text;
		if (filterText != null) {
			filterText.setMessage(text);
			if (filterText.isFocusControl()) {
				setFilterText(initialText);
				textChanged();
			} else {
				getDisplay().asyncExec(new Runnable() {
					public void run() {
						if (!filterText.isDisposed()
								&& filterText.isFocusControl()) {
							setFilterText(initialText);
							textChanged();
						}
					}
				});
			}
		} else {
			setFilterText(initialText);
			textChanged();
		}
	}

	/**
	 * Clears the text in the filter text widget.
	 */
	protected void clearText() {
		setFilterText(""); //$NON-NLS-1$	
		textChanged();
	}

	/**
	 * Set the text in the filter control.
	 * 
	 * @param string
	 */
	protected void setFilterText(String string) {
		if (filterText != null) {
			filterText.setText(string);
			selectAll();
		}
	}

	/**
	 * Select all text in the filter text field.
	 * 
	 */
	protected void selectAll() {
		if (filterText != null) {
			filterText.selectAll();
		}
	}

	/**
	 * Get the filter text for the receiver, if it was created. Otherwise return
	 * <code>null</code>.
	 * 
	 * @return the filter Text, or null if it was not created
	 */
	public Text getFilterControl() {
		return filterText;
	}

	/**
	 * Convenience method to return the text of the filter control. If the text
	 * widget is not created, then null is returned.
	 * 
	 * @return String in the text, or null if the text does not exist
	 */
	public String getFilterString() {
		return filterText != null ? filterText.getText() : null;
	}

	public Control getSearchResultControl() {
		return searchResultControl;
	}

	public void setSearchResultControl(Control searchResultControl) {
		this.searchResultControl = searchResultControl;
	}

	protected void textChanged() {
		if (clearButtonControl != null) {
			boolean haveText = (filterText != null)
					&& !filterText.getText().equals("") //$NON-NLS-1$
					&& !filterText.getText().equals(initialText);
			clearButtonControl.setVisible(haveText);
		}
	}

	private static Boolean useNativeSearchField;

	private static boolean useNativeSearchField(Composite composite) {
		if (useNativeSearchField == null) {
			useNativeSearchField = Boolean.FALSE;
			Text testText = null;
			try {
				testText = new Text(composite, SWT.SEARCH | SWT.ICON_CANCEL);
				useNativeSearchField = new Boolean(
						(testText.getStyle() & SWT.ICON_CANCEL) != 0);
			} finally {
				if (testText != null) {
					testText.dispose();
				}
			}

		}
		return useNativeSearchField.booleanValue();
	}
}
