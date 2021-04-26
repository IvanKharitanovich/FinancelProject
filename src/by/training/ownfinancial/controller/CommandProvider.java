package by.training.ownfinancial.controller;

import by.training.ownfinancial.controller.command.Command;
import by.training.ownfinancial.controller.command.CommandName;
import by.training.ownfinancial.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.ACCOUNT_DELETE, new AccountDelete());
        repository.put(CommandName.ACCOUNT_REGISTER, new AccountRegister());
        repository.put(CommandName.FUNDS_ADD, new FundsAdd());
        repository.put(CommandName.FUNDS_INFO, new FundsInfo());
        repository.put(CommandName.FUNDS_TAKE, new FundsTake());
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.SIGN_OUT, new SignOut());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getComman(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }
}
