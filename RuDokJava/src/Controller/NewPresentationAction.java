package Controller;

import java.awt.event.ActionEvent;

public class NewPresentationAction extends AbstractRudokAction{

    public NewPresentationAction() {
        putValue(NAME, "Presentation");
        putValue(SMALL_ICON, loadIcon("images/newPresentation.png"));
        putValue(SHORT_DESCRIPTION, "Creates a new presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
