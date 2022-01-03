package Model.state.SlotTypeState;

import Model.Slot;
import View.MainView;
import View.PresentationView;
import Model.state.WorkModeState.State;

public class TextState implements State {
    @Override
    public void changeState() {
        ((PresentationView) MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).setSlotType(Slot.type.Text);
    }
}
