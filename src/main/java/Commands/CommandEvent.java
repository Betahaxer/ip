package Commands;

import static TaskTypes.TaskList.addEvent;

import TaskTypes.TaskList;

/**
 * CommandEvent is a concrete subclass of the {@link Command} class that represents
 * a command to add an event to the task list. This command stores the arguments passed to it
 * and, when executed, adds a new event to the task list based on those arguments.
 * <p>
 * The arguments typically contain the details necessary to define the event, such as its description,
 * start time, and end time.
 */
public class CommandEvent extends Command {
    private final String arguments;

    /**
     * Constructs a CommandEvent object with the provided arguments.
     * The arguments should contain the necessary details to define the event.
     *
     * @param arguments the arguments to define the event
     */
    public CommandEvent(String arguments) {
        this.arguments = arguments;
    }

    /**
     * Executes the command to add an event to the task list.
     * This method calls {@link TaskList#addEvent(String)} with the provided arguments
     * to create and add a new event to the task list.
     */
    public void executeCommand() {
        addEvent(this.arguments);
    }
}
