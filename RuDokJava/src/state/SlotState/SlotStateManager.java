package state.SlotState;

import View.MainView;

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
        MainView.getInstance().getActionManager().getDeleteSlotStateAction().resetIcon();
        MainView.getInstance().getActionManager().getDragDropSlotStateAction().resetIcon();
    }

    public void setDeleteSlotState()
    {
        currentState = deleteSlotState;
        MainView.getInstance().getActionManager().getAddSlotStateAction().resetIcon();
        MainView.getInstance().getActionManager().getDragDropSlotStateAction().resetIcon();
    }

    public void setDragDropSlotState()
    {
        currentState = dragDropSlotState;
        MainView.getInstance().getActionManager().getAddSlotStateAction().resetIcon();
        MainView.getInstance().getActionManager().getDeleteSlotStateAction().resetIcon();
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

    public void refreshIcons()
        {
            if (currentState == addSlotState)
            {
                MainView.getInstance().getActionManager().getAddSlotStateAction().setSelectedIcon();
                MainView.getInstance().getActionManager().getDeleteSlotStateAction().resetIcon();
                MainView.getInstance().getActionManager().getDragDropSlotStateAction().resetIcon();
            }
            else if(currentState == deleteSlotState)
            {
                MainView.getInstance().getActionManager().getAddSlotStateAction().resetIcon();
                MainView.getInstance().getActionManager().getDeleteSlotStateAction().setSelectedIcon();
                MainView.getInstance().getActionManager().getDragDropSlotStateAction().resetIcon();
            }
            else
            {
                MainView.getInstance().getActionManager().getAddSlotStateAction().resetIcon();
                MainView.getInstance().getActionManager().getDeleteSlotStateAction().resetIcon();
                MainView.getInstance().getActionManager().getDragDropSlotStateAction().setSelectedIcon();
            }
    }
}
