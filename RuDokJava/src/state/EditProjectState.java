package state;

import View.MainView;
import View.PresentationView;
import View.SlideShowView;

public class EditProjectState implements State{
    @Override
    public void changeState() {
        PresentationView presentationView = ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent());

        presentationView.removeAll();
        presentationView.add(presentationView.getMain());

        presentationView.repaint();
        presentationView.validate();
    }
}
