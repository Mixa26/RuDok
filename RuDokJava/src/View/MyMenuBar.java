package View;

import Model.Main;

import javax.swing.*;
import javax.swing.JMenuBar;

public class MyMenuBar extends JMenuBar {

    private JMenu fileMenu;
    private JMenu New;
    private JMenu editMenu;
    private JMenu helpMenu;

    public MyMenuBar()
    {
        //init menija
        fileMenu = new JMenu("File");
        New = new JMenu("New");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        //dodavanje
            //sadrzaj padajuceg menija File
            New.add(MainView.getIntance().getActionManager().getNewProjectAction());
            New.add(MainView.getIntance().getActionManager().getNewPrezentationAction());
            New.add(MainView.getIntance().getActionManager().getNewSlideAction());
            fileMenu.add(New);
        add(fileMenu);
            editMenu.add(MainView.getIntance().getActionManager().getEditPresentationAction());
        add(editMenu);
            //sadrzaj padajuceg menija Help
            helpMenu.add(MainView.getIntance().getActionManager().getInfoAction());
        add(helpMenu);
    }

}
