package by.training.ownfinancial.controller.exception;

public class ControllerException extends Exception {

    public ControllerException(String message, Throwable ex) {
        super(message, ex);
    }

    public ControllerException(String message) {
        super(message);
    }

}
