package by.training.ownfinancial.view;

import by.training.ownfinancial.controller.Controller;
import by.training.ownfinancial.controller.exception.ControllerException;
import by.training.ownfinancial.dao.exception.DAOException;

public class Main {

    public static void main(String[] args) throws DAOException, ControllerException {
        Controller controller = new Controller();

        System.out.println(controller.executeTask("Sign_In Anna30 123456"));
        System.out.println(controller.executeTask("Sign_Out Kate27 123456"));
        System.out.println(controller.executeTask("Funds_Info Anna30 123456"));
        System.out.println(controller.executeTask("Funds_Take Anna30 123456 40"));
        System.out.println(controller.executeTask("Funds_Info Anna30 123456"));
        System.out.println(controller.executeTask("Funds_Add Anna30 123456 60"));
        System.out.println(controller.executeTask("Funds_Info Anna30 123456"));
        System.out.println(controller.executeTask("Account_Register Broke2 234456"));
        System.out.println(controller.executeTask("Account_Delete Anna30 123456 Broke2"));


    }
}



