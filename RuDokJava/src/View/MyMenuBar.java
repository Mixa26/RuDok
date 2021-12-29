package View;

import javax.swing.*;
import javax.swing.JMenuBar;

public class MyMenuBar extends JMenuBar {

    private JMenu fileMenu;
    private JMenu New;
    private JMenu editMenu;
    private JMenuItem redo;
    private JMenuItem undo;
    private JMenuItem editPresentation;
    private JMenuItem rename;
    private JMenuItem delete;
    private JMenu helpMenu;
    private JMenuItem info;

    public MyMenuBar()
    {
        //init menija
        fileMenu = new JMenu("File");
        New = new JMenu("New");
        editMenu = new JMenu("Edit");
        redo = new JMenuItem(MainView.getInstance().getActionManager().getRedoAction());
        redo.setIcon(null);
        undo = new JMenuItem(MainView.getInstance().getActionManager().getUndoAction());
        undo.setIcon(null);
        editPresentation = new JMenuItem(MainView.getInstance().getActionManager().getEditPresentationAction());
        editPresentation.setIcon(null);
        rename = new JMenuItem(MainView.getInstance().getActionManager().getRenameInTreeAction());
        rename.setIcon(null);
        delete = new JMenuItem(MainView.getInstance().getActionManager().getDeleteAction());
        delete.setIcon(null);
        helpMenu = new JMenu("Help");
        info = new JMenuItem(MainView.getInstance().getActionManager().getInfoAction());
        info.setIcon(null);

        //dodavanje
            //sadrzaj padajuceg menija File
            New.add(MainView.getInstance().getActionManager().getNewProjectAction());
            New.add(MainView.getInstance().getActionManager().getNewPresentationAction());
            New.add(MainView.getInstance().getActionManager().getNewSlideAction());
            fileMenu.add(New);
        add(fileMenu);
            editMenu.add(redo);
            editMenu.add(undo);
            editMenu.add(editPresentation);
            editMenu.add(rename);
            editMenu.add(delete);
        add(editMenu);
            //sadrzaj padajuceg menija Help
            helpMenu.add(info);
        add(helpMenu);
    }

}
