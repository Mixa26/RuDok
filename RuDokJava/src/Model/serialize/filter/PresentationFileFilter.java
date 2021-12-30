package Model.serialize.filter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PresentationFileFilter extends FileFilter {

    @Override
    public String getDescription() {
        return "RuDok document file (*rdf)";
    }

    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().toLowerCase().endsWith(".rdf"));
    }
}
