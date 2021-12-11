package state.SlotBorderWidth;

import View.MainView;
import View.PresentationView;
import state.State;

public class BigBorderState implements State {
    float width = 8.0f;
    @Override
    public void changeState() {
        PresentationView presentationView = ((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        presentationView.startSmallBorderState();
        presentationView.setStrokeWidth(((SmallBorderState)presentationView.getBorderState()).getWidth());
        presentationView.getStrokeState().changeState();
        presentationView.getStrokeState().changeState();
    }

    public float getWidth() {
        return width;
    }
}
