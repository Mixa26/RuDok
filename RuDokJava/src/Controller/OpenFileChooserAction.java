package Controller;

import View.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class OpenFileChooserAction extends AbstractRudokAction{
    public OpenFileChooserAction() {
        putValue(NAME, "Choose a file");
        putValue(SHORT_DESCRIPTION, "Opens a new window for choosing a file.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        int response = jFileChooser.showOpenDialog(MainView.getInstance().getMyToolBar().getEditPresentationView());
        //int response = jFileChooser.showOpenDialog(MainView.getInstance().getActionManager().getEditPresentationAction().getEditPresentationView());

        if (response == JFileChooser.APPROVE_OPTION)
        {
            File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());

            MainView.getInstance().getActionManager().getSubmitPresentationInitialsAction().setUrl(file.toString());
        }

    }
}
