package by.training.ownfinancial.service.factory;

import by.training.ownfinancial.service.FinancialService;
import by.training.ownfinancial.service.UserService;
import by.training.ownfinancial.service.impl.FinancialServiceImpl;
import by.training.ownfinancial.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final FinancialService financialServiceImpl = new FinancialServiceImpl();
    private final UserService userServiceImpl = new UserServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public FinancialService getFinancialServiceImpl() {
        return financialServiceImpl;
    }

    public UserService getUserSerivceImpl() {
        return userServiceImpl;
    }
}
