package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class NameEmptyError implements Error{
    String message = "Name of component can't be shorter than one character.";

    public NameEmptyError() {
        handleError();
    }

    @Override
    public String handleError() {
        return message;
    }
}
