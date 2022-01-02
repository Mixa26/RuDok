package Model.userErrorHandler;

public class NoProjectSelectedError implements Error {
    String message = "No project selected.";

    public NoProjectSelectedError() {
        handleError();
    }

    @Override
    public String handleError() {
        return message;
    }
}
