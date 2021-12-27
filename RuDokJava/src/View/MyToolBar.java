package View;

import javax.swing.*;

public class MyToolBar extends JToolBar {

    //komponente toolbara
    private JButton NewProject;
    private JButton NewPrezentation;
    private JButton NewSlide;
    private JButton rename;
    private JButton editPresentation;
    private JButton delete;
    private JButton undoAction;
    private JButton redoAction;
    private JButton info;

    public MyToolBar()
    {
        setFloatable(false);
        //init komponenti
        NewProject = new JButton(MainView.getIntance().getActionManager().getNewProjectAction());
        NewPrezentation = new JButton(MainView.getIntance().getActionManager().getNewPresentationAction());
        NewSlide = new JButton(MainView.getIntance().getActionManager().getNewSlideAction());
        rename = new JButton(MainView.getIntance().getActionManager().getRenameInTreeAction());
        editPresentation = new JButton(MainView.getIntance().getActionManager().getEditPresentationAction());
        delete = new JButton(MainView.getIntance().getActionManager().getDeleteAction());
        undoAction = new JButton(MainView.getIntance().getActionManager().getUndoAction());
        redoAction = new JButton(MainView.getIntance().getActionManager().getRedoAction());
        info = new JButton(MainView.getIntance().getActionManager().getInfoAction());

        NewProject.setText("");
        NewPrezentation.setText("");
        NewSlide.setText("");
        editPresentation.setText("");
        rename.setText("");
        delete.setText("");
        undoAction.setText("");
        redoAction.setText("");
        info.setText("");

        //dodavanje na toolbar
        add(NewProject);
        add(NewPrezentation);
        add(NewSlide);
        add(editPresentation);
        add(rename);
        add(delete);
        add(undoAction);
        add(redoAction);
        add(info);
    }

}
