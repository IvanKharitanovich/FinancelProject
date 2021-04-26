package by.training.ownfinancial.controller.command.impl;

import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.controller.command.Command;
import by.training.ownfinancial.controller.exception.ControllerException;
import by.training.ownfinancial.service.FinancialService;
import by.training.ownfinancial.service.UserService;
import by.training.ownfinancial.service.exception.ServiceException;
import by.training.ownfinancial.service.factory.ServiceFactory;

public class FundsAdd implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        User user;
        int indexForSearch = 0;
        String login = null;
        String password = null;
        String respond = null;
        double amount = 0;

        String[] requests = request.split(" ");

        indexForSearch++;
        login = requests[indexForSearch];
        indexForSearch++;
        password = requests[indexForSearch];
        indexForSearch++;
        amount = Double.parseDouble(requests[indexForSearch]);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userSerivce = serviceFactory.getUserSerivceImpl();
        FinancialService financialService = serviceFactory.getFinancialServiceImpl();

        try {
            user = userSerivce.signIn(login, password);
            financialService.addMoney(user, amount);
            respond = "Successfully added: " + amount + " to account: " + user.getLogin();
        } catch (ServiceException e) {
            respond = "Wrong value or wrong login and password";
        }

        return respond;
    }
}
