package Controller;

import Model.serialize.PresentationFileFilter;
import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.RuNode;
import View.MainView;
import View.PresentationView;
import View.treeSwingGUI.model.MyTreeNode;
import View.userErrorHandler.ErrorFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SavePresentationAction extends AbstractRudokAction{
    public SavePresentationAction () {
        putValue(NAME, "Save presentation");
        putValue(SHORT_DESCRIPTION, "Saves the currently open presentation.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainView.getInstance().getMyTree().getSelectionPath() != null) {
            if (((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode() instanceof Presentation) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileFilter(new PresentationFileFilter());

//                Presentation presentation = ((PresentationView) MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getPresentation();
                Presentation presentation = (Presentation) ((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode();
                File presentationFile = presentation.getPresentationFile();

                if (!presentation.isChanged()) {
                    return;
                }

                if (presentation.getPresentationFile() == null) {
                    if (jfc.showSaveDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION) {
                        presentationFile = jfc.getSelectedFile();
                    } else {
                        return;
                    }
                }

                ObjectOutputStream oos;
                try {
                    oos = new ObjectOutputStream(new FileOutputStream(presentationFile));
                    oos.writeObject(presentation);
                    presentation.setPresentationFile(presentationFile);
                    ((RuNode) presentation).setChanged(false);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            else
            {
                MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.NoPresentationSelected);
            }
        }
        else
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.NoPresentationSelected);
        }
    }
}
