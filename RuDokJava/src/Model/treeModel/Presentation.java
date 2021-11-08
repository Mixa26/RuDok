package Model.treeModel;


import View.PresentationView;
import observer.IPublisher;
import observer.ISubscriber;
import observer.NotifyType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Presentation extends RuNodeComposite implements IPublisher {
    private List<ISubscriber> subscribers;

    private String author;
    private String backgroundImage;

    public Presentation(String name, Project parent)
    {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Slide)
        {
            super.getChildren().add(child);
            notifySubscribers(this, NotifyType.AddSlide);
        }
    }

    @Override
    public void removeChild(RuNode child)
    {
        if (child instanceof Slide)
        {
            super.getChildren().remove(child);
            notifySubscribers(child, NotifyType.RemoveSlide);
        }
    }

    public void setAuthor(String author) {
        this.author = author;
        notifySubscribers(this, NotifyType.EditPresentation);
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getAuthor() {
        return author;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        notifySubscribers(this, NotifyType.RenamePresentation);
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
