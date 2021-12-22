package state.SlotState;

import Controller.ActionManager;
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
        MainView.getIntance().getActionManager().getDeleteSlotStateAction().resetIcon();
        MainView.getIntance().getActionManager().getDragDropSlotStateAction().resetIcon();
    }

    public void setDeleteSlotState()
    {
        currentState = deleteSlotState;
        MainView.getIntance().getActionManager().getAddSlotStateAction().resetIcon();
        MainView.getIntance().getActionManager().getDragDropSlotStateAction().resetIcon();
    }

    public void setDragDropSlotState()
    {
        currentState = dragDropSlotState;
        MainView.getIntance().getActionManager().getAddSlotStateAction().resetIcon();
        MainView.getIntance().getActionManager().getDeleteSlotStateAction().resetIcon();
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
                MainView.getIntance().getActionManager().getAddSlotStateAction().setSelectedIcon();
                MainView.getIntance().getActionManager().getDeleteSlotStateAction().resetIcon();
                MainView.getIntance().getActionManager().getDragDropSlotStateAction().resetIcon();
            }
            else if(currentState == deleteSlotState)
            {
                MainView.getIntance().getActionManager().getAddSlotStateAction().resetIcon();
                MainView.getIntance().getActionManager().getDeleteSlotStateAction().setSelectedIcon();
                MainView.getIntance().getActionManager().getDragDropSlotStateAction().resetIcon();
            }
            else
            {
                MainView.getIntance().getActionManager().getAddSlotStateAction().resetIcon();
                MainView.getIntance().getActionManager().getDeleteSlotStateAction().resetIcon();
                MainView.getIntance().getActionManager().getDragDropSlotStateAction().setSelectedIcon();
            }
    }
}
