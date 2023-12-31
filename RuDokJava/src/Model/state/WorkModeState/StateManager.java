package Model.state.WorkModeState;

public class StateManager {
    private State currentState;

    private EditProjectState editProjectState;
    private SlideShowState slideShowState;

    public StateManager() {
        initStates();
        currentState = editProjectState;
    }

    public void setEditProjectState() {
        this.currentState = editProjectState;
        currentState.changeState();
    }

    public void setSlideShowState() {
        this.currentState = slideShowState;
        currentState.changeState();
    }

    private void initStates()
    {
        editProjectState = new EditProjectState();
        slideShowState = new SlideShowState();
    }

    public State getCurrentState() {
        return currentState;
    }

}
