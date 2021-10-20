package View;

import Model.Main;

import javax.swing.*;

public class MainFrame extends JFrame {
    private static MainFrame instance;

    private MainFrame()
    {
        setSize(1000, 700);
        setTitle("RuDok");
    }

    public static MainFrame getIntance()
    {
        if (instance == null)
        {
            instance = new MainFrame();
        }
        return instance;
    }

}
