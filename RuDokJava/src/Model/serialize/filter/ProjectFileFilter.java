package Model.serialize.filter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ProjectFileFilter extends FileFilter {
    @Override
    public String getDescription() {
        return "RuDok project file (*rpf)";
    }

    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().toLowerCase().endsWith(".rpf"));
    }
}
