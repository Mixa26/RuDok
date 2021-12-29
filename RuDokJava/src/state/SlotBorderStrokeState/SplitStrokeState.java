package state.SlotBorderStrokeState;

import View.MainView;
import View.PresentationView;
import state.State;

import java.awt.*;

public class SplitStrokeState implements State {
    @Override
    public void changeState() {
        float strokeWidth = ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getStrokeWidth();
        float dash1[] = {10.0f};
        Stroke stroke = new BasicStroke(strokeWidth,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                10.0f, dash1, 0.0f);
        ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).setStroke(stroke);
    }
}
