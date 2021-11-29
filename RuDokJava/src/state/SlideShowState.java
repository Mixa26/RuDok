package state;

import View.MainView;
import View.SlideShowView;

public class SlideShowState implements State{
    @Override
    public void changeState() {
        SlideShowView ssv = new SlideShowView();
        ssv.setProject(MainView.getIntance().getRightWorkArea().getProject());
        ssv.setSelectedTab(MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedIndex());
        MainView.getIntance().getContentPane().removeAll();
        MainView.getIntance().getMyMenuBar().removeAll();
        MainView.getIntance().setContentPane(ssv);
        MainView.getIntance().validate();
    }
}
