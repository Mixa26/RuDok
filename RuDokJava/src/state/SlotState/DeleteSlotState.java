package state.SlotState;

import Model.Slot;
import Model.treeModel.Slide;
import View.SlideView;
import View.SlotView;
import state.State;

public class DeleteSlotState extends SlotState {
    @Override
    public void mouseClicked(int x, int y, Slide slide) {
        for (int i = slide.getSlots().size()-1; i >= 0; i--)
        {
            Slot slot = slide.getSlots().get(i);
            if (slot.elementAt(x,y))
            {
                slide.removeSlot(slot);
                break;
            }
        }
    }
}
