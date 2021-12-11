package state.SlotBorderStrokeState;

import state.State;

public class StrokeStateManager {
    private State currentState;

    private FullStrokeState fullStrokeState;
    private SplitStrokeState splitStrokeState;

    public StrokeStateManager() {
        initStates();
        currentState = fullStrokeState;
    }

    private void initStates()
    {
        fullStrokeState = new FullStrokeState();
        splitStrokeState = new SplitStrokeState();
    }

    public void setFullStrokeState()
    {
        currentState = fullStrokeState;
        currentState.changeState();
    }

    public void setSplitStrokeState()
    {
        currentState = splitStrokeState;
        currentState.changeState();
    }

    public State getCurrentState() {
        return currentState;
    }
}
