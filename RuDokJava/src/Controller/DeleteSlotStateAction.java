package Controller;

import View.MainView;
import View.PresentationView;

import java.awt.event.ActionEvent;

public class DeleteSlotStateAction extends AbstractRudokAction {
    public DeleteSlotStateAction() {
        putValue(NAME, "Delete slot");
        putValue(SMALL_ICON, loadIcon("images/eraseSlot.png"));
        putValue(SHORT_DESCRIPTION, "Delete a slot by clicking on it");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        presentationView.startDeleteSlotState();
        putValue(SMALL_ICON, loadIcon("images/eraseSlotSelected.png"));
    }

    public void resetIcon()
    {
        putValue(SMALL_ICON, loadIcon("images/eraseSlot.png"));
    }

    public void setSelectedIcon()
    {
        putValue(SMALL_ICON, loadIcon("images/eraseSlotSelected.png"));
    }
}
