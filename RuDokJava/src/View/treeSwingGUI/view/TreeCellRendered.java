package View.treeSwingGUI.view;

import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.Slide;
import Model.treeModel.WorkSpace;
import View.treeSwingGUI.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class TreeCellRendered extends DefaultTreeCellRenderer {
    public TreeCellRendered()
    {

    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if (value instanceof MyTreeNode)
        {
            value = ((MyTreeNode)value).getNode();
        }

        if (value instanceof WorkSpace)
        {
            Icon icon = null;
            icon = new ImageIcon("RuDokJava/src/View/treeSwingGUI/icons/WorkSpace.png");
            setIcon(icon);
        }
        else if (value instanceof Project)
        {
            Icon icon = null;
            icon = new ImageIcon("RuDokJava/src/View/treeSwingGUI/icons/Project.png");
            setIcon(icon);
        }
        else if (value instanceof Presentation)
        {
            Icon icon = null;
            if (((Presentation)value).getSharedProjects().isEmpty())
            {
                icon = new ImageIcon("RuDokJava/src/View/treeSwingGUI/icons/Presentation.png");
            }
            else
            {
                icon = new ImageIcon("RuDokJava/src/View/treeSwingGUI/icons/PresentationShared.png");
            }
            setIcon(icon);
        }
        else if (value instanceof Slide)
        {
            Icon icon = null;
            icon = new ImageIcon("RuDokJava/src/View/treeSwingGUI/icons/Slide.png");
            setIcon(icon);
        }

        return this;
    }

}
