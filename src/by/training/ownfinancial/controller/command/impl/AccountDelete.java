package by.training.ownfinancial.controller.command.impl;

import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.controller.command.Command;
import by.training.ownfinancial.controller.exception.ControllerException;
import by.training.ownfinancial.service.UserService;
import by.training.ownfinancial.service.exception.ServiceException;
import by.training.ownfinancial.service.factory.ServiceFactory;

public class AccountDelete implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        User user;
        User admin;
        int indexForSearch = 0;
        String loginAdmin = null;
        String passwordAdmin = null;
        String loginUser = null;
        String passwordUser = null;
        String respond = null;

        String[] requests = request.split(" ");

        indexForSearch++;
        loginAdmin = requests[indexForSearch];
        indexForSearch++;
        passwordAdmin = requests[indexForSearch];
        indexForSearch++;
        loginUser = requests[indexForSearch];


        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userSerivce = serviceFactory.getUserSerivceImpl();

        try {
            admin = userSerivce.signIn(loginAdmin, passwordAdmin);
            respond = "User : " + loginUser + " deleted";
            userSerivce.deleteAccount(admin, loginUser);
        } catch (ServiceException e) {
            respond = "Wrong login or password or you can't delete this account";
        }
        return respond;
    }
}
