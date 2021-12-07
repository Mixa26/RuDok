package state;

import View.MainView;
import View.PresentationView;
import View.SlideShowView;

public class SlideShowState implements State{
    @Override
    public void changeState() {
        SlideShowView ssv = new SlideShowView();

        PresentationView presentationView = ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent());

        presentationView.removeAll();
        presentationView.add(ssv);
        presentationView.validate();
    }
}
