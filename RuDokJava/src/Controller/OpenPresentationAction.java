package Controller;

import Model.Main;
import Model.serialize.PresentationFileFilter;
import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.WorkSpace;
import View.MainView;
import View.PresentationView;
import View.treeSwingGUI.model.MyTreeNode;
import View.userErrorHandler.ErrorFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenPresentationAction extends AbstractRudokAction{
    public OpenPresentationAction() {
        putValue(NAME, "Open presentation");
        putValue(SHORT_DESCRIPTION, "Open a presentation from a directory.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainView.getInstance().getMyTree().getSelectionPath() != null) {
            if (((MyTreeNode) MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode() instanceof Project) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileFilter(new PresentationFileFilter());

                if (jfc.showOpenDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION) {
                    try {
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));

                        Presentation presentation = null;
                        try {
                            presentation = (Presentation) ois.readObject();
                        } catch (ClassNotFoundException e1) {
                            e1.printStackTrace();
                        }

                        //MainView.getInstance().getRightWorkArea().getProject().addChild(presentation);
                        ((Project)((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode()).addChild(presentation);

                        MainView.getInstance().getMyTree().refresh();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            else
            {
                MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.NoProjectSelected);
            }
        }
        else
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.NoProjectSelected);
        }
    }
}
