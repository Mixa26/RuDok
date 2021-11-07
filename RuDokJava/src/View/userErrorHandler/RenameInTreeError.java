package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class RenameInTreeError implements Error{
    public RenameInTreeError() {
        handleError();
    }

    @Override
    public void handleError() {
        JOptionPane.showMessageDialog(MainView.getIntance(), "Please select a component to rename.");
    }
}
