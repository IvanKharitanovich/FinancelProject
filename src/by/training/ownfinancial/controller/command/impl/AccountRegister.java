package by.training.ownfinancial.controller.command.impl;

import by.training.ownfinancial.bean.Financial;
import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.controller.command.Command;
import by.training.ownfinancial.controller.exception.ControllerException;
import by.training.ownfinancial.service.FinancialService;
import by.training.ownfinancial.service.UserService;
import by.training.ownfinancial.service.exception.ServiceException;
import by.training.ownfinancial.service.factory.ServiceFactory;

public class AccountRegister implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        User user;
        Financial financial;
        int indexForSearch = 0;
        String login = null;
        String password = null;
        String respond = null;

        String[] requests = request.split(" ");

        indexForSearch++;
        login = requests[indexForSearch];
        indexForSearch++;
        password = requests[indexForSearch];

        financial = new Financial(login);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userSerivce = serviceFactory.getUserSerivceImpl();
        FinancialService financialService = serviceFactory.getFinancialServiceImpl();


        try {
            user = new User(login, password);
            respond = "User : " + user.getLogin() + " added";
            financialService.addFinancial(financial);
            userSerivce.addAccount(user);
        } catch (ServiceException e) {
            respond = "Registration error";
        }

        return respond;
    }
}
