package Controller;

import View.MainView;
import View.PresentationView;

import java.awt.*;
import java.awt.event.ActionEvent;

public class SumbitColorAction extends AbstractRudokAction{
    public SumbitColorAction() {
        putValue(NAME, "Submit");
        putValue(SHORT_DESCRIPTION, "Change slot color");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        Color colorSelected = presentationView.getColorPickerView().getSelectedColor();
        Color color = new Color(colorSelected.getRed(), colorSelected.getGreen(), colorSelected.getBlue(), 100);
        presentationView.setPickedColor(color);
        presentationView.getColorPickerView().setVisible(false);
    }
}
