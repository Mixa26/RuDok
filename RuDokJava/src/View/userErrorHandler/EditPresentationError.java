package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class EditPresentationError implements Error{
    String message = "Please select a presentation to edit.";

    public EditPresentationError() {
        handleError();
    }

    @Override
    public String handleError() {
        return message;
    }
}
