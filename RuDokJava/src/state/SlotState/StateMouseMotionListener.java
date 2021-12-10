package state.SlotState;

import View.MainView;
import View.PresentationView;
import View.SlideView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class StateMouseMotionListener implements MouseMotionListener {
    SlideView slideView;

    public StateMouseMotionListener(SlideView slideView) {
        this.slideView = slideView;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).SlotStateMouseDraged(e.getX(), e.getY(), slideView);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
