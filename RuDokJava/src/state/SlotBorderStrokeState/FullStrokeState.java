package state.SlotBorderStrokeState;

import View.MainView;
import View.PresentationView;
import state.State;

import java.awt.*;

public class FullStrokeState implements State {
    @Override
    public void changeState() {
        float strokeWidth = ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getStrokeWidth();
        Stroke stroke = new BasicStroke(strokeWidth);
        ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).setStroke(stroke);
    }
}