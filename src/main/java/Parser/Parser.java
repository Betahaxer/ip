package Parser;

import static Constants.Commands.DEADLINE;
import static Constants.Commands.DELETE;
import static Constants.Commands.EVENT;
import static Constants.Commands.FIND;
import static Constants.Commands.LIST;
import static Constants.Commands.MARK;
import static Constants.Commands.TODO;
import static Constants.Commands.UNMARK;

import Commands.Command;
import Commands.CommandDeadline;
import Commands.CommandDelete;
import Commands.CommandEvent;
import Commands.CommandFind;
import Commands.CommandList;
import Commands.CommandMark;
import Commands.CommandTodo;
import Exceptions.IllegalArgumentException;

/**
 * The Parser class is responsible for parsing user input and converting it
 * into the corresponding {@link Command} objects. It processes the input to
 * identify the command and its arguments, then returns the appropriate command
 * object that can be executed. The class supports multiple commands such as
 * "LIST", "MARK", "UNMARK", "TODO", "DEADLINE", "EVENT", "DELETE" and "FIND".
 * <p>
 * The class utilizes a switch statement to handle each command and returns
 * the corresponding Command object. If an invalid command is encountered,
 * an {@link IllegalArgumentException} is thrown.
 */
public class Parser {

    /**
     * Parses the user input and returns the corresponding {@link Command} object.
     * The input is split into a command and its arguments, which are used to
     * instantiate the appropriate Command object.
     *
     * @param input the user input string
     * @return a Command object representing the parsed command
     * @throws IllegalArgumentException if the command is unrecognized or the arguments are invalid
     */
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
            case FIND -> new CommandFind(arguments);
            default -> throw new IllegalArgumentException();
        };
    }
}
