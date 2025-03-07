package Commands;

import static TaskTypes.TaskList.addDeadline;

import TaskTypes.TaskList;

/**
 * CommandDeadline is a concrete subclass of the {@link Command} class that represents
 * a command to add a new deadline task to the task list. This command stores the arguments
 * passed to it and, when executed, adds a deadline task using those arguments.
 * <p>
 * The command expects the arguments to be in a specific format that can be parsed and
 * used to create a deadline task.
 */
public class CommandDeadline extends Command {
    private final String arguments;

    /**
     * Constructs a CommandDeadline object with the provided arguments.
     * The arguments should contain the necessary details to create a new deadline task.
     *
     * @param arguments the arguments to create the deadline task
     */
    public CommandDeadline(String arguments) {
        this.arguments = arguments;
    }

    /**
     * Executes the command to add a new deadline task to the task list.
     * This method calls {@link TaskList#addDeadline(String)} with the provided arguments
     * to create and add the deadline task.
     */
    public void executeCommand() {
        addDeadline(arguments);
    }
}
