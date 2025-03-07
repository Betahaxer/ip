package Commands;

import static TaskTypes.TaskList.addDeadline;

import Exceptions.IllegalArgumentException;
import TaskTypes.Deadline;

public class CommandDeadline extends Command {
    private final String arguments;

    public CommandDeadline(String arguments) {
        this.arguments = arguments;
    }

    public void executeCommand() {
        addDeadline(arguments);
    }
}
