package View;

import Model.Main;

import javax.swing.*;
import javax.swing.JMenuBar;

public class MyMenuBar extends JMenuBar {

    private JMenu fileMenu;
    private JMenu New;
    private JMenu editMenu;
    private JMenuItem delete;
    private JMenu helpMenu;

    public MyMenuBar()
    {
        //init menija
        fileMenu = new JMenu("File");
        New = new JMenu("New");
        editMenu = new JMenu("Edit");
        delete = new JMenuItem(MainView.getIntance().getActionManager().getDeleteAction());
        delete.setIcon(null);
        helpMenu = new JMenu("Help");

        //dodavanje
            //sadrzaj padajuceg menija File
            New.add(MainView.getIntance().getActionManager().getNewProjectAction());
            New.add(MainView.getIntance().getActionManager().getNewPresentationAction());
            New.add(MainView.getIntance().getActionManager().getNewSlideAction());
            fileMenu.add(New);
        add(fileMenu);
            editMenu.add(MainView.getIntance().getActionManager().getEditPresentationAction());
            editMenu.add(delete);
        add(editMenu);
            //sadrzaj padajuceg menija Help
            helpMenu.add(MainView.getIntance().getActionManager().getInfoAction());
        add(helpMenu);
    }

}
