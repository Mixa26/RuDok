package View;

import Controller.ActionManager;
import Model.treeModel.WorkSpace;
import View.treeSwingGUI.model.MyTreeModel;
import View.treeSwingGUI.model.MyTreeNode;
import View.treeSwingGUI.view.MyTree;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private static MainView instance;

    private ActionManager actionManager;

    //komponente prozora
    private MyMenuBar myMenuBar;
    private MyToolBar myToolBar;
    private MyTree myTree;
    private MyTreeModel myTreeModel;

    private JSplitPane splitPane;
    private JScrollPane stablo;
    private JPanel radnaPovrsina;

    private MainView()
    {
    }

    private void initialise()
    {
        actionManager = new ActionManager();
    }

    private void initialiseTree()
    {
        myTree = new MyTree();
        myTreeModel = new MyTreeModel();

        myTree.setModel(myTreeModel);
    }

    private void initialiseGUI()
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

        stablo = new JScrollPane(myTree);
        stablo.setMinimumSize(new Dimension((int)screenSize.getWidth() / 25, 50));
        stablo.setPreferredSize(new Dimension((int)screenSize.getWidth() / 10, 50));
        radnaPovrsina = new JPanel();
        radnaPovrsina.setMinimumSize(new Dimension((int)screenSize.getWidth() / 25, 50));
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, stablo, radnaPovrsina);

        //dodavanje na prozor
        setJMenuBar(myMenuBar);
        add(myToolBar, "North");
        add(splitPane);
    }

    public static MainView getIntance()
    {
        if (instance == null)
        {
            instance = new MainView();
            instance.initialise();
            instance.initialiseTree();
            instance.initialiseGUI();
        }
        return instance;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

}
