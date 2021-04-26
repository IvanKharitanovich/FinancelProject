package by.training.ownfinancial.controller.command.impl;

import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.controller.command.Command;
import by.training.ownfinancial.controller.exception.ControllerException;
import by.training.ownfinancial.service.UserService;
import by.training.ownfinancial.service.exception.ServiceException;
import by.training.ownfinancial.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        User user;
        int indexForSearch = 0;
        String login = null;
        String password = null;
        String respond = null;

        String[] requests = request.split(" ");

        indexForSearch++;
        login = requests[indexForSearch];
        indexForSearch++;
        password = requests[indexForSearch];

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userSerivce = serviceFactory.getUserSerivceImpl();

        try {
            user = userSerivce.signIn(login, password);
            respond = ("Welcome : " + user.getLogin());
        } catch (ServiceException e) {
            respond = "Wrong login or password";
        }
        return respond;
    }
}
