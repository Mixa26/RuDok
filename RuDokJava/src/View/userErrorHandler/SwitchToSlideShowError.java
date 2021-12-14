package View.userErrorHandler;

import Controller.SwitchEditViewStateAction;
import View.MainView;

import javax.swing.*;

public class SwitchToSlideShowError implements Error{
    String message = "Please open a project with the presentation you want to present, and select a presentation.";

    public SwitchToSlideShowError()
    {
        handleError();
    }
    @Override
    public String handleError() {
        return message;
    }
}
