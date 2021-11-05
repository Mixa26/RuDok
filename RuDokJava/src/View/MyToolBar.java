package View;

import javax.swing.*;

public class MyToolBar extends JToolBar {

    //komponente toolbara
    private JButton NewProject;
    private JButton NewPrezentation;
    private JButton NewSlide;
    private JButton delete;
    private JButton info;

    public MyToolBar()
    {
        //init komponenti
        NewProject = new JButton(MainView.getIntance().getActionManager().getNewProjectAction());
        NewPrezentation = new JButton(MainView.getIntance().getActionManager().getNewPresentationAction());
        NewSlide = new JButton(MainView.getIntance().getActionManager().getNewSlideAction());
        delete = new JButton(MainView.getIntance().getActionManager().getDeleteAction());
        info = new JButton(MainView.getIntance().getActionManager().getInfoAction());

        NewProject.setText("");
        NewPrezentation.setText("");
        NewSlide.setText("");
        delete.setText("");
        info.setText("");

        //dodavanje na toolbar
        add(NewProject);
        add(NewPrezentation);
        add(NewSlide);
        add(delete);
        add(info);
    }
}
