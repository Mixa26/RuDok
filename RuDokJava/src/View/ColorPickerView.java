package View;

import javax.swing.*;
import java.awt.*;

public class ColorPickerView extends JDialog {
    private JColorChooser jColorChooser  = new JColorChooser();

    private JButton submitColor;

    public ColorPickerView()
    {
        setLayout(new BorderLayout());
        submitColor = new JButton(MainView.getInstance().getActionManager().getSubmitColorAction());
        Toolkit kit = Toolkit.getDefaultToolkit();
        setSize(new Dimension((int)kit.getScreenSize().getWidth() / 3,(int)kit.getScreenSize().getHeight() / 2));
        setLocationRelativeTo(MainView.getInstance());
        setTitle("Color picker");

        add(jColorChooser, BorderLayout.NORTH);
        add(submitColor, BorderLayout.SOUTH);
    }

    public Color getSelectedColor()
    {
        return jColorChooser.getColor();
    }

    public void setVisible()
    {
        setVisible(true);
    }
}
