package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewAction extends AbstractRudokAction {

    public NewAction()
    {
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Radim");
    }
}
