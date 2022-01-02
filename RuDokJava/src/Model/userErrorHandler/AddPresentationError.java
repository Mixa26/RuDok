package Model.userErrorHandler;

public class AddPresentationError implements Error{
    String message = "Please select a project to add a presentation to.";

    public AddPresentationError() {
        handleError();
    }

    @Override
    public String handleError() {
        return message;
    }
}
