package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class RenameInTreeError implements Error{
    String message = "Please select a component to rename.";

    public RenameInTreeError() {
        handleError();
    }

    @Override
    public String handleError() {
        return message;
    }
}
