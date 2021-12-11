package state.SlotState;

import Model.Slot;
import Model.treeModel.Slide;
import View.MainView;
import View.PresentationView;
import View.SlideView;

public class AddSlotState extends SlotState {
    @Override
    public void mouseClicked(int x, int y, Slide slide) {
        Slot slot = new Slot(x, y);
        slot.setColor(((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getPickedColor());
        slide.addSlot(slot);
    }
}
