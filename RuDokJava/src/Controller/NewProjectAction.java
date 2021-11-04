package Controller;

import java.awt.event.ActionEvent;

public class NewProjectAction extends AbstractRudokAction{

    public NewProjectAction() {
        putValue(NAME, "Project");
        putValue(SMALL_ICON, loadIcon("images/newProject.png"));
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
