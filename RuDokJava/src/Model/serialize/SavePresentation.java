package Model.serialize;

import Model.serialize.filter.PresentationFileFilter;
import Model.treeModel.Presentation;
import Model.treeModel.RuNode;
import View.MainView;

import javax.swing.*;
import java.io.*;

public class SavePresentation implements Save{
    Presentation presentation;

    public SavePresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public void save()
    {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new PresentationFileFilter());

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
}
