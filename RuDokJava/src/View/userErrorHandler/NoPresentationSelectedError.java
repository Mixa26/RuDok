package View.userErrorHandler;

public class NoPresentationSelectedError implements Error{
    String message = "No presentation selected.";

    public NoPresentationSelectedError() {
        handleError();
    }

    @Override
    public String handleError() {
        return message;
    }

}
