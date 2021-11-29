package state;

import View.MainView;
import View.SlideShowView;

public class EditProjectState implements State{
    @Override
    public void changeState() {
        MainView.getIntance().getContentPane().removeAll();
        MainView.getIntance().initialiseGUI();
        MainView.getIntance().getRightWorkArea().openProject(((SlideShowView)MainView.getIntance().getContentPane()).getProject());
        MainView.getIntance().getRightWorkArea().getjTabbedPane().setSelectedIndex(((SlideShowView)MainView.getIntance().getContentPane()).getSelectedTab());
        MainView.getIntance().validate();
    }
}
