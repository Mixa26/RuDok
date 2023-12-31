package Model.state.SlotState;

import Model.Slot;
import Model.treeModel.Slide;
import View.MainView;
import View.PresentationView;
import Model.observer.NotifyType;

import java.awt.*;

public class DragDropSlotState extends SlotState{
    @Override
    public void mousePressed(int x, int y, Slide slide) {
        for (int i = slide.getSlots().size()-1; i >= 0; i--)
        {
            Slot slot = slide.getSlots().get(i);
            if (slot.elementAt(x,y))
            {
                slot.setColor(new Color(slot.getColor().getRed(), slot.getColor().getGreen(), slot.getColor().getBlue(), 255));
                slide.setSlotDraged(slot);
                PresentationView presentationView = (PresentationView) MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent();
                if (presentationView.getSlotSelected() != null && presentationView.getSlotSelected() != slot) {
                    presentationView.getSlotSelected().setColor(new Color(presentationView.getSlotSelected().getColor().getRed(), presentationView.getSlotSelected().getColor().getGreen(), presentationView.getSlotSelected().getColor().getBlue(), 100));
                }
                presentationView.setSlotSelected(slot);
                slide.notifySubscribers(slide, NotifyType.RefreshSlides);
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
        if (slide.getSlotDraged() != null)
        {
            slide.getSlotDraged().setColor(new Color(slide.getSlotDraged().getColor().getRed(), slide.getSlotDraged().getColor().getGreen(), slide.getSlotDraged().getColor().getBlue(), 255));
            slide.notifySubscribers(slide, NotifyType.RefreshSlides);
            slide.setSlotDraged(null);
        }
    }
}
