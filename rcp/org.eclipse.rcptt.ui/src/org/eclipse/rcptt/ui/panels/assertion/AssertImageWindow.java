/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.panels.assertion;

import java.awt.Point;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.tesla.core.protocol.Assert;
import org.eclipse.rcptt.tesla.core.protocol.AssertImageData;
import org.eclipse.rcptt.tesla.core.protocol.AssertKind;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.ecl.model.Recognize;
import org.eclipse.rcptt.tesla.ecl.model.RecognizeResponse;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;

public class AssertImageWindow extends Dialog {
	private static final int TYPE_CONTAIN_IMAGE = 0;
	private static final int TYPE_IMAGE_TEXT_CONTAINS = 1;
	private AssertionPanelWindow assertPanelWindow;
	private byte[] image;
	private Image img;
	private Point firstAncor = new Point(0, 0);
	private Point secondAncor = new Point(100, 100);
	protected boolean inDrag;
	private Label selectedImage;
	private Text text;
	private Combo assertKind;
	private Assert result;
	private Rectangle imgBounds;

	public AssertImageWindow(Shell parentShell, AssertionPanelWindow window) {
		super(parentShell);
		this.assertPanelWindow = window;
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.APPLICATION_MODAL
				| SWT.ON_TOP);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite content = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 10).numColumns(2)
				.applyTo(content);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(content);
		img = new Image(parent.getDisplay(), new ByteArrayInputStream(
				this.image));

		// Type combo
		new Label(content, SWT.NONE)
				.setText(Messages.AssertImageWindow_TypeLabel);
		assertKind = new Combo(content, SWT.READ_ONLY | SWT.BORDER);
		assertKind.setItems(new String[] {
				Messages.AssertImageWindow_AssertKind_ContainsImage,
				Messages.AssertImageWindow_AssertKind_ContainsText });
		assertKind.select(0);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(assertKind);

		// Text field
		Label textLabel = new Label(content, SWT.NONE);
		textLabel.setText(Messages.AssertImageWindow_TextLabel);
		text = new Text(content, SWT.MULTI | SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).hint(SWT.DEFAULT, 60)
				.span(1, 1).applyTo(text);
		text.setEnabled(false);
		assertKind.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = assertKind.getSelectionIndex();
				if (index == TYPE_CONTAIN_IMAGE) {
					text.setEnabled(false);
				} else if (index == TYPE_IMAGE_TEXT_CONTAINS) {
					text.setEnabled(true);
				}
			}
		});

		// Selection field
		new Label(content, SWT.NONE)
				.setText(Messages.AssertImageWindow_SelectionLabel);
		selectedImage = new Label(content, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(selectedImage);

		// Image field
		new Label(content, SWT.NONE)
				.setText(Messages.AssertImageWindow_ImageLabel);
		ScrolledComposite sc = new ScrolledComposite(content, SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);
		GridDataFactory.fillDefaults().span(1, 2).grab(true, true)
				.hint(600, 300).applyTo(sc);
		final Canvas imageCanvas = new Canvas(sc, SWT.BORDER);
		imgBounds = img.getBounds();
		firstAncor = new Point(0, 0);
		secondAncor = new Point(imgBounds.width - 1, imgBounds.height - 1);
		updateImageInfo();
		imageCanvas.setBounds(0, 0, imgBounds.width + 2, imgBounds.height + 2);
		sc.setMinSize(imgBounds.width + 1, imgBounds.height + 1);
		sc.setContent(imageCanvas);
		Color color = imageCanvas.getDisplay().getSystemColor(SWT.COLOR_WHITE);
		sc.setBackground(new Color(color.getDevice(), color.getRGB()));
		final Color blueColor = new Color(color.getDevice(), imageCanvas
				.getDisplay().getSystemColor(SWT.COLOR_BLUE).getRGB());
		imageCanvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (img != null) {
					e.gc.drawImage(img, 0, 0);
					e.gc.setForeground(blueColor);

					Rectangle selection = getSelection();
					e.gc.drawRectangle(selection);
				}
			}
		});
		imageCanvas.addMouseListener(new org.eclipse.swt.events.MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				firstAncor = updatePoint(new Point(e.x, e.y));
				inDrag = true;
			}

			@Override
			public void mouseUp(MouseEvent e) {
				secondAncor = updatePoint(new Point(e.x, e.y));
				inDrag = false;

				// Update recognize information
				updateRecognizeText(assertKind);
			}
		});
		imageCanvas.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
				if (inDrag) {
					secondAncor = updatePoint(new Point(e.x, e.y));
					imageCanvas.redraw();
					updateImageInfo();
				}
			}
		});
		// GridDataFactory.fillDefaults().grab(true, true).applyTo(imageCanvas);

		return content;
	}

	protected Point updatePoint(Point point) {
		if (point.x < 0) {
			point.x = 0;
		}
		if (point.y < 0) {
			point.y = 0;
		}
		Rectangle bounds = img.getBounds();
		if (point.x > bounds.width) {
			point.x = bounds.width - 1;
		}
		if (point.y > bounds.height) {
			point.y = bounds.height - 1;
		}
		return point;
	}

	private void updateImageInfo() {
		Rectangle rect = getSelection();
		selectedImage.setText(getInfoText(rect));
	}

	private String getInfoText(Rectangle rect) {
		return "(" + rect.x + ", " + rect.y + ", " + rect.width + ", " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ rect.height + ")"; //$NON-NLS-1$
	}

	private Rectangle getSelection() {
		return new Rectangle(Math.min(firstAncor.x, secondAncor.x), Math.min(
				firstAncor.y, secondAncor.y), Math.abs(firstAncor.x
				- secondAncor.x), Math.abs(firstAncor.y - secondAncor.y));
	}

	@Override
	public boolean close() {
		if (img != null) {
			img.dispose();
		}
		return super.close();
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.AssertImageWindow_Tilte);
	}

	public void setInput(byte[] imageCapture) {
		this.image = imageCapture;

	}

	@Override
	protected void okPressed() {
		result = ProtocolFactory.eINSTANCE.createAssert();

		AssertImageData data = ProtocolFactory.eINSTANCE
				.createAssertImageData();
		Rectangle selection = getSelection();
		data.setX(selection.x);
		data.setY(selection.y);
		data.setWidth(imgBounds.width);
		data.setHeight(imgBounds.height);
		result.setImageData(data);

		int index = assertKind.getSelectionIndex();
		switch (index) {
		case TYPE_CONTAIN_IMAGE:
			// Capture image
			GC gc = new GC(img);
			Image copyImg = new Image(img.getDevice(), selection.width,
					selection.height);
			gc.copyArea(copyImg, selection.x, selection.y);
			gc.dispose();
			ImageLoader loader = new ImageLoader();
			loader.data = new ImageData[] { copyImg.getImageData() };
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			loader.save(stream, SWT.IMAGE_PNG);
			data.setImage(stream.toByteArray());
			copyImg.dispose();
			result.setAttribute("Contain image"); //$NON-NLS-1$
			result.setKind(AssertKind.CONTAINS_IMAGE);
			break;
		case TYPE_IMAGE_TEXT_CONTAINS:
			result.setAttribute("Contain text"); //$NON-NLS-1$
			result.setKind(AssertKind.IMAGE_CONTAINS_TEXT);
			String resultText = replaceMultilines(text.getText());
			result.setValue(resultText);
			data.setSx(selection.width);
			data.setSy(selection.height);
			break;
		}

		super.okPressed();
	}

	private void updateRecognizeText(final Combo assertKind) {
		if (assertKind.getSelectionIndex() == TYPE_IMAGE_TEXT_CONTAINS) {
			AutLaunch launch = assertPanelWindow.getAut();
			Recognize recognize = TeslaFactory.eINSTANCE.createRecognize();
			// Extract image part
			Rectangle selection = getSelection();
			recognize.setX(selection.x);
			recognize.setY(selection.y);
			recognize.setWidth(selection.width);
			recognize.setHeight(selection.height);
			recognize.setImage(image);

			try {
				Object object = launch.execute(recognize);
				if (object instanceof RecognizeResponse) {
					RecognizeResponse resp = (RecognizeResponse) object;
					if (resp != null) {
						if (resp.getText() != null) {
							text.setText(resp.getText());
						} else {
							text.setText(""); //$NON-NLS-1$
						}
					}
				}
			} catch (Throwable e) {
				Q7UIPlugin.log(e);
			}
		}
	}

	public static String replaceMultilines(String result) {
		if (result == null) {
			return null;
		}
		String finalResult;
		if (Platform.getOS().equals(Platform.OS_WIN32)) {
			finalResult = result.replaceAll("\r", "").trim(); //$NON-NLS-1$ //$NON-NLS-2$
		} else if (Platform.getOS().equals(Platform.OS_MACOSX)) {
			finalResult = result.replaceAll("\r", "\n").trim(); //$NON-NLS-1$ //$NON-NLS-2$
		} else {
			finalResult = result;
		}
		return finalResult;
	}

	public Assert getAssert() {
		return result;
	}
}
