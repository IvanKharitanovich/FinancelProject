package by.training.ownfinancial.service.impl;

import by.training.ownfinancial.bean.Financial;
import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.dao.FinancialDAO;
import by.training.ownfinancial.dao.UserDAO;
import by.training.ownfinancial.dao.exception.DAOException;
import by.training.ownfinancial.dao.factory.DAOFactory;
import by.training.ownfinancial.dao.validation.ValidationDAO;
import by.training.ownfinancial.service.FinancialService;
import by.training.ownfinancial.service.exception.ServiceException;
import by.training.ownfinancial.service.validation.ServiceValidation;

public class FinancialServiceImpl implements FinancialService {
    @Override
    public void addFinancial(Financial financial) throws ServiceException {
        if (ServiceValidation.checkForNull(financial)) {
            throw new ServiceException("Null financial");
        }
        if (ServiceValidation.amountPositiveCheck(financial.getValue())) {
            throw new ServiceException("Wrong value");
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        FinancialDAO financialDAO = daoFactory.getTxtFinancialImpl();

        try {
            financialDAO.addFinancial(financial);
        } catch (DAOException e) {
            throw new ServiceException("Empty");
        }
    }

    @Override
    public void addMoney(User user, double amount) throws ServiceException {
        if (ServiceValidation.userCheck(user)) {
            throw new ServiceException("User have empty variable");
        }
        if (ServiceValidation.amountPositiveCheck(amount)) {
            throw new ServiceException("Amount less than 0");
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        FinancialDAO financialDAO = daoFactory.getTxtFinancialImpl();

        try {
            financialDAO.addMoney(user, amount);
        } catch (DAOException e) {
            throw new ServiceException("Wrong password or login");
        }

    }

    @Override
    public void takeMoney(User user, double amount) throws ServiceException {
        if (ServiceValidation.userCheck(user)) {
            throw new ServiceException("User have empty variable");
        }
        if (ServiceValidation.amountPositiveCheck(amount)) {
            throw new ServiceException("Amount less than 0");
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        FinancialDAO financialDAO = daoFactory.getTxtFinancialImpl();

        try {
            financialDAO.takeMoney(user, amount);
        } catch (DAOException e) {
            throw new ServiceException("Wrong password or login");
        }
    }

    @Override
    public String getFinancialInfo(User user) throws ServiceException {
        if (ServiceValidation.userCheck(user)) {
            throw new ServiceException("User have empty variable");
        }
        String info = "";

        DAOFactory daoFactory = DAOFactory.getInstance();
        FinancialDAO financialDAO = daoFactory.getTxtFinancialImpl();

        try {
            info = financialDAO.getFinancialInfo(user);
        } catch (DAOException e) {
            throw new ServiceException("Wrong password or login");
        }
        return info;
    }
}
