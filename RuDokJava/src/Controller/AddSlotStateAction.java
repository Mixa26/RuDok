package Controller;

import View.MainView;
import View.PresentationView;

import java.awt.event.ActionEvent;

public class AddSlotStateAction extends AbstractRudokAction{

    public AddSlotStateAction() {
        putValue(NAME, "Add slot");
        putValue(SMALL_ICON, loadIcon("images/newSlotSelected.png"));
        putValue(SHORT_DESCRIPTION, "Add slots by clicking on the slide");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        presentationView.startAddSlotState();
        putValue(SMALL_ICON, loadIcon("images/newSlotSelected.png"));
    }

    public void resetIcon()
    {
        putValue(SMALL_ICON, loadIcon("images/newSlot.png"));
    }

    public void setSelectedIcon()
    {
        putValue(SMALL_ICON, loadIcon("images/newSlotSelected.png"));
    }
}
