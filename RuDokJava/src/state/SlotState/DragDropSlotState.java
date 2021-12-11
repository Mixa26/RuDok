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
                slideView.setRelativePosX(x - slideView.getSlotViews().get(i).getSlot().getX());
                slideView.setRelativePosY(y - slideView.getSlotViews().get(i).getSlot().getY());
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
            slot.setPosition(x-slideView.getRelativePosX(), y-slideView.getRelativePosY());
            slot.notifySubscribers(slot, NotifyType.DragDropSlot);
            for (SlideView slideView1 : slideView.getSlide().getSlideViews())
            {
                slideView1.repaint();
                slideView1.validate();
            }
        }
    }

    @Override
    public void mouseReleased(SlideView slideView) {
        slideView.setSlotDraged(null);
    }
}
