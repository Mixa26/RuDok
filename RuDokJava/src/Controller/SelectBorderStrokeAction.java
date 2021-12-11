package Controller;

import View.MainView;
import View.PresentationView;
import state.SlotBorderStrokeState.FullStrokeState;
import state.SlotBorderStrokeState.SplitStrokeState;

import java.awt.event.ActionEvent;

public class SelectBorderStrokeAction extends AbstractRudokAction{
    public SelectBorderStrokeAction() {
        putValue(NAME, "Submit");
        putValue(SMALL_ICON, loadIcon("images/rectangle.png"));
        putValue(SHORT_DESCRIPTION, "Change slot color");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        if (presentationView.getStrokeState() instanceof FullStrokeState)
        {
            presentationView.startSplitStrokeState();
            putValue(SMALL_ICON, loadIcon("images/dashedRectangle.png"));
        }
        else if (((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getStrokeState() instanceof SplitStrokeState)
        {
            presentationView.startFullStrokeState();
            putValue(SMALL_ICON, loadIcon("images/rectangle.png"));
        }
    }
}
