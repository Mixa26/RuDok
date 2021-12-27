package View;

import javax.swing.*;
import java.awt.*;

public class TextEditorView extends JDialog {
    private JTextPane jTextPane;
    private JButton submitText;

    public TextEditorView() {
        setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/ 8, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()/ 8));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(MainView.getIntance());
        jTextPane = new JTextPane();
        submitText = new JButton(MainView.getIntance().getActionManager().getSlotAddTextAction());
        setLayout(new BorderLayout());
        add(jTextPane, BorderLayout.CENTER);
        add(submitText, BorderLayout.SOUTH);
    }

    public JTextPane getjTextPane() {
        return jTextPane;
    }
}
