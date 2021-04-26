package by.training.ownfinancial.service;

import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.service.exception.ServiceException;

public interface UserService {
    User signIn(String login, String password) throws ServiceException;

    String signOut(User user) throws ServiceException;

    void addAccount(User user) throws ServiceException;

    void deleteAccount(User admin, String login) throws ServiceException;
}
