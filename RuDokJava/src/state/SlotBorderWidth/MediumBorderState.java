package state.SlotBorderWidth;

import View.MainView;
import View.PresentationView;
import state.State;

public class MediumBorderState implements State {
    float width = 3.0f;
    @Override
    public void changeState() {
        PresentationView presentationView = ((PresentationView) MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        presentationView.startBigBorderState();
        presentationView.setStrokeWidth(((BigBorderState)presentationView.getBorderState()).getWidth());
        presentationView.getStrokeState().changeState();
        presentationView.getStrokeState().changeState();
    }

    public float getWidth() {
        return width;
    }
}
