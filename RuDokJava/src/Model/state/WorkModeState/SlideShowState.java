package Model.state.WorkModeState;

import View.MainView;
import View.PresentationView;
import View.SlideShowView;

public class SlideShowState implements State{
    @Override
    public void changeState() {
        PresentationView presentationView = ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent());

        if (presentationView.getSsv() == null)
        {
            SlideShowView ssv = new SlideShowView();
            presentationView.setSsv(ssv);
        }

        presentationView.removeAll();
        presentationView.add(presentationView.getSsv());
        presentationView.repaint();
        presentationView.validate();
    }
}
