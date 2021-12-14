package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class DeleteError implements Error{
    String message = "Please select a component (different from Workspace) to delete it.";

    public DeleteError() {
        handleError();
    }

    @Override
    public String handleError() {
        return message;
    }
}
