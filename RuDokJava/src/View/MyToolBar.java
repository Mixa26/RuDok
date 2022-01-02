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

    private InfoView infoView;
    private RenameInTreeView renameInTreeView;
    private EditPresentationView editPresentationView;

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

        infoView = new InfoView(MainView.getInstance(),"Info", true);
        renameInTreeView = new RenameInTreeView(MainView.getInstance(), "Rename", true);
        editPresentationView = new EditPresentationView(MainView.getInstance(), "Edit presentation", true);;

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

    public InfoView getInfoView() {
        return infoView;
    }

    public RenameInTreeView getRenameInTreeView() {
        return renameInTreeView;
    }

    public EditPresentationView getEditPresentationView() {
        return editPresentationView;
    }
}
