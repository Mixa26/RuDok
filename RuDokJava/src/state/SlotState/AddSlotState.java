package state.SlotState;

import Model.Slot;
import View.SlideView;
import state.State;

public class AddSlotState extends SlotState {
    @Override
    public void mouseClicked(int x, int y, SlideView slideView) {
        Slot slot = new Slot(x, y);
        slideView.getSlide().addSlot(slot);
    }
}
