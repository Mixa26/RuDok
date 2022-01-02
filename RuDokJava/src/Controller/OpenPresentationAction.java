package Controller;

import Model.serialize.filter.PresentationFileFilter;
import Model.treeModel.Presentation;
import Model.treeModel.Project;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import Model.userErrorHandler.ErrorFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
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
                            presentation.setParent(((Project)((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode()));
                            presentation.setPresentationFile(jfc.getSelectedFile());
                            presentation.setChanged(false);
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
