package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class EditPresentationError implements Error{

    public EditPresentationError() {
        handleError();
    }

    @Override
    public void handleError() {
        JOptionPane.showMessageDialog(MainView.getIntance(), "Please select a presentation to edit.");
    }
}
