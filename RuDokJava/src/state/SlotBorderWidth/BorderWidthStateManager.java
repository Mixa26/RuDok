package state.SlotBorderWidth;

import state.WorkModeState.State;

public class BorderWidthStateManager {
    private State currentState;

    SmallBorderState smallBorderState;
    MediumBorderState mediumBorderState;
    BigBorderState bigBorderState;

    public BorderWidthStateManager() {
        initState();
        currentState = smallBorderState;
    }

    public void setSmallBorderState() {
        currentState = smallBorderState;
    }

    public void setMediumBorderState() {
        currentState = mediumBorderState;
    }

    public void setBigBorderState() {
        currentState = bigBorderState;
    }

    public void initState()
    {
        smallBorderState = new SmallBorderState();
        mediumBorderState = new MediumBorderState();
        bigBorderState = new BigBorderState();
    }

    public State getCurrentState() {
        return currentState;
    }
}
