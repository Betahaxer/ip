package Parser;

import static Constants.Commands.DEADLINE;
import static Constants.Commands.DELETE;
import static Constants.Commands.EVENT;
import static Constants.Commands.LIST;
import static Constants.Commands.MARK;
import static Constants.Commands.TODO;
import static Constants.Commands.UNMARK;

import Commands.Command;
import Commands.CommandDeadline;
import Commands.CommandDelete;
import Commands.CommandEvent;
import Commands.CommandList;
import Commands.CommandMark;
import Commands.CommandTodo;
import Exceptions.IllegalArgumentException;

public class Parser {
    public static Command parseInput(String input) throws IllegalArgumentException {
        String[] inputList = input.split(" ", 2);
        String command = inputList[0];
        String arguments = inputList.length > 1 ? inputList[1] : "";
        return switch (command) {
            case LIST -> new CommandList();
            case MARK, UNMARK -> new CommandMark(arguments, command.equals(MARK));
            case TODO -> new CommandTodo(arguments);
            case DEADLINE -> new CommandDeadline(arguments);
            case EVENT -> new CommandEvent(arguments);
            case DELETE -> new CommandDelete(arguments);
            default -> throw new IllegalArgumentException();
        };

    }
}
