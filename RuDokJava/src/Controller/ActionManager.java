package Controller;

import java.awt.*;

public class ActionManager {

    private InfoAction infoAction;
    private EditPresentationAction editPresentationAction;
    private SubmitPresentationInitialsAction submitPresentationInitialsAction;
    private SubmitRenameIntialsAction submitRenameIntialsAction;
    private RenameInTreeAction renameInTreeAction;
    private DeleteAction deleteAction;

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
        submitRenameIntialsAction = new SubmitRenameIntialsAction();
        deleteAction = new DeleteAction();
        renameInTreeAction = new RenameInTreeAction();

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

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public NewPresentationAction getNewPresentationAction() {
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

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public void setDeleteAction(DeleteAction deleteAction) {
        this.deleteAction = deleteAction;
    }

    public SubmitPresentationInitialsAction getSubmitPresentationInitialsAction() {
        return submitPresentationInitialsAction;
    }

    public SubmitRenameIntialsAction getSubmitRenameIntialsAction() {
        return submitRenameIntialsAction;
    }

    public void setSubmitPresentationInitialsAction(SubmitPresentationInitialsAction submitPresentationInitialsAction) {
        this.submitPresentationInitialsAction = submitPresentationInitialsAction;
    }
}
