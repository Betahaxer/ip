package Commands;

import java.util.ArrayList;

import TaskTypes.Task;

public abstract class Command {
    public abstract void executeCommand(ArrayList<Task> tasks);
}
