package by.training.ownfinancial.dao;

import by.training.ownfinancial.bean.Financial;
import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.dao.exception.DAOException;

import java.util.List;

public interface FinancialDAO {
    List<Financial> load() throws DAOException;

    void save(List<Financial> financialList) throws DAOException;

    void addFinancial(Financial financial) throws DAOException;

    void addMoney(User user, double amount) throws DAOException;

    void takeMoney(User user, double amount) throws DAOException;

    String getFinancialInfo(User user) throws DAOException;
}

