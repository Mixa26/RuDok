package View;

import javax.swing.*;

public class MyToolBar extends JToolBar {

    //komponente toolbara
    private JButton New;
    private JButton info;

    public MyToolBar()
    {
        //init komponenti
        New = new JButton("New");
        info = new JButton("Info");

        //dodavanje na toolbar
        add(New);
        add(info);
    }
}
