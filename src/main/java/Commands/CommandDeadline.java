package Commands;

import static Bond.Bond.addDeadline;

import java.util.ArrayList;

import TaskTypes.Task;

public class CommandDeadline extends Command {
    private final String arguments;

    public CommandDeadline(String arguments) {
        this.arguments = arguments;
    }

    public void executeCommand(ArrayList<Task> task) {
        addDeadline(this.arguments);
    }
}
