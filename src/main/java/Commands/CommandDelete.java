package Commands;

import static Bond.Bond.deleteTask;

import java.util.ArrayList;

import TaskTypes.Task;

public class CommandDelete extends Command {
    private final String arguments;

    public CommandDelete(String arguments) {
        this.arguments = arguments;
    }

    public void executeCommand(ArrayList<Task> tasks) {
        deleteTask(this.arguments);
    }

}
