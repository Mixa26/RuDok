package state.SlotState;

import View.MainView;
import View.PresentationView;
import View.SlideView;
import View.SlotView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StateMouseListener implements MouseListener {
    private SlideView slideView;

    public StateMouseListener(SlideView slideView) {
        this.slideView = slideView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getPoint().x;
        int y = e.getPoint().y;

        ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).SlotStateMouseClicked(x,y,slideView);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getPoint().x;
        int y = e.getPoint().y;

        ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).SlotStateMousePressed(x,y,slideView);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).SlotStateMouseReleased(slideView);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
