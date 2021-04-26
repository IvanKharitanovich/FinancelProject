package by.training.ownfinancial.controller;

import by.training.ownfinancial.controller.command.Command;
import by.training.ownfinancial.controller.exception.ControllerException;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    private final String paramDelimiter = " ";

    public String executeTask(String request) throws ControllerException {
        String response;
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(" "));
        executionCommand = provider.getComman(commandName);

        response = executionCommand.execute(request);

        return response;

    }
}
