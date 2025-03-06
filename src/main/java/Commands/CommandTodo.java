package Commands;

import static Bond.Bond.addTodo;

import java.util.ArrayList;

import TaskTypes.Task;

public class CommandTodo extends Command {
    private final String arguments;

    public CommandTodo(String arguments) {
        this.arguments = arguments;
    }

    public void executeCommand(ArrayList<Task> tasks) {
        addTodo(this.arguments);
    }
}
