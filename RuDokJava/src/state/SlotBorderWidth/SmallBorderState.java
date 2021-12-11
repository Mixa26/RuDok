package state.SlotBorderWidth;

import View.MainView;
import View.PresentationView;
import state.State;

public class SmallBorderState implements State {
    float width = 1.0f;
    @Override
    public void changeState() {
        PresentationView presentationView = ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        presentationView.startMediumBorderState();
        presentationView.setStrokeWidth(((MediumBorderState)presentationView.getBorderState()).getWidth());
        presentationView.getStrokeState().changeState();
        presentationView.getStrokeState().changeState();
    }

    public float getWidth() {
        return width;
    }
}