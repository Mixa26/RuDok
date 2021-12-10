package state.SlotState;

import Model.Slot;
import View.MainView;
import View.PresentationView;
import View.SlideView;

public class AddSlotState extends SlotState {
    @Override
    public void mouseClicked(int x, int y, SlideView slideView) {
        Slot slot = new Slot(x, y);
        slot.setColor(((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getPickedColor());
        slideView.getSlide().addSlot(slot);
    }
}
