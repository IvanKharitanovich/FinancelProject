package by.training.ownfinancial.dao.impl;

import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.bean.UserRole;
import by.training.ownfinancial.dao.UserDAO;
import by.training.ownfinancial.dao.exception.DAOException;
import by.training.ownfinancial.dao.validation.ValidationDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TXTUserDAO implements UserDAO {

    @Override
    public List<User> load() throws DAOException {
        User user;
        List<User> userList = new ArrayList<>();
        String filePath = "src/resources/UsersData.txt";

        File userData = new File(filePath);

        try {
            Scanner scanner = new Scanner(userData);
            while (scanner.hasNext()) {
                int indexOfLine = 0;
                user = new User();

                String nextLine = scanner.nextLine();
                String[] data = nextLine.split(":");

                user.setLogin(data[indexOfLine]);
                indexOfLine++;
                user.setPassword(data[indexOfLine]);
                indexOfLine++;
                user.setRole(UserRole.valueOf(data[indexOfLine]));

                userList.add(user);
            }

        } catch (FileNotFoundException e) {
            throw new DAOException("File Not Found");
        }
        return userList;
    }

    @Override
    public void save(List<User> userList) throws DAOException {
        String filePath = "src/resources/UsersData.txt";
        File userData = new File(filePath);

        try {
            PrintStream printUser = new PrintStream(userData);

            for (User user : userList) {
                printUser.print(user.getLogin());
                printUser.append(":");
                printUser.print(user.getPassword());
                printUser.append(":");
                printUser.print(user.getRole());
                printUser.print("\n");
            }

        } catch (FileNotFoundException e) {
            throw new DAOException("File Not Found");
        }
    }

    @Override
    public void addUser(User user) throws DAOException {
        if (ValidationDAO.checkForNull(user)) {
            throw new DAOException("Null user");
        }
        if (ValidationDAO.userCheck(user)) {
            throw new DAOException("User have empty variable");
        }

        List<User> userList = load();
        user.setRole(UserRole.USER);
        userList.add(user);
        save(userList);
    }

    @Override
    public void deleteUser(String login) throws DAOException {
        if (ValidationDAO.loginValidate(login)) {
            throw new DAOException("Empty login");
        }

        List<User> userList = load();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getLogin().equals(login)) {
                userList.remove(i);
                break;
            }
        }
        save(userList);
    }

    @Override
    public User signIn(String login, String password) throws DAOException {
        if (ValidationDAO.loginAndPasswordValidate(login, password)) {
            throw new DAOException("Empty login or password graph");
        }

        User signUser = null;
        List<User> userList = load();

        for (User user : userList)
            if ((user.getLogin().equals(login)) && (user.getPassword().equals(password))) {
                signUser = user;
                break;
            }

        if (signUser == null) {
            throw new DAOException("User not found");
        }
        return signUser;
    }

    @Override
    public String singOut(User user) throws DAOException {
        if (ValidationDAO.checkForNull(user)) {
            throw new DAOException("Null user");
        }
        if (ValidationDAO.userCheck(user)) {
            throw new DAOException("User have empty variable");
        }
        String respond = user.getLogin() + " logout";
        return respond;

    }
}
