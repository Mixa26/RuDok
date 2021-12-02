package View;

import Controller.ActionManager;
import View.userErrorHandler.ErrorFactory;
import View.treeSwingGUI.model.MyTreeModel;
import View.treeSwingGUI.view.MyTree;
import state.State;
import state.StateManager;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private static MainView instance;

    private ActionManager actionManager;
    private StateManager stateManager;

    private ErrorFactory errorFactory;

    //komponente prozora
    private MyMenuBar myMenuBar;
    private MyToolBar myToolBar;
    private MyTree myTree;
    private RightWorkArea rightWorkArea;
    private MyTreeModel myTreeModel;

    private JSplitPane splitPane;
    private JScrollPane treeScrollPanel;

    private JPanel all;

    private MainView()
    {
    }

    private void initialise()
    {
        actionManager = new ActionManager();
        stateManager = new StateManager();
        errorFactory = new ErrorFactory();
    }

    private void initialiseTree()
    {
        myTree = new MyTree();
        myTreeModel = new MyTreeModel();

        myTree.setModel(myTreeModel);
    }

    private void initialiseWindow()
    {
        //podesavanje prozora
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize((int)(screenSize.getWidth() / 2 + screenSize.getWidth() / 10), (int)(screenSize.getHeight() / 2 + screenSize.getWidth() / 10));
        setTitle("RuDok");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        all = new JPanel();
        all.setLayout(new  BorderLayout());
    }

    public void initialiseGUI()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        //inicijalizacija komponenti prozora
        myMenuBar = new MyMenuBar();
        myToolBar = new MyToolBar();

        treeScrollPanel = new JScrollPane(myTree);
        treeScrollPanel.setMinimumSize(new Dimension((int)screenSize.getWidth() / 25, 50));
        treeScrollPanel.setPreferredSize(new Dimension((int)screenSize.getWidth() / 10, 50));
        rightWorkArea = new RightWorkArea();
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPanel, rightWorkArea);

        //dodavanje na prozor
        setJMenuBar(myMenuBar);
        all.add(myToolBar, "North");
        all.add(splitPane);
        getContentPane().add(all);
    }

    public static MainView getIntance()
    {
        if (instance == null)
        {
            instance = new MainView();
            instance.initialise();
            instance.initialiseTree();
            instance.initialiseWindow();
            instance.initialiseGUI();
        }
        return instance;
    }



    public void startEditProjectState()
    {
        stateManager.setEditProjectState();
    }

    public void startSlideShowState()
    {
        stateManager.setSlideShowState();
    }

    public State getSState()
    {
        return stateManager.getCurrentState();
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public ErrorFactory getErrorFactory() {
        return errorFactory;
    }

    public MyTree getMyTree() {
        return myTree;
    }

    public RightWorkArea getRightWorkArea() {
        return rightWorkArea;
    }

    public MyToolBar getMyToolBar() {
        return myToolBar;
    }

    public MyMenuBar getMyMenuBar() {
        return myMenuBar;
    }

    public JPanel getAll() {
        return all;
    }
}