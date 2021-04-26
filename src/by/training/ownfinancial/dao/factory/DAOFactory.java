package by.training.ownfinancial.dao.factory;

import by.training.ownfinancial.dao.FinancialDAO;
import by.training.ownfinancial.dao.UserDAO;
import by.training.ownfinancial.dao.impl.TXTFinancialDAO;
import by.training.ownfinancial.dao.impl.TXTUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final FinancialDAO txtFinancialImpl = new TXTFinancialDAO();
    private final UserDAO txtUserImpl = new TXTUserDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public FinancialDAO getTxtFinancialImpl() {
        return txtFinancialImpl;
    }

    public UserDAO getTxtUserImpl() {
        return txtUserImpl;
    }
}
