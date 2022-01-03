package Model.userErrorHandler;

import Model.observer.IPublisher;
import Model.observer.ISubscriber;
import Model.observer.NotifyType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ErrorFactory implements IPublisher {

    private List<ISubscriber> subscribers;

    AddPresentationError addPresentationError;
    AddSlideError addSlideError;
    EditPresentationError editPresentationError;
    RenameInTreeError renameInTreeError;
    DeleteError deleteError;
    NameEmptyError nameEmptyError;
    InvalidImageError invalidImageError;
    WorkSpaceRenameError workSpaceRenameError;
    NoSlotSelectedError noSlotSelectedError;
    NoPresentationSelectedError noPresentationSelectedError;
    NoProjectSelectedError noProjectSelectedError;

    public enum ErrorType
    {
        AddPresentationError,
        AddSlideError,
        EditPresentationError,
        RenameInTreeError,
        DeleteError,
        NameEmptyError,
        InvalidImageError,
        WorkSpaceRename,
        EditSlotError,
        NoPresentationSelected,
        NoProjectSelected
    }

    public ErrorFactory() {
        addPresentationError = new AddPresentationError();
        addSlideError = new AddSlideError();
        editPresentationError = new EditPresentationError();
        renameInTreeError = new RenameInTreeError();
        deleteError = new DeleteError();
        nameEmptyError = new NameEmptyError();
        invalidImageError = new InvalidImageError();
        workSpaceRenameError = new WorkSpaceRenameError();
        noSlotSelectedError = new NoSlotSelectedError();
        noPresentationSelectedError = new NoPresentationSelectedError();
        noProjectSelectedError = new NoProjectSelectedError();
    }

    public void createError(ErrorType errorType)
    {
        Error error = null;
        if (errorType == ErrorType.AddPresentationError)
        {
            error = addPresentationError;
        }
        else if(errorType == ErrorType.AddSlideError)
        {
            error = addSlideError;
        }
        else if(errorType == ErrorType.EditPresentationError)
        {
            error = editPresentationError;
        }
        else if(errorType == ErrorType.RenameInTreeError)
        {
            error = renameInTreeError;
        }
        else if (errorType == ErrorType.DeleteError)
        {
            error = deleteError;
        }
        else if (errorType == ErrorType.NameEmptyError)
        {
            error = nameEmptyError;
        }
        else if (errorType == ErrorType.InvalidImageError)
        {
            error = invalidImageError;
        }
        else if (errorType == ErrorType.WorkSpaceRename)
        {
            error = workSpaceRenameError;
        }
        else if (errorType == ErrorType.EditSlotError)
        {
            error = noSlotSelectedError;
        }
        else if (errorType == ErrorType.NoPresentationSelected)
        {
            error = noPresentationSelectedError;
        }
        else if (errorType == ErrorType.NoProjectSelected)
        {
            error = noProjectSelectedError;
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
