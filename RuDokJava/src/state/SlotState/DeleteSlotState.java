package state.SlotState;

import Model.treeModel.Slide;
import View.SlideView;
import View.SlotView;
import state.State;

public class DeleteSlotState extends SlotState {
    @Override
    public void mouseClicked(int x, int y, Slide slide) {
        for (int i = slide.getSlideViews().get(0).getSlotViews().size()-1; i >= 0; i--)
        {
            SlotView slotView = slide.getSlideViews().get(0).getSlotViews().get(i);
            if (slotView.elementAt(x,y))
            {
                slide.removeSlot(slotView.getSlot());
                break;
            }
        }
    }
}
