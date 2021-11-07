package View.userErrorHandler;

import View.MainView;

import javax.swing.*;

public class InvalidImageError implements Error{
    public InvalidImageError() {
        handleError();
    }

    @Override
    public void handleError() {
        JOptionPane.showMessageDialog(MainView.getIntance().getActionManager().getEditPresentationAction().getEditPresentationView() ,"Invalid image.", "Error loading the image",JOptionPane.ERROR_MESSAGE);
    }
}
