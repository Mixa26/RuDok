package Controller;

public class ActionManager {

    private InfoAction infoAction;
    private EditPresentationAction editPresentationAction;
    private SubmitPresentationInitialsAction submitPresentationInitialsAction;
    private OpenFileChooserAction openFileChooserAction;
    private SubmitRenameIntialsAction submitRenameIntialsAction;
    private RenameInTreeAction renameInTreeAction;
    private DeleteAction deleteAction;

    private SwitchEditViewStateAction switchEditViewStateAction;

    private AddSlotStateAction addSlotStateAction;
    private DeleteSlotStateAction deleteSlotStateAction;
    private DragDropSlotStateAction dragDropSlotStateAction;
    private SelectBorderStrokeAction selectBorderStrokeAction;
    private OpenColorPickerAction openColorPickerAction;
    private SumbitColorAction submitColorAction;

    private NewProjectAction newProjectAction;
    private NewPresentationAction newPresentationAction;
    private NewSlideAction newSlideAction;

    public ActionManager()
    {
        initializeActions();
    }

    private void initializeActions()
    {
        infoAction = new InfoAction();
        editPresentationAction = new EditPresentationAction();
        submitPresentationInitialsAction = new SubmitPresentationInitialsAction();
        openFileChooserAction = new OpenFileChooserAction();
        submitRenameIntialsAction = new SubmitRenameIntialsAction();
        deleteAction = new DeleteAction();
        renameInTreeAction = new RenameInTreeAction();

        switchEditViewStateAction = new SwitchEditViewStateAction();

        addSlotStateAction = new AddSlotStateAction();
        deleteSlotStateAction = new DeleteSlotStateAction();
        dragDropSlotStateAction = new DragDropSlotStateAction();
        selectBorderStrokeAction = new SelectBorderStrokeAction();
        openColorPickerAction = new OpenColorPickerAction();
        submitColorAction = new SumbitColorAction();

        newProjectAction = new NewProjectAction();
        newPresentationAction = new NewPresentationAction();
        newSlideAction = new NewSlideAction();
    }

    //Getters
    public InfoAction getInfoAction() {
        return infoAction;
    }

    public EditPresentationAction getEditPresentationAction() {
        return editPresentationAction;
    }

    public RenameInTreeAction getRenameInTreeAction() {
        return renameInTreeAction;
    }


    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public NewPresentationAction getNewPresentationAction() {
        return newPresentationAction;
    }

    public NewSlideAction getNewSlideAction() {
        return newSlideAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public SubmitPresentationInitialsAction getSubmitPresentationInitialsAction() {
        return submitPresentationInitialsAction;
    }

    public SubmitRenameIntialsAction getSubmitRenameIntialsAction() {
        return submitRenameIntialsAction;
    }


    public OpenFileChooserAction getOpenFileChooserAction() {
        return openFileChooserAction;
    }


    public SwitchEditViewStateAction getSwitchEditViewStateAction() {
        return switchEditViewStateAction;
    }

    public AddSlotStateAction getAddSlotStateAction() {
        return addSlotStateAction;
    }

    public DeleteSlotStateAction getDeleteSlotStateAction() {
        return deleteSlotStateAction;
    }

    public OpenColorPickerAction getOpenColorPickerAction() {
        return openColorPickerAction;
    }

    public SumbitColorAction getSubmitColorAction() {
        return submitColorAction;
    }

    public DragDropSlotStateAction getDragDropSlotStateAction() {
        return dragDropSlotStateAction;
    }

    public SelectBorderStrokeAction getSelectBorderStrokeAction() {
        return selectBorderStrokeAction;
    }
}
