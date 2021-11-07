package View;

import Model.treeModel.Presentation;
import Model.treeModel.Slide;

import javax.swing.*;
import java.awt.*;

public class SlideView extends JPanel{
    private Slide slide;

    public SlideView(Slide slide) {
        this.slide = slide;
        setBackground(Color.LIGHT_GRAY);
        setMaximumSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3));
        setPreferredSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (new ImageIcon(((Presentation)slide.getParent()).getBackgroundImage()).getImage() != null)
        {
            Image image = new ImageIcon(((Presentation)slide.getParent()).getBackgroundImage()).getImage();
            g.drawImage((image),0, 0, null);
        }

    }
}
