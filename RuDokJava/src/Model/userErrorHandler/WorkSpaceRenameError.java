package Model.userErrorHandler;

public class WorkSpaceRenameError implements Error{
    String message = "You can't rename the WorkSpace node";

    public WorkSpaceRenameError() {
        handleError();
    }

    @Override
    public String handleError() {
        return message;
    }
}
