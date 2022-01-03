package Model.state.SlotBorderWidth;

import View.MainView;
import View.PresentationView;
import Model.state.WorkModeState.State;

public class BigBorderState implements State {
    float width = 8.0f;
    @Override
    public void changeState() {
        PresentationView presentationView = ((PresentationView) MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        presentationView.startSmallBorderState();
        presentationView.setStrokeWidth(((SmallBorderState)presentationView.getBorderState()).getWidth());
        presentationView.getStrokeState().changeState();
        presentationView.getStrokeState().changeState();
    }

    public float getWidth() {
        return width;
    }
}
