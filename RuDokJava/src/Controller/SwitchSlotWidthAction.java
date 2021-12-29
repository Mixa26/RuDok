package Controller;

import View.MainView;
import View.PresentationView;

import java.awt.event.ActionEvent;

public class SwitchSlotWidthAction extends AbstractRudokAction{
    int i = 0;

    public SwitchSlotWidthAction() {
        putValue(SMALL_ICON, loadIcon("images/smallBorder.png"));
        putValue(SHORT_DESCRIPTION, "Switch border width of slot to be created.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        i++;
        if (i>=3)
        {
            i=0;
        }
        ((PresentationView) MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getBorderState().changeState();
        switch (i)
        {
            case 0:
            {
                putValue(SMALL_ICON, loadIcon("images/smallBorder.png"));
                break;
            }
            case 1:
            {
                putValue(SMALL_ICON, loadIcon("images/mediumBorder.png"));
                break;
            }
            case 2:
            {
                putValue(SMALL_ICON, loadIcon("images/bigBorder.png"));
                break;
            }
        }

    }
}
