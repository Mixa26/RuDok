package state.SlotState;

import Model.Slot;
import Model.treeModel.Slide;
import View.MainView;
import View.PresentationView;

public class AddSlotState extends SlotState {
    @Override
    public void mouseClicked(int x, int y, Slide slide) {
        Slot slot = new Slot(x, y);
        slot.setPosition(x-slot.getWidth()/2,y-slot.getHeight()/2);
        slot.setColor(((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getPickedColor());
        slide.addSlot(slot);
    }
}
