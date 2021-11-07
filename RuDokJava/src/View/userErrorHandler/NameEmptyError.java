package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class NameEmptyError implements Error{
    public NameEmptyError() {
        handleError();
    }

    @Override
    public void handleError() {
        JOptionPane.showMessageDialog(MainView.getIntance().getActionManager().getRenameInTreeAction().getRenameInTreeView(), "Name of component can't be shorter than one character.");
    }
}
