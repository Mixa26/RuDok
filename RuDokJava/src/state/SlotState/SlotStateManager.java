package state.SlotState;

import state.State;

public class SlotStateManager {
    private State currentState;

    private AddSlotState addSlotState;
    private DeleteSlotState deleteSlotState;

    public SlotStateManager() {
        initStates();
        currentState = null;
    }

    public void setAddSlotState()
    {
        currentState = addSlotState;
        currentState.changeState();
    }

    public void setDeleteSlotState()
    {
        currentState = deleteSlotState;
        currentState.changeState();
    }

    private void initStates()
    {
        addSlotState = new AddSlotState();
        deleteSlotState = new DeleteSlotState();
    }

    public State getCurrentState() {
        return currentState;
    }
}
