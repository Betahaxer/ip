package Commands;

import static TaskTypes.TaskList.findTasks;

public class CommandFind extends Command {
    public String arguments;

    public CommandFind(String arguments) {
        this.arguments = arguments;
    }

    public void executeCommand() {
        findTasks(this.arguments);
    }

}
