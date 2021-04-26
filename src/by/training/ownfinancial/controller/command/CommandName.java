package by.training.ownfinancial.controller.command;

public enum CommandName {
    ACCOUNT_DELETE("ACCOUNT_DELETE"),
    ACCOUNT_REGISTER("ACCOUNT_REGISTER"),
    FUNDS_ADD("FUNDS_ADD"),
    FUNDS_INFO("FUNDS_INFO"),
    FUNDS_TAKE("FUNDS_TAKE"),
    SIGN_IN("SIGN_IN"),
    SIGN_OUT("SIGN_OUT"),
    WRONG_REQUEST("WRONG_REQUEST");

    CommandName(String title) {

    }
}
