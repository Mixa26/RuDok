package Controller;

import View.EditPresentationView;
import View.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditPresentationAction extends AbstractRudokAction {

    public EditPresentationAction()
    {
        putValue(NAME, "Presentation");
        putValue(SHORT_DESCRIPTION, "Edit author and background image");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new EditPresentationView(MainView.getIntance(), "Edit presentation", true);
    }
}
