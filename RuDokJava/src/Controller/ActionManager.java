package Controller;

public class ActionManager {

    private InfoAction infoAction;
    private NewAction newAction;
    private EditPresentationAction editPresentationAction;
    private RenameInTreeAction renameInTreeAction;

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
        newAction = new NewAction();
        editPresentationAction = new EditPresentationAction();

        newProjectAction = new NewProjectAction();
        newPresentationAction = new NewPresentationAction();
        newSlideAction = new NewSlideAction();
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

    public RenameInTreeAction getRenameInTreeAction(Object object) {
        return renameInTreeAction = new RenameInTreeAction(object);
    }

    public void setRenameInTreeAction(RenameInTreeAction renameInTreeAction) {
        this.renameInTreeAction = renameInTreeAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public NewPresentationAction getNewPrezentationAction() {
        return newPresentationAction;
    }

    public NewSlideAction getNewSlideAction() {
        return newSlideAction;
    }

    public void setNewProjectAction(NewProjectAction newProjectAction) {
        this.newProjectAction = newProjectAction;
    }

    public void setNewPrezentationAction(NewPresentationAction newPresentationAction) {
        this.newPresentationAction = newPresentationAction;
    }

    public void setNewSlideAction(NewSlideAction newSlideAction) {
        this.newSlideAction = newSlideAction;
    }
}
