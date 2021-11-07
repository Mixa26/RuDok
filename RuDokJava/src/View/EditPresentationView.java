package View;

import Model.treeModel.Presentation;
import View.treeSwingGUI.model.MyTreeNode;

import javax.swing.*;
import java.awt.*;

public class EditPresentationView extends JDialog {
    private JLabel authorLabel;
    private JTextField author;
    private JLabel imageURLLabel;
    private JButton file;
    private JButton submit;

    public EditPresentationView(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setSize(new Dimension((int) kit.getScreenSize().getWidth() / 7, (int) kit.getScreenSize().getHeight() / 7));
        setLocationRelativeTo(parent);

        BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(layout);

        authorLabel = new JLabel("Author:");
        authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        author = new JTextField();
        author.setMaximumSize(new Dimension((int) kit.getScreenSize().getWidth() / 8, (int) kit.getScreenSize().getHeight() / 50));
        imageURLLabel = new JLabel("Background image:");
        imageURLLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(authorLabel);
        add(author);
        add(imageURLLabel);
    }

    public void setVisible()
    {
        if (file == null)
        {
            file = new JButton(MainView.getIntance().getActionManager().getOpenFileChooserAction());
            file.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(file);
            add(Box.createHorizontalStrut((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 30));
        }

        author.setText(((Presentation)((MyTreeNode)MainView.getIntance().getMyTree().getSelectionPath().getLastPathComponent()).getNode()).getAuthor());
        if (submit == null)
        {
            submit = new JButton(MainView.getIntance().getActionManager().getSubmitPresentationInitialsAction());
            submit.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(submit);
        }
        setVisible(true);
    }

    public JTextField getAuthor() {
        return author;
    }



}
