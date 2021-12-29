package Controller;

import View.MainView;
import View.PresentationView;
import View.userErrorHandler.ErrorFactory;
import state.EditProjectState;

import java.awt.event.ActionEvent;

public class SwitchEditViewStateAction extends AbstractRudokAction {
    public SwitchEditViewStateAction() {
        putValue(NAME, "Switch Edit/Slideshow");
        putValue(SMALL_ICON, loadIcon("images/slideShow.png"));
        putValue(SHORT_DESCRIPTION, "Switch between Edit/View slide states");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        if (presentationView.getSState() instanceof EditProjectState)
        {
            if (MainView.getInstance().getRightWorkArea().getjTabbedPane().getTabCount() == 0)
            {
                MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.NoPresentationSlideShowError);
                return;
            }
            if (MainView.getInstance().getRightWorkArea().getProject() != null)
            {
                presentationView.startSlideShowState();
            }
            else
            {
                MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.SwitchToSlideShowError);
            }
        }
        else
        {
            presentationView.startEditProjectState();
        }
    }
}
