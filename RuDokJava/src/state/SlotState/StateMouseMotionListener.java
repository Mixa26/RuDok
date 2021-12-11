package state.SlotState;

import Model.treeModel.Slide;
import View.MainView;
import View.PresentationView;
import View.SlideView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class StateMouseMotionListener implements MouseMotionListener {
    Slide slide;

    public StateMouseMotionListener(Slide slide) {
        this.slide = slide;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).SlotStateMouseDraged(e.getX(), e.getY(), slide);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
