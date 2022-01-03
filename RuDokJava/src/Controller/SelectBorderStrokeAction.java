package Controller;

import View.MainView;
import View.PresentationView;
import Model.state.SlotBorderStrokeState.FullStrokeState;
import Model.state.SlotBorderStrokeState.SplitStrokeState;

import java.awt.event.ActionEvent;

public class SelectBorderStrokeAction extends AbstractRudokAction{
    public SelectBorderStrokeAction() {
        putValue(SMALL_ICON, loadIcon("images/rectangle.png"));
        putValue(SHORT_DESCRIPTION, "Switch the border type of the slot to be created.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView) MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        if (presentationView.getStrokeState() instanceof FullStrokeState)
        {
            presentationView.startSplitStrokeState();
            putValue(SMALL_ICON, loadIcon("images/dashedRectangle.png"));
        }
        else if (((PresentationView) MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getStrokeState() instanceof SplitStrokeState)
        {
            presentationView.startFullStrokeState();
            putValue(SMALL_ICON, loadIcon("images/rectangle.png"));
        }
    }
}
