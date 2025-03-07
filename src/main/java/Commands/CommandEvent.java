package Commands;

import static TaskTypes.TaskList.addEvent;

public class CommandEvent extends Command {
    private final String arguments;

    public CommandEvent(String arguments) {
        this.arguments = arguments;
    }

    public void executeCommand() {
        addEvent(this.arguments);
    }
}
