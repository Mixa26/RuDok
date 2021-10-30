package View;

import Controller.EditPresentationAction;

import javax.swing.*;
import java.awt.*;

public class EditPresentationView extends JDialog {

    public EditPresentationView(Frame parent, String title, boolean modal)
    {
        super(parent, title, modal);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setSize(new Dimension((int)kit.getScreenSize().getWidth() / 3, (int)kit.getScreenSize().getHeight() / 3));
        setLocationRelativeTo(parent);

        setVisible(true);
    }
}
