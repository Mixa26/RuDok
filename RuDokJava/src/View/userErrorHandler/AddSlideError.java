package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class AddSlideError implements Error{
    public AddSlideError() {
        handleError();
    }

    @Override
    public void handleError() {
        JOptionPane.showMessageDialog(MainView.getIntance(), "Please select a presentation to add a slide to.");
    }
}
