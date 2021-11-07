package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class DeleteError implements Error{
    public DeleteError() {
        handleError();
    }

    @Override
    public void handleError() {
        JOptionPane.showMessageDialog(MainView.getIntance(), "Please select a component (different from Workspace) to delete it.");
    }
}
