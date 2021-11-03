package Controller;

public class ActionManager {

    private InfoAction infoAction;
    private NewAction newAction;
    private EditPresentationAction editPresentationAction;
    private RenameInTreeAction renameInTreeAction;

    public ActionManager()
    {
        initializeActions();
    }

    private void initializeActions()
    {
        infoAction = new InfoAction();
        newAction = new NewAction();
        editPresentationAction = new EditPresentationAction();
    }

    //Getters and Setters
    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }

    public EditPresentationAction getEditPresentationAction() {
        return editPresentationAction;
    }

    public void setEditPresentationAction(EditPresentationAction editPresentationAction) {
        this.editPresentationAction = editPresentationAction;
    }

    public RenameInTreeAction getRenameInTreeAction() {
        return renameInTreeAction;
    }

    public void setRenameInTreeAction(RenameInTreeAction renameInTreeAction) {
        this.renameInTreeAction = renameInTreeAction;
    }
}
