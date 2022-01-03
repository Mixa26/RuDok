package Model.state.SlotBorderWidth;

import View.MainView;
import View.PresentationView;
import Model.state.WorkModeState.State;

public class SmallBorderState implements State {
    float width = 1.0f;
    @Override
    public void changeState() {
        PresentationView presentationView = ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        presentationView.startMediumBorderState();
        presentationView.setStrokeWidth(((MediumBorderState)presentationView.getBorderState()).getWidth());
        presentationView.getStrokeState().changeState();
        presentationView.getStrokeState().changeState();
    }

    public float getWidth() {
        return width;
    }
}
