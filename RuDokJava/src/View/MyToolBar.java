package View;

import Controller.InfoActionListener;

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

        //podesavanje komponenti
        info.addActionListener(new InfoActionListener());

        //dodavanje na toolbar
        add(New);
        add(info);
    }
}
