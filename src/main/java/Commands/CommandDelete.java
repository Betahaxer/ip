package Commands;

import static TaskTypes.TaskList.deleteTask;

import TaskTypes.TaskList;

/**
 * CommandDelete is a concrete subclass of the {@link Command} class that represents
 * a command to delete a task from the task list. This command stores the arguments
 * passed to it and, when executed, deletes the task identified by those arguments.
 * <p>
 * The arguments are typically expected to specify the task identifier or other
 * information necessary to locate and delete the task from the list.
 */
public class CommandDelete extends Command {
    private final String arguments;

    /**
     * Constructs a CommandDelete object with the provided arguments.
     * The arguments should contain the necessary information to identify and delete the task.
     *
     * @param arguments the arguments to identify the task to be deleted
     */
    public CommandDelete(String arguments) {
        this.arguments = arguments;
    }

    /**
     * Executes the command to delete a task from the task list.
     * This method calls {@link TaskList#deleteTask(String)} with the provided arguments
     * to delete the specified task from the list.
     */
    public void executeCommand() {
        deleteTask(this.arguments);
    }
}
