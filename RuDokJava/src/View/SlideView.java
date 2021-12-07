package View;

import Model.treeModel.Presentation;
import Model.treeModel.Slide;

import javax.swing.*;
import java.awt.*;

public class SlideView extends JPanel{
    private Slide slide;

    private JLabel ordinalNumber;

    public SlideView(Slide slide) {
        this.slide = slide;
        setBackground(Color.LIGHT_GRAY);
        setMaximumSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3));
        setPreferredSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3));
        //setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 100)));
        setLayout(new BorderLayout());

        ordinalNumber = new JLabel(String.valueOf(slide.getOrdinalNumber()));
        ordinalNumber.setFont(new Font("Aerial", Font.BOLD, 25));
        add(ordinalNumber, BorderLayout.SOUTH);
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

    public boolean compareTo(SlideView slideView)
    {

        return this.slide.equals(slideView.slide);
        //return (slide == slideView.getSlide() && ordinalNumber == slideView.getOrdinalNumber());
    }

    public Slide getSlide() {
        return slide;
    }

    public JLabel getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(int ordinalNumber) {
        this.ordinalNumber.setText(String.valueOf(ordinalNumber));
    }
}
