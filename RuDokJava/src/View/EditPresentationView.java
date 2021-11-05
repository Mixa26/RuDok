package View;

import Controller.EditPresentationAction;
import Model.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EditPresentationView extends JDialog {
    private JLabel authorLabel;
    private JTextField author;
    private JLabel imageURLLabel;
    private JTextField imageURL;
    private JButton submit;

    public EditPresentationView(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setSize(new Dimension((int) kit.getScreenSize().getWidth() / 8, (int) kit.getScreenSize().getHeight() / 8));
        setLocationRelativeTo(parent);


        BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(layout);

        authorLabel = new JLabel("Author:");
        authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        author = new JTextField();
        imageURLLabel = new JLabel("Background image URL:");
        imageURLLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageURL = new JTextField();

        add(authorLabel);
        add(author);
        add(imageURLLabel);
        add(imageURL);
    }

    public void setVisible()
    {
        author.setText("");
        imageURL.setText("");
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

    public JTextField getImageURL() {
        return imageURL;
    }
}
