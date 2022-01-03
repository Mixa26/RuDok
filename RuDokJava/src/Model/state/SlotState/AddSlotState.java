package Model.state.SlotState;

import Model.Slot;
import Model.treeModel.Slide;
import View.MainView;
import View.PresentationView;

public class AddSlotState extends SlotState {
    @Override
    public void mouseClicked(int x, int y, Slide slide) {
        PresentationView presentationView = ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        Slot slot = new Slot(x, y, presentationView.getSlotType());
        slot.setPosition(x-slot.getWidth()/2,y-slot.getHeight()/2);
        slot.setColor(presentationView.getPickedColor());
        slide.addSlot(slot);
    }
}
