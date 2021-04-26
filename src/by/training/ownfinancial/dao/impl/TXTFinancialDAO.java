package by.training.ownfinancial.dao.impl;

import by.training.ownfinancial.bean.Financial;
import by.training.ownfinancial.bean.User;
import by.training.ownfinancial.dao.FinancialDAO;
import by.training.ownfinancial.dao.exception.DAOException;
import by.training.ownfinancial.dao.validation.ValidationDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TXTFinancialDAO implements FinancialDAO {
    @Override
    public List<Financial> load() throws DAOException {
        Financial financial;
        List<Financial> financialList = new ArrayList<>();
        String filePath = "src/resources/FinancialData.txt";

        File financialData = new File(filePath);

        try {
            Scanner scanner = new Scanner(financialData);
            while (scanner.hasNext()) {
                int indexOfLine = 0;
                financial = new Financial();

                String nextLine = scanner.nextLine();
                String[] data = nextLine.split(":");

                financial.setOwner(data[indexOfLine]);
                indexOfLine++;
                financial.setValue(Double.parseDouble(data[indexOfLine]));

                financialList.add(financial);
            }

        } catch (FileNotFoundException e) {
            throw new DAOException("File Not Found");
        }
        return financialList;
    }

    @Override
    public void save(List<Financial> financialList) throws DAOException {
        String filePath = "src/resources/FinancialData.txt";
        File financialData = new File(filePath);

        try {
            PrintStream printFinancial = new PrintStream(financialData);

            for (Financial financial : financialList) {
                printFinancial.print(financial.getOwner());
                printFinancial.append(":");
                printFinancial.print(financial.getValue());
                printFinancial.print("\n");
            }

        } catch (FileNotFoundException e) {
            throw new DAOException("File Not Found");
        }
    }

    @Override
    public void addFinancial(Financial financial) throws DAOException {
        if (ValidationDAO.checkForNull(financial)) {
            throw new DAOException("Financial is empty");
        }
        List<Financial> financialList = load();
        financialList.add(financial);
        save(financialList);

    }

    @Override
    public void addMoney(User user, double amount) throws DAOException {
        if (ValidationDAO.userCheck(user)) {
            throw new DAOException("User have empty variable");
        }
        if (ValidationDAO.amountPositiveCheck(amount)) {
            throw new DAOException("Amount less than 0");
        }

        List<Financial> financialList = load();
        for (Financial financial : financialList) {
            if (financial.getOwner().equals(user.getLogin())) {
                financial.setValue(financial.getValue() + amount);
            }
        }
        save(financialList);
    }

    @Override
    public void takeMoney(User user, double amount) throws DAOException {
        if (ValidationDAO.userCheck(user)) {
            throw new DAOException("User have empty variable");
        }
        if (ValidationDAO.amountPositiveCheck(amount)) {
            throw new DAOException("Amount less than 0");
        }

        List<Financial> financialList = load();
        for (Financial financial : financialList) {
            if (financial.getOwner().equals(user.getLogin())) {
                if (financial.getValue() < amount) {
                    throw new DAOException("Amount more than user have");
                }
                financial.setValue(financial.getValue() - amount);
            }
        }
        save(financialList);
    }

    @Override
    public String getFinancialInfo(User user) throws DAOException {
        if (ValidationDAO.userCheck(user)) {
            throw new DAOException("User have empty variable");
        }

        String billInfo = "";
        List<Financial> financialList = load();
        for (Financial financial : financialList) {
            if (financial.getOwner().equals(user.getLogin())) {
                billInfo = Double.toString(financial.getValue());
            }
        }
        return billInfo;
    }
}
