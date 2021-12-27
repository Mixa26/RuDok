package View.userErrorHandler;

public class NoSlotSelectedError implements Error{
    String message = "No slot selected to edit.";

    public NoSlotSelectedError() {
        handleError();
    }

    @Override
    public String handleError() {
        return message;
    }
}
