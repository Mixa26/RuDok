package state.SlotTypeState;

import Model.Slot;
import View.MainView;
import View.PresentationView;
import state.State;

public class TextState implements State {
    @Override
    public void changeState() {
        ((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).setSlotType(Slot.type.Multimedia);
    }
}
