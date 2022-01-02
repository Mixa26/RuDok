package Model.userErrorHandler;

public class RenameInTreeError implements Error{
    String message = "Please select a component to rename.";

    public RenameInTreeError() {
        handleError();
    }

    @Override
    public String handleError() {
        return message;
    }
}
