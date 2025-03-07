package Commands;

import static TaskTypes.TaskList.deleteTask;

public class CommandDelete extends Command {
    private final String arguments;

    public CommandDelete(String arguments) {
        this.arguments = arguments;
    }

    public void executeCommand() {
        deleteTask(this.arguments);
    }

}
