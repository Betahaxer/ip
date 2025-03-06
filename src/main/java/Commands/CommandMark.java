package Commands;

import static Bond.Bond.markTask;

import java.util.ArrayList;

import TaskTypes.Task;

public class CommandMark extends Command {
    private final String arguments;
    private final boolean isDone;

    public CommandMark(String arguments, boolean mark) {
        this.arguments = arguments;
        this.isDone = mark;
    }

    public void executeCommand(ArrayList<Task> tasks) {
        markTask(arguments, this.isDone, tasks);
    }
}
