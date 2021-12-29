package View;

import Controller.ActionManager;
import Model.factory.RuNodeFactory;
import View.userErrorHandler.Error;
import View.userErrorHandler.ErrorFactory;
import View.treeSwingGUI.model.MyTreeModel;
import View.treeSwingGUI.view.MyTree;
import command.CommandManager;
import observer.ISubscriber;
import observer.NotifyType;
import state.State;
import state.StateManager;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame implements ISubscriber {
    private static MainView instance;

    private ActionManager actionManager;

    private ErrorFactory errorFactory;

    private CommandManager commandManager;

    //komponente prozora
    private MyMenuBar myMenuBar;
    private MyToolBar myToolBar;
    private MyTree myTree;
    private RightWorkArea rightWorkArea;
    private MyTreeModel myTreeModel;

    private JSplitPane splitPane;
    private JScrollPane treeScrollPanel;

    private JPanel all;

    private SharePresentationView sharePresentationView;

    private MainView()
    {
    }

    private void initialise()
    {
        actionManager = new ActionManager();
        errorFactory = new ErrorFactory();
        commandManager = new CommandManager();
        errorFactory.addSubscriber(this);
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

        sharePresentationView = new SharePresentationView();

        //dodavanje na prozor
        setJMenuBar(myMenuBar);
        all.add(myToolBar, "North");
        all.add(splitPane);
        getContentPane().add(all);
    }

    public static MainView getInstance()
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

    //update za resavanje errora
    @Override
    public void update(Object notification, NotifyType type) {
        if (notification instanceof Error)
        {
            if (type == NotifyType.Error)
            {
                JOptionPane.showMessageDialog(this,((Error)notification).handleError());
            }
        }
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public ErrorFactory getErrorFactory() {
        return errorFactory;
    }

    public CommandManager getCommandManager() {
        return commandManager;
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

    public SharePresentationView getSharePresentationView() {
        return sharePresentationView;
    }
}