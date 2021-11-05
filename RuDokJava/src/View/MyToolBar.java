package View;

import Model.Main;

import javax.swing.*;

public class MyToolBar extends JToolBar {

    //komponente toolbara
    private JButton NewProject;
    private JButton NewPrezentation;
    private JButton NewSlide;
    private JButton rename;
    private JButton editPresentation;
    private JButton delete;
    private JButton info;

    public MyToolBar()
    {
        //init komponenti
        NewProject = new JButton(MainView.getIntance().getActionManager().getNewProjectAction());
        NewPrezentation = new JButton(MainView.getIntance().getActionManager().getNewPresentationAction());
        NewSlide = new JButton(MainView.getIntance().getActionManager().getNewSlideAction());
        rename = new JButton(MainView.getIntance().getActionManager().getRenameInTreeAction());
        editPresentation = new JButton(MainView.getIntance().getActionManager().getEditPresentationAction());
        delete = new JButton(MainView.getIntance().getActionManager().getDeleteAction());
        info = new JButton(MainView.getIntance().getActionManager().getInfoAction());

        NewProject.setText("");
        NewPrezentation.setText("");
        NewSlide.setText("");
        editPresentation.setText("");
        rename.setText("");
        delete.setText("");
        info.setText("");

        //dodavanje na toolbar
        add(NewProject);
        add(NewPrezentation);
        add(NewSlide);
        add(editPresentation);
        add(rename);
        add(delete);
        add(info);
    }

}
