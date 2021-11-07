package View.userErrorHandler;

public class ErrorFactory {

    public enum ErrorType
    {
        AddPresentationError,
        AddSlideError,
        EditPresentationError,
        RenameInTreeError,
        DeleteError,
        NameEmptyError,
        InvalidImageError
    }

    public ErrorFactory() {
    }

    public Error createError(ErrorType errorType)
    {
        if (errorType == ErrorType.AddPresentationError)
        {
            return new AddPresentationError();
        }
        else if(errorType == ErrorType.AddSlideError)
        {
            return new AddSlideError();
        }
        else if(errorType == ErrorType.EditPresentationError)
        {
            return new EditPresentationError();
        }
        else if(errorType == ErrorType.RenameInTreeError)
        {
            return new RenameInTreeError();
        }
        else if (errorType == ErrorType.DeleteError)
        {
            return new DeleteError();
        }
        else if (errorType == ErrorType.NameEmptyError)
        {
            return new NameEmptyError();
        }
        else if (errorType == ErrorType.InvalidImageError)
        {
            return new InvalidImageError();
        }

        return null;
    }
}
