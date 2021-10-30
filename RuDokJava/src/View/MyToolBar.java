package View;

import javax.swing.*;

public class MyToolBar extends JToolBar {

    //komponente toolbara
    private JButton New;
    private JButton info;

    public MyToolBar()
    {
        //init komponenti
        New = new JButton(MainView.getIntance().getActionManager().getNewAction());
        info = new JButton(MainView.getIntance().getActionManager().getInfoAction());

        //dodavanje na toolbar
        add(New);
        add(info);
    }
}
