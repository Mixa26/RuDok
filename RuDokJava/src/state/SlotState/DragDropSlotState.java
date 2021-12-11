package state.SlotState;

import Model.Slot;
import Model.treeModel.Slide;
import observer.NotifyType;

public class DragDropSlotState extends SlotState{
    @Override
    public void mousePressed(int x, int y, Slide slide) {
        for (int i = slide.getSlots().size()-1; i >= 0; i--)
        {
            Slot slot = slide.getSlots().get(i);
            if (slot.elementAt(x,y))
            {
                slide.setSlotDraged(slot);
                slide.setRelativePosX(x - slot.getX());
                slide.setRelativePosY(y - slot.getY());
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
            slide.notifySubscribers(slide, NotifyType.RefreshSlides);
        }
    }

    @Override
    public void mouseReleased(Slide slide) {
        slide.setSlotDraged(null);
    }
}
