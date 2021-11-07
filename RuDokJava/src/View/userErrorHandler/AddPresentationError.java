package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class AddPresentationError implements Error{
    public AddPresentationError() {
        handleError();
    }

    @Override
    public void handleError() {
        JOptionPane.showMessageDialog(MainView.getIntance(),"Please select a project to add a presentation to.");
    }
}
