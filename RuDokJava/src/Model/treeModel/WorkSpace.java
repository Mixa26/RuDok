package Model.treeModel;

import observer.IPublisher;
import observer.ISubscriber;
import observer.NotifyType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkSpace extends RuNodeComposite implements IPublisher {

    private List<ISubscriber> subscribers;

    public WorkSpace(String name)
    {
        super(name, null);
    }

    public WorkSpace()
    {
        super("WorkSpace", null);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Project)
        {
            super.getChildren().add(child);
        }
    }

    @Override
    public void removeChild(RuNode child) {
        if (child instanceof Project)
        {
            super.getChildren().remove(child);
            notifySubscribers(child, NotifyType.DeleteProject);
        }
    }

    @Override
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

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        if (subscriber != null && subscribers != null && subscribers.contains(subscriber))
        {
            subscribers.remove(subscriber);
        }
    }

    @Override
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
}
