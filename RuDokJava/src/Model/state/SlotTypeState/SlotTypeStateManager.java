package Model.state.SlotTypeState;

import Model.state.WorkModeState.State;

public class SlotTypeStateManager {
    private State currentState;

    private MultimediaState multimediaState;
    private TextState textState;

    public SlotTypeStateManager() {
        initStates();
        currentState = textState;
    }

    public void setMultimediaState()
    {
        currentState = multimediaState;
        currentState.changeState();
    }

    public void setTextState()
    {
        currentState = textState;
        currentState.changeState();
    }

    private void initStates()
    {
        multimediaState = new MultimediaState();
        textState = new TextState();
    }

    public State getCurrentState() {
        return currentState;
    }
}
