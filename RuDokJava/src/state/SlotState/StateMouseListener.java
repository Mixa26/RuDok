package state.SlotState;

import Model.Slot;
import View.MainView;
import View.PresentationView;
import View.SlideView;
import View.SlotView;
import observer.NotifyType;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StateMouseListener implements MouseListener {
    private SlideView slideView;

    public StateMouseListener(SlideView slideView) {
        this.slideView = slideView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getSlotState() instanceof AddSlotState)
        {
            int x = e.getPoint().x;
            int y = e.getPoint().y;

            Slot slot = new Slot(x, y);
            slideView.getSlide().getSlots().add(slot);
            slideView.getSlide().notifySubscribers(slot, NotifyType.AddSlot);
            System.out.println("Klik na " + x + "," + y);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
