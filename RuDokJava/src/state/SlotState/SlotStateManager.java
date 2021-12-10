package state.SlotState;

import state.State;

public class SlotStateManager {
    private SlotState currentState;

    private AddSlotState addSlotState;
    private DeleteSlotState deleteSlotState;
    private DragDropSlotState dragDropSlotState;

    public SlotStateManager() {
        initStates();
        currentState = addSlotState;
    }

    public void setAddSlotState()
    {
        currentState = addSlotState;
    }

    public void setDeleteSlotState()
    {
        currentState = deleteSlotState;
    }

    public void setDragDropSlotState()
    {
        currentState = dragDropSlotState;
    }

    private void initStates()
    {
        addSlotState = new AddSlotState();
        deleteSlotState = new DeleteSlotState();
        dragDropSlotState = new DragDropSlotState();
    }

    public SlotState getCurrentState() {
        return currentState;
    }
}
