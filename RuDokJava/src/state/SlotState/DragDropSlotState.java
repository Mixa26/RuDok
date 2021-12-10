package state.SlotState;

import Model.Slot;
import View.SlideView;
import View.SlotView;
import observer.NotifyType;

public class DragDropSlotState extends SlotState{
    @Override
    public void mousePressed(int x, int y, SlideView slideView) {
        for (int i = slideView.getSlotViews().size()-1; i >= 0; i--)
        {
            SlotView slotView = slideView.getSlotViews().get(i);
            if (slideView.getSlotViews().get(i).elementAt(x,y))
            {
                slideView.setSlotDraged(slotView.getSlot());
                break;
            }
        }
    }

    @Override
    public void mouseDraged(int x, int y, SlideView slideView)
    {
        Slot slot = (Slot)slideView.getSlotDraged();
        if (slot != null)
        {
            slot.setPosition(x, y);
            slot.notifySubscribers(slot, NotifyType.DragDropSlot);
            slideView.repaint();
            slideView.validate();
        }
    }

    @Override
    public void mouseReleased(SlideView slideView) {
        slideView.setSlotDraged(null);
    }
}
