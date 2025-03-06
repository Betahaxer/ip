package Commands;

import static Bond.Bond.addEvent;

import java.util.ArrayList;

import TaskTypes.Task;

public class CommandEvent extends Command {
    private final String arguments;

    public CommandEvent(String arguments) {
        this.arguments = arguments;
    }

    public void executeCommand(ArrayList<Task> tasks) {
        addEvent(this.arguments);
    }
}
