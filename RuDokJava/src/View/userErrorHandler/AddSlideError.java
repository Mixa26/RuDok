package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class AddSlideError implements Error{
    String message = "Please select a presentation to add a slide to.";

    public AddSlideError() {
        handleError();
    }

    @Override
    public String handleError() {
        return message;
    }
}
