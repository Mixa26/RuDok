package Controller;

import View.InfoView;
import View.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class InfoAction extends AbstractRudokAction {

    public InfoAction()
    {
        putValue(NAME, "Info");
        putValue(SMALL_ICON, loadIcon("images/info.png"));
        putValue(SHORT_DESCRIPTION, "Info");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new InfoView(MainView.getIntance(),"Info", true);
    }
}
