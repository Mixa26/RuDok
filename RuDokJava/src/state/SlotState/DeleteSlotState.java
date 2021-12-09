package state.SlotState;

import View.SlideView;
import View.SlotView;
import state.State;

public class DeleteSlotState extends SlotState {
    @Override
    public void mouseClicked(int x, int y, SlideView slideView) {
        for (int i = slideView.getSlotViews().size()-1; i >= 0; i--)
        {
            SlotView slotView = slideView.getSlotViews().get(i);
            if (slotView.elementAt(x,y))
            {
                slideView.getSlide().removeSlot(slotView.getSlot());
                break;
            }
        }
    }
}
