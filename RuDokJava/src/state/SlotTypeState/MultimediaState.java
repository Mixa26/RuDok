package state.SlotTypeState;

import Model.Slot;
import View.MainView;
import View.PresentationView;
import state.WorkModeState.State;

public class MultimediaState implements State {
    @Override
    public void changeState() {
        ((PresentationView) MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).setSlotType(Slot.type.Multimedia);
    }
}
