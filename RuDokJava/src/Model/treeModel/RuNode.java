package Model.treeModel;

import View.MainView;
import observer.IPublisher;
import observer.ISubscriber;
import observer.NotifyType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class RuNode implements IPublisher, Serializable {

    private transient List<ISubscriber> subscribers;

    private String name;
    private RuNode parent;

    private boolean changed;

    public RuNode(String name, RuNode parent)
    {
        changed = true;
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        if (name.endsWith("."))
        {
            return name.substring(0,name.length()-1);
        }
        return name;
    }

    public void setName(String name) {
        setChanged(true);
        this.name = name;
    }

    public RuNode getParent() {
        return parent;
    }

    public void setParent(RuNode parent) {
        changed = true;
        this.parent = parent;
    }

    public void addSubscriber(ISubscriber subscriber) {

        if (subscriber != null) {
            if (subscribers == null)
            {
                subscribers = new ArrayList<ISubscriber>();
            }
            if (!subscribers.contains(subscriber))
            {
                subscribers.add(subscriber);
            }
        }
    }

    public void removeSubscriber(ISubscriber subscriber) {
        if (subscriber != null && subscribers != null && subscribers.contains(subscriber))
        {
            subscribers.remove(subscriber);
        }
    }

    public void notifySubscribers(Object notification, NotifyType type) {
        if (notification != null && subscribers != null && !subscribers.isEmpty())
        {
            Iterator subs = subscribers.iterator();

            while (subs.hasNext())
            {
                ((ISubscriber)subs.next()).update(notification, type);
            }
        }
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        if (changed && getParent() != null)
        {
            getParent().setChanged(true);
        }
        if (!name.endsWith("*"))
        {
            name = name + "*";
        }
        if (changed == false)
        {
            if (name.endsWith("*"))
            {
                name = name.substring(0,name.length()-1);
                if (this instanceof RuNodeComposite)
                {
                    for (RuNode ruNode : ((RuNodeComposite)this).getChildren())
                    {
                        ruNode.setChanged(false);
                    }
                }
            }
        }
        MainView.getInstance().getMyTree().refresh();
        this.changed = changed;
    }
}
