package Commands;

import static TaskTypes.TaskList.addTodo;

import TaskTypes.TaskList;

/**
 * CommandTodo is a concrete subclass of the {@link Command} class that represents
 * a command to create and add a new "Todo" task to the task list. It encapsulates the
 * creation of a new Todo task with the provided arguments (task description) and,
 * when executed, adds the task to the list of tasks.
 * <p>
 * This command is typically used when the user wants to add a new task that is
 * categorized as a "Todo" to the task list.
 */
public class CommandTodo extends Command {
    private final String arguments;

    /**
     * Constructs a CommandTodo object with the specified arguments to create a new Todo task.
     * The task is initialized with the provided description and marked as not done.
     *
     * @param arguments the description of the new Todo task
     */
    public CommandTodo(String arguments) {
        this.arguments = arguments;
    }

    /**
     * Executes the command to add the new Todo task to the task list.
     * This method calls {@link TaskList#addTodo(String)} to add the task to the list of tasks.
     */
    public void executeCommand() {
        addTodo(this.arguments);
    }
}
