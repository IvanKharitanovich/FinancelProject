package by.training.ownfinancial.service;

import by.training.ownfinancial.bean.Financial;
import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.service.exception.ServiceException;

public interface FinancialService {
    void addMoney(User user, double amount) throws ServiceException;

    void takeMoney(User user, double amount) throws ServiceException;

    String getFinancialInfo(User user) throws ServiceException;

    void addFinancial(Financial financial) throws ServiceException;
}
