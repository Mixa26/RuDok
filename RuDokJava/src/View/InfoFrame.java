package View;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends JDialog {

    private Label student;

    public InfoFrame(Frame parent, String title, boolean modal)
    {
        super(parent, title, modal);
        setSize(new Dimension(500,500));
        setLocationRelativeTo(parent);

        student = new Label("Mihajlo Madzarevic RN 55/20 ");

        add(student);

        setVisible(true);
    }

}
