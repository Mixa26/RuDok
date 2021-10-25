package View;

import Model.Main;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame instance;

    //komponente prozora
    private MyMenuBar myMenuBar;
    private MyToolBar myToolBar;

    private JSplitPane splitPane;
    private JScrollPane stablo;
    private JPanel radnaPovrsina;

    private MainFrame()
    {
        //podesavanje prozora
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize((int)screenSize.getWidth() / 2, (int)screenSize.getHeight() / 2);
        setTitle("RuDok");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //inicijalizacija komponenti prozora
        myMenuBar = new MyMenuBar();
        myToolBar = new MyToolBar();

        stablo = new JScrollPane();
        stablo.setMinimumSize(new Dimension((int)screenSize.getWidth() / 25, 50));
        radnaPovrsina = new JPanel();
        radnaPovrsina.setMinimumSize(new Dimension((int)screenSize.getWidth() / 25, 50));
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, stablo, radnaPovrsina);

        //dodavanje na prozor
        setJMenuBar(myMenuBar);
        add(myToolBar, "North");
        add(splitPane);
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
