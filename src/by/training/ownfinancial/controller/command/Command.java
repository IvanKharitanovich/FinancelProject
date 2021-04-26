package by.training.ownfinancial.controller.command;

import by.training.ownfinancial.controller.exception.ControllerException;

public interface Command {
    public String execute(String request) throws ControllerException;
}
