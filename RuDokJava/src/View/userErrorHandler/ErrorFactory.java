package View.userErrorHandler;

import observer.IPublisher;
import observer.ISubscriber;
import observer.NotifyType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ErrorFactory implements IPublisher {

    private List<ISubscriber> subscribers;

    public enum ErrorType
    {
        AddPresentationError,
        AddSlideError,
        EditPresentationError,
        RenameInTreeError,
        DeleteError,
        NameEmptyError,
        InvalidImageError,
        SwitchToSlideShowError,
        NoPresentationSlideShowError,
        WorkSpaceRename,
        EditSlotError,
        NoPresentationSelected,
        NoProjectSelected
    }

    public ErrorFactory() {
    }

    public void createError(ErrorType errorType)
    {
        Error error = null;
        if (errorType == ErrorType.AddPresentationError)
        {
            error = new AddPresentationError();
        }
        else if(errorType == ErrorType.AddSlideError)
        {
            error = new AddSlideError();
        }
        else if(errorType == ErrorType.EditPresentationError)
        {
            error = new EditPresentationError();
        }
        else if(errorType == ErrorType.RenameInTreeError)
        {
            error = new RenameInTreeError();
        }
        else if (errorType == ErrorType.DeleteError)
        {
            error = new DeleteError();
        }
        else if (errorType == ErrorType.NameEmptyError)
        {
            error = new NameEmptyError();
        }
        else if (errorType == ErrorType.InvalidImageError)
        {
            error = new InvalidImageError();
        }
        else if (errorType == ErrorType.SwitchToSlideShowError)
        {
            error = new SwitchToSlideShowError();
        }
        else if (errorType == ErrorType.NoPresentationSlideShowError)
        {
            error = new NoPresentationSlideShowError();
        }
        else if (errorType == ErrorType.WorkSpaceRename)
        {
            error = new WorkSpaceRenameError();
        }
        else if (errorType == ErrorType.EditSlotError)
        {
            error = new NoSlotSelectedError();
        }
        else if (errorType == ErrorType.NoPresentationSelected)
        {
            error = new NoPresentationSelectedError();
        }
        else if (errorType == ErrorType.NoProjectSelected)
        {
            error = new NoProjectSelectedError();
        }

        notifySubscribers(error, NotifyType.Error);
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
}
