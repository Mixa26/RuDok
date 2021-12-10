package Controller;

import View.MainView;
import View.PresentationView;

import java.awt.event.ActionEvent;

public class DragDropSlotStateAction extends AbstractRudokAction {
    public DragDropSlotStateAction() {
        putValue(NAME, "Drag a slot");
        putValue(SMALL_ICON, loadIcon("images/newSlot.png"));
        putValue(SHORT_DESCRIPTION, "Drag a slot by pressing on it and moving");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        presentationView.startDragDropSlotState();
    }
}
