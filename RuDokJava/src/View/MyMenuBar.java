package View;

import Model.Main;

import javax.swing.*;
import javax.swing.JMenuBar;

public class MyMenuBar extends JMenuBar {

    private JMenu fileMenu;
    private JMenu helpMenu;

    //padajuci meni Help
    private JMenuItem Edit;

    public MyMenuBar()
    {
        //init menija
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");

        //init padajuceg menija Help
        Edit = new JMenuItem("Edit");

        //dodavanje
            //sadrzaj padajuceg menija File
            fileMenu.add(MainView.getIntance().getActionManager().getNewAction());
        add(fileMenu);
            //sadrzaj padajuceg menija Help
            helpMenu.add(Edit);
        add(helpMenu);
    }

}
