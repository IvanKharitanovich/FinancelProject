package by.training.ownfinancial.view;

public class SimpleInterface {

    public static String showInterface() {
        String sign_In = "Sign_In Login Password\n";
        String sign_Out = "Sign_Out Login Password\n";
        String fundsTake = "Funds_Take Login Password Amount\n";
        String fundsInfo = "Funds_Info Login Password \n";
        String fundsAdd = "Funds_Add Login Password Amount\n";
        String accountRegister = "Account_Register Login Password\n";
        String accountDelete = "Account_Delete Login Password and Login Password for delete\n";
        String menu = sign_In + sign_Out + fundsTake + fundsInfo + fundsAdd + accountRegister + accountDelete;
        return menu;
    }
}
