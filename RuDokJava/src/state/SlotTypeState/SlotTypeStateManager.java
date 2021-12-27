package state.SlotTypeState;

import state.State;

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
    }

    public void setTextState()
    {
        currentState = textState;
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
