package Controller;

import View.MainView;
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
        //if (MainView.getIntance().getSState() instanceof EditProjectState)
        //{
            MainView.getIntance().startSlideShowState();
        //}
        //else
        //{
        //    MainView.getIntance().startEditProjectState();
        //}
    }
}
