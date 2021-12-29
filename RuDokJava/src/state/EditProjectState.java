package state;

import View.MainView;
import View.PresentationView;

public class EditProjectState implements State{
    @Override
    public void changeState() {
        PresentationView presentationView = ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent());

        presentationView.removeAll();
        presentationView.add(presentationView.getMain());

        presentationView.repaint();
        presentationView.validate();
    }
}
