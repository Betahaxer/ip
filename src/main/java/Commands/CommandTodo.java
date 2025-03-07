package Commands;

import static TaskTypes.TaskList.addTodo;

import TaskTypes.Todo;

public class CommandTodo extends Command {
    private final Todo todo;

    public CommandTodo(String arguments) {
        this.todo = new Todo(arguments);
    }

    public void executeCommand() {
        addTodo(this.todo);
    }
}
