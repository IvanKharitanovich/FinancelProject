package by.training.ownfinancial.service.impl;

import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.dao.UserDAO;
import by.training.ownfinancial.dao.exception.DAOException;
import by.training.ownfinancial.dao.factory.DAOFactory;
import by.training.ownfinancial.service.UserService;
import by.training.ownfinancial.service.exception.ServiceException;
import by.training.ownfinancial.service.validation.ServiceValidation;


public class UserServiceImpl implements UserService {

    @Override
    public User signIn(String login, String password) throws ServiceException {
        User signInUser = null;

        if (ServiceValidation.loginAndPasswordValidate(login, password)) {
            throw new ServiceException("Wrong Input");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getTxtUserImpl();
        try {
            signInUser = userDAO.signIn(login, password);
        } catch (DAOException e) {
            throw new ServiceException("Wrong password or login");
        }
        return signInUser;
    }

    @Override
    public String signOut(User user) throws ServiceException {
        if (ServiceValidation.checkForNull(user)) {
            throw new ServiceException("Null in user");
        }

        if (ServiceValidation.userCheck(user)) {
            throw new ServiceException("User have empty variable");
        }
        String respond = null;

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getTxtUserImpl();
        try {
            respond = userDAO.singOut(user);
        } catch (DAOException e) {
            throw new ServiceException("Service Exception");
        }

        return respond;
    }

    @Override
    public void addAccount(User user) throws ServiceException {
        if (ServiceValidation.userCheck(user)) {
            throw new ServiceException("User have empty variable");
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getTxtUserImpl();
        try {
            userDAO.addUser(user);
        } catch (DAOException e) {
            throw new ServiceException("Service Exception");
        }

    }

    @Override
    public void deleteAccount(User admin, String login) throws ServiceException {
        if (ServiceValidation.checkForNull(admin)) {
            throw new ServiceException("Null in user");
        }

        if (ServiceValidation.loginValidate(login)) {
            throw new ServiceException("Empty login");
        }

        if (ServiceValidation.roleValidation(admin)) {
            throw new ServiceException("Function not available");
        }

        if (admin.getLogin().equals(login)) {
            throw new ServiceException("You can't delete admin");
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getTxtUserImpl();
        try {
            userDAO.deleteUser(login);
        } catch (DAOException e) {
            throw new ServiceException("Service Exception");
        }

    }
}
