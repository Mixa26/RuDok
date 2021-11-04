package Controller;

import javax.swing.*;
import java.net.URL;

abstract class AbstractRudokAction extends AbstractAction {
    public AbstractRudokAction() {
    }

    public Icon loadIcon(String fileName) {
        URL imageURL = this.getClass().getResource(fileName);
        Icon icon = null;
        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        } else {
            System.err.println("Resource not found: " + fileName);
        }

        return icon;
    }
}
