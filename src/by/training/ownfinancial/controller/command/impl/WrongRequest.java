package by.training.ownfinancial.controller.command.impl;

import by.training.ownfinancial.controller.command.Command;
import by.training.ownfinancial.controller.exception.ControllerException;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        return "Wrong input, command not found";
    }
}
