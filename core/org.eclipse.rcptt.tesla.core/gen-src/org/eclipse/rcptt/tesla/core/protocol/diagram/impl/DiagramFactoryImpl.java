/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.tesla.core.protocol.diagram.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.rcptt.tesla.core.protocol.diagram.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramFactoryImpl extends EFactoryImpl implements DiagramFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagramFactory init() {
		try {
			DiagramFactory theDiagramFactory = (DiagramFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/rcptt/tesla/diagram"); 
			if (theDiagramFactory != null) {
				return theDiagramFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DiagramFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DiagramPackage.CREATE_FIGURE: return createCreateFigure();
			case DiagramPackage.CREATE_FIGURE_RESPONSE: return createCreateFigureResponse();
			case DiagramPackage.MOVE_FIGURE: return createMoveFigure();
			case DiagramPackage.SET_FIGURE_SELECTION: return createSetFigureSelection();
			case DiagramPackage.GET_FIGURES: return createGetFigures();
			case DiagramPackage.GET_FIGURES_RESPONSE: return createGetFiguresResponse();
			case DiagramPackage.ACTIVATE_DIRECT_EDIT: return createActivateDirectEdit();
			case DiagramPackage.CANCEL_DIRECT_EDIT: return createCancelDirectEdit();
			case DiagramPackage.COMMIT_DIRECT_EDIT: return createCommitDirectEdit();
			case DiagramPackage.CREATE_CONNECTION: return createCreateConnection();
			case DiagramPackage.CREATE_CONNECTION_RESPONSE: return createCreateConnectionResponse();
			case DiagramPackage.RESIZE_FIGURE: return createResizeFigure();
			case DiagramPackage.MOUSE_COMMAND: return createMouseCommand();
			case DiagramPackage.FIGURE_MOUSE_COMMAND: return createFigureMouseCommand();
			case DiagramPackage.ASSERT_FIGURE_EXISTS: return createAssertFigureExists();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DiagramPackage.MOUSE_COMMAND_KIND:
				return createMouseCommandKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DiagramPackage.MOUSE_COMMAND_KIND:
				return convertMouseCommandKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateFigure createCreateFigure() {
		CreateFigureImpl createFigure = new CreateFigureImpl();
		return createFigure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateFigureResponse createCreateFigureResponse() {
		CreateFigureResponseImpl createFigureResponse = new CreateFigureResponseImpl();
		return createFigureResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoveFigure createMoveFigure() {
		MoveFigureImpl moveFigure = new MoveFigureImpl();
		return moveFigure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetFigureSelection createSetFigureSelection() {
		SetFigureSelectionImpl setFigureSelection = new SetFigureSelectionImpl();
		return setFigureSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetFigures createGetFigures() {
		GetFiguresImpl getFigures = new GetFiguresImpl();
		return getFigures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetFiguresResponse createGetFiguresResponse() {
		GetFiguresResponseImpl getFiguresResponse = new GetFiguresResponseImpl();
		return getFiguresResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivateDirectEdit createActivateDirectEdit() {
		ActivateDirectEditImpl activateDirectEdit = new ActivateDirectEditImpl();
		return activateDirectEdit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CancelDirectEdit createCancelDirectEdit() {
		CancelDirectEditImpl cancelDirectEdit = new CancelDirectEditImpl();
		return cancelDirectEdit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommitDirectEdit createCommitDirectEdit() {
		CommitDirectEditImpl commitDirectEdit = new CommitDirectEditImpl();
		return commitDirectEdit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateConnection createCreateConnection() {
		CreateConnectionImpl createConnection = new CreateConnectionImpl();
		return createConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateConnectionResponse createCreateConnectionResponse() {
		CreateConnectionResponseImpl createConnectionResponse = new CreateConnectionResponseImpl();
		return createConnectionResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResizeFigure createResizeFigure() {
		ResizeFigureImpl resizeFigure = new ResizeFigureImpl();
		return resizeFigure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MouseCommand createMouseCommand() {
		MouseCommandImpl mouseCommand = new MouseCommandImpl();
		return mouseCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FigureMouseCommand createFigureMouseCommand() {
		FigureMouseCommandImpl figureMouseCommand = new FigureMouseCommandImpl();
		return figureMouseCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssertFigureExists createAssertFigureExists() {
		AssertFigureExistsImpl assertFigureExists = new AssertFigureExistsImpl();
		return assertFigureExists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MouseCommandKind createMouseCommandKindFromString(EDataType eDataType, String initialValue) {
		MouseCommandKind result = MouseCommandKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMouseCommandKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramPackage getDiagramPackage() {
		return (DiagramPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DiagramPackage getPackage() {
		return DiagramPackage.eINSTANCE;
	}

} //DiagramFactoryImpl
