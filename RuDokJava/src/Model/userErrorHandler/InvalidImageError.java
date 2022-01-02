package Model.userErrorHandler;

public class InvalidImageError implements Error{
    String message = "Invalid image.";

    public InvalidImageError() {
        handleError();
    }

    @Override
    public String handleError() {
        return message;
    }
}
