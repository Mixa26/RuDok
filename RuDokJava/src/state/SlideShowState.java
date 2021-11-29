package state;

import View.MainView;
import View.SlideShowView;

public class SlideShowState implements State{
    @Override
    public void changeState() {
        SlideShowView ssv = new SlideShowView();
        MainView.getIntance().getContentPane().removeAll();
        MainView.getIntance().getMyMenuBar().removeAll();
        MainView.getIntance().setContentPane(ssv);
        MainView.getIntance().validate();
    }
}
