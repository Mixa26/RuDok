package state.SlotState;

import state.State;

public class SlotStateManager {
    private SlotState currentState;

    private AddSlotState addSlotState;
    private DeleteSlotState deleteSlotState;

    public SlotStateManager() {
        initStates();
        currentState = null;
    }

    public void setAddSlotState()
    {
        currentState = addSlotState;
    }

    public void setDeleteSlotState()
    {
        currentState = deleteSlotState;
    }

    private void initStates()
    {
        addSlotState = new AddSlotState();
        deleteSlotState = new DeleteSlotState();
    }

    public SlotState getCurrentState() {
        return currentState;
    }
}
