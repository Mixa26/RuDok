package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class InfoView extends JDialog {

    private ImageIcon studentPicture;
    private JLabel student;

    public InfoView(Frame parent, String title, boolean modal)
    {
        super(parent, title, modal);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setSize(new Dimension((int)kit.getScreenSize().getWidth() / 3,(int)kit.getScreenSize().getHeight() / 2));
        setLocationRelativeTo(parent);

        studentPicture = new ImageIcon("images/mixa.jpg");
        student = new JLabel("Mihajlo Madzarevic RN 55/20 ", studentPicture, JLabel.CENTER);

        add(student);

        setVisible(true);
    }

}
