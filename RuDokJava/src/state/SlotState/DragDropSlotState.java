package state.SlotState;

import Model.Slot;
import Model.treeModel.Slide;
import View.SlideView;
import View.SlotView;
import observer.NotifyType;

public class DragDropSlotState extends SlotState{
    @Override
    public void mousePressed(int x, int y, Slide slide) {
        for (int i = slide.getSlideViews().get(0).getSlotViews().size()-1; i >= 0; i--)
        {
            SlotView slotView = slide.getSlideViews().get(0).getSlotViews().get(i);
            if (slotView.elementAt(x,y))
            {
                slide.setSlotDraged(slotView.getSlot());
                slide.setRelativePosX(x - slotView.getSlot().getX());
                slide.setRelativePosY(y - slotView.getSlot().getY());
                break;
            }
        }
    }

    @Override
    public void mouseDraged(int x, int y, Slide slide)
    {
        Slot slot = (Slot)slide.getSlotDraged();
        if (slot != null)
        {
            slot.setPosition(x-slide.getRelativePosX(), y-slide.getRelativePosY());
            slot.notifySubscribers(slot, NotifyType.DragDropSlot);
            for (SlideView slideView1 : slide.getSlideViews())
            {
                slideView1.repaint();
                slideView1.validate();
            }
        }
    }

    @Override
    public void mouseReleased(Slide slide) {
        slide.setSlotDraged(null);
    }
}
