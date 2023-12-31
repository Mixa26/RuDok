package Model.state.SlotBorderStrokeState;

import View.MainView;
import View.PresentationView;
import Model.state.WorkModeState.State;

import java.awt.*;

public class FullStrokeState implements State {
    @Override
    public void changeState() {
        float strokeWidth = ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getStrokeWidth();
        Stroke stroke = new BasicStroke(strokeWidth);
        ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).setStroke(stroke);
    }
}
