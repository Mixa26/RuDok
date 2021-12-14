package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class NoPresentationSlideShowError implements Error{
    String message = "No presentation in the project. Create a presentation and select it.";

    public NoPresentationSlideShowError()
    {
        handleError();
    }
    @Override
    public String handleError() {
        return message;
    }
}
