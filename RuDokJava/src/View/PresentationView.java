package View;

import Model.treeModel.Presentation;
import Model.treeModel.Slide;

import javax.swing.*;
import java.awt.*;

public class PresentationView extends JPanel {

    private Presentation presentation;
    private JPanel panel;
    private JScrollPane jScrollPane;
    private JLabel author;

    public PresentationView(Presentation presentation)
    {
        this.presentation = presentation;

        int slideSeparationHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 65;

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        author = new JLabel(presentation.getAuthor());
        author.setFont(new Font("Aerial", Font.BOLD, 20));
        author.setAlignmentX(Component.CENTER_ALIGNMENT);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        panel.add(author);

        for (int i = 0; i < presentation.getChildren().size(); i++)
        {
            panel.add(new SlideView((Slide)presentation.getChildren().get(i)));
            panel.add(Box.createVerticalStrut(slideSeparationHeight));
        }

        jScrollPane = new JScrollPane(panel);
        add(jScrollPane);
    }

}
