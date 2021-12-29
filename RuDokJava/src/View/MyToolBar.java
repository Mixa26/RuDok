package View;

import javax.swing.*;

public class MyToolBar extends JToolBar {

    //komponente toolbara
    private JButton NewProject;
    private JButton NewPresentation;
    private JButton NewSlide;
    private JButton rename;
    private JButton editPresentation;
    private JButton sharePresentation;
    private JButton delete;
    private JButton undoAction;
    private JButton redoAction;
    private JButton info;

    public MyToolBar()
    {
        setFloatable(false);
        //init komponenti
        NewProject = new JButton(MainView.getInstance().getActionManager().getNewProjectAction());
        NewPresentation = new JButton(MainView.getInstance().getActionManager().getNewPresentationAction());
        NewSlide = new JButton(MainView.getInstance().getActionManager().getNewSlideAction());
        rename = new JButton(MainView.getInstance().getActionManager().getRenameInTreeAction());
        editPresentation = new JButton(MainView.getInstance().getActionManager().getEditPresentationAction());
        sharePresentation = new JButton(MainView.getInstance().getActionManager().getSharePresentationAction());
        delete = new JButton(MainView.getInstance().getActionManager().getDeleteAction());
        undoAction = new JButton(MainView.getInstance().getActionManager().getUndoAction());
        redoAction = new JButton(MainView.getInstance().getActionManager().getRedoAction());
        info = new JButton(MainView.getInstance().getActionManager().getInfoAction());

        NewProject.setText("");
        NewPresentation.setText("");
        NewSlide.setText("");
        editPresentation.setText("");
        sharePresentation.setText("");
        rename.setText("");
        delete.setText("");
        undoAction.setText("");
        redoAction.setText("");
        info.setText("");

        //dodavanje na toolbar
        add(NewProject);
        add(NewPresentation);
        add(NewSlide);
        add(editPresentation);
        add(sharePresentation);
        add(rename);
        add(delete);
        add(undoAction);
        add(redoAction);
        add(info);
    }

}
