package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class NoPresentationSlideShowError implements Error{
    public NoPresentationSlideShowError()
    {
        handleError();
    }
    @Override
    public void handleError() {
        JOptionPane.showMessageDialog(MainView.getIntance(), "No presentation in the project. Create a presentation and select it.", "No presentation selected", JOptionPane.ERROR_MESSAGE);
    }
}
