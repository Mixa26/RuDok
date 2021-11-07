package View;

import Model.Main;

import javax.swing.*;
import javax.swing.JMenuBar;

public class MyMenuBar extends JMenuBar {

    private JMenu fileMenu;
    private JMenu New;
    private JMenu editMenu;
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
        editPresentation = new JMenuItem(MainView.getIntance().getActionManager().getEditPresentationAction());
        editPresentation.setIcon(null);
        rename = new JMenuItem(MainView.getIntance().getActionManager().getRenameInTreeAction());
        rename.setIcon(null);
        delete = new JMenuItem(MainView.getIntance().getActionManager().getDeleteAction());
        delete.setIcon(null);
        helpMenu = new JMenu("Help");
        info = new JMenuItem(MainView.getIntance().getActionManager().getInfoAction());
        info.setIcon(null);

        //dodavanje
            //sadrzaj padajuceg menija File
            New.add(MainView.getIntance().getActionManager().getNewProjectAction());
            New.add(MainView.getIntance().getActionManager().getNewPresentationAction());
            New.add(MainView.getIntance().getActionManager().getNewSlideAction());
            fileMenu.add(New);
        add(fileMenu);
            editMenu.add(editPresentation);
            editMenu.add(rename);
            editMenu.add(delete);
        add(editMenu);
            //sadrzaj padajuceg menija Help
            helpMenu.add(info);
        add(helpMenu);
    }

}
