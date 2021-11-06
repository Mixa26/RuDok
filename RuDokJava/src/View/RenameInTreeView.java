package View;

import javax.swing.*;
import java.awt.*;

public class RenameInTreeView extends JDialog {

    private JLabel rename;
    private JTextField nameField;
    private JButton ok;

    public RenameInTreeView(Frame parent, String title, boolean modal)
    {
        super(parent, title, modal);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setSize(new Dimension((int)kit.getScreenSize().getWidth() / 11,(int)kit.getScreenSize().getHeight() / 11));
        setLocationRelativeTo(parent);

        BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(layout);

        rename = new JLabel("New name:");
        rename.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameField = new JTextField();

        add(rename);
        add(nameField);
    }

    public void setVisible() {
        nameField.setText("");
        if (ok == null)
        {
            ok = new JButton(MainView.getIntance().getActionManager().getSubmitRenameIntialsAction());
            ok.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(ok);
        }
        setVisible(true);
    }

    public JTextField getNameField() {
        return nameField;
    }
}
