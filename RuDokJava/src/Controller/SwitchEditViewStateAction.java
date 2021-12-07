package Controller;

import Model.Main;
import View.MainView;
import View.PresentationView;
import View.userErrorHandler.ErrorFactory;
import state.EditProjectState;
import state.StateManager;

import java.awt.event.ActionEvent;

public class SwitchEditViewStateAction extends AbstractRudokAction {
    public SwitchEditViewStateAction() {
        putValue(NAME, "Switch Edit/Slideshow");
        putValue(SMALL_ICON, loadIcon("images/slideShow.png"));
        putValue(SHORT_DESCRIPTION, "Switch between Edit/View slide states");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        if (presentationView.getSState() instanceof EditProjectState)
        {
            if (MainView.getIntance().getRightWorkArea().getjTabbedPane().getTabCount() == 0)
            {
                MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.NoPresentationSlideShowError);
                return;
            }
            if (MainView.getIntance().getRightWorkArea().getProject() != null)
            {
                presentationView.startSlideShowState();
            }
            else
            {
                MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.SwitchToSlideShowError);
            }
        }
        else
        {
            presentationView.startEditProjectState();
        }
    }
}
