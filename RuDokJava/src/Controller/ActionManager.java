package Controller;

public class ActionManager {

    private InfoAction infoAction;
    private NewAction newAction;

    public ActionManager()
    {
        initializeActions();
    }

    private void initializeActions()
    {
        infoAction = new InfoAction();
        newAction = new NewAction();
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
}
