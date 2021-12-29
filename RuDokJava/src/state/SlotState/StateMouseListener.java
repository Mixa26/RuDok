package state.SlotState;

import Model.treeModel.Slide;
import View.MainView;
import View.PresentationView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StateMouseListener implements MouseListener {
    private Slide slide;

    public StateMouseListener(Slide slide) {
        this.slide = slide;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getPoint().x;
        int y = e.getPoint().y;

        ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).SlotStateMouseClicked(x,y,slide);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getPoint().x;
        int y = e.getPoint().y;

        ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).SlotStateMousePressed(x,y,slide);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).SlotStateMouseReleased(slide);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
