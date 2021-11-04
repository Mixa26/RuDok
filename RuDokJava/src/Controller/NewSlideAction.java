package Controller;

import java.awt.event.ActionEvent;

public class NewSlideAction extends AbstractRudokAction{

    public NewSlideAction() {
        putValue(NAME, "Slide");
        putValue(SMALL_ICON, loadIcon("images/newSlide.png"));
        putValue(SHORT_DESCRIPTION, "New Slide");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}