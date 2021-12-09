package state.SlotState;

import Model.Slot;
import View.MainView;
import View.PresentationView;
import View.SlideView;
import View.SlotView;
import observer.NotifyType;
import state.State;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

public class StateMouseListener implements MouseListener {
    private SlideView slideView;

    public StateMouseListener(SlideView slideView) {
        this.slideView = slideView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getPoint().x;
        int y = e.getPoint().y;

        ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).SlotStateMousePressed(x,y,slideView);

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
