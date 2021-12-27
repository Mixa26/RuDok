package state.SlotState;

import Model.Slot;
import Model.treeModel.Slide;
import View.MainView;
import View.PresentationView;

public class DeleteSlotState extends SlotState {
    @Override
    public void mouseClicked(int x, int y, Slide slide) {
        for (int i = slide.getSlots().size()-1; i >= 0; i--)
        {
            Slot slot = slide.getSlots().get(i);
            if (slot.elementAt(x,y))
            {
                if (slot.equals(((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getSlotSelected()))
                {
                    ((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).setSlotSelected(null);
                }
                slide.removeSlot(slot);
                break;
            }
        }
    }
}
