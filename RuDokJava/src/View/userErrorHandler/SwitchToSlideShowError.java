package View.userErrorHandler;

import Controller.SwitchEditViewStateAction;
import View.MainView;

import javax.swing.*;

public class SwitchToSlideShowError implements Error{
    public SwitchToSlideShowError()
    {
        handleError();
    }
    @Override
    public void handleError() {
        JOptionPane.showMessageDialog(MainView.getIntance(), "Please open a project with the presentation you want to present, and select a presentation.", "No presentation selected", JOptionPane.ERROR_MESSAGE);
    }
}
