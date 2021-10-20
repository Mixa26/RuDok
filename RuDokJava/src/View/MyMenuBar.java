package View;

import javax.swing.*;
import javax.swing.JMenuBar;

public class MyMenuBar extends JMenuBar {

    private JMenu fileMenu;
    private JMenu helpMenu;

    //padajuci meni File
    private JMenuItem New;

    //padajuci meni Help
    private JMenuItem Edit;

    public MyMenuBar()
    {
        //init menija
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");

        //init padajuceg menija File
        New = new JMenuItem("New");

        //init padajuceg menija Help
        Edit = new JMenuItem("Edit");

        //dodavanje
            //sadrzaj padajuceg menija File
            fileMenu.add(New);
        add(fileMenu);
            //sadrzaj padajuceg menija Help
            helpMenu.add(Edit);
        add(helpMenu);
    }

}
