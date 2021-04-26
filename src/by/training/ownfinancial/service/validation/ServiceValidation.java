package by.training.ownfinancial.service.validation;

import by.training.ownfinancial.bean.Financial;
import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.bean.UserRole;

public class ServiceValidation {

    public static boolean loginAndPasswordValidate(String login, String password) {
        boolean status = false;
        if (login.isEmpty() || password.isEmpty()) {
            status = true;
        }
        return status;
    }

    public static boolean checkForNull(User user) {
        boolean status = false;
        if (user == null) {
            status = true;
        }
        return status;
    }

    public static boolean checkForNull(Financial financial) {
        boolean status = false;
        if (financial == null) {
            status = true;
        }
        return status;
    }

    public static boolean roleValidation(User user) {
        boolean status = false;
        if (user.getRole() != UserRole.ADMIN) {
            status = true;
        }
        return status;
    }

    public static boolean userCheck(User user) {
        boolean status = false;
        if (user.getLogin().isEmpty() || user.getPassword().isEmpty()) {
            status = true;
        }
        return false;
    }

    public static boolean amountPositiveCheck(double amount) {
        boolean status = false;
        if (amount < 0) {
            status = true;
        }
        return false;
    }

    public static boolean loginValidate(String login) {
        boolean status = false;
        if (login.isEmpty()) {
            status = true;
        }
        return status;
    }

}
