package Controller;

import View.MainView;
import View.PresentationView;

import java.awt.event.ActionEvent;

public class OpenColorPickerAction extends AbstractRudokAction{
    public OpenColorPickerAction() {
        putValue(NAME, "Choose a color");
        putValue(SMALL_ICON, loadIcon("images/colorPicker.png"));
        putValue(SHORT_DESCRIPTION, "Opens a new window for choosing a color of the slots.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getColorPickerView().setVisible();
    }
}
