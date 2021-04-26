package by.training.ownfinancial.dao;

import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.dao.exception.DAOException;

import java.util.List;

public interface UserDAO {
    List<User> load() throws DAOException;

    void save(List<User> userList) throws DAOException;

    void addUser(User user) throws DAOException;

    void deleteUser(String login) throws DAOException;

    User signIn(String login, String password) throws DAOException;

    String singOut(User user) throws DAOException;

}
