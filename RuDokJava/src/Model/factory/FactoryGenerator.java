package Model.factory;

import Model.treeModel.Project;
import Model.treeModel.RuNode;
import Model.treeModel.WorkSpace;

public class FactoryGenerator {
    static CollectionFactory collectionFactory = new CollectionFactory();
    static DocumentFactory documentFactory = new DocumentFactory();
    static SheetFactory sheetFactory = new SheetFactory();

    public static RuNodeFactory returnFactory(RuNode selection)
    {
        if (selection instanceof WorkSpace)
        {
            return collectionFactory;
        }
        else if (selection instanceof Project)
        {
            return documentFactory;
        }
        return sheetFactory;
    }
}
