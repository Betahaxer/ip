package Commands;

import java.util.ArrayList;

import TaskTypes.Task;
import UI.Ui;

public class CommandList extends Command {
    public void executeCommand(ArrayList<Task> tasks) {
        Ui.printList(tasks);
    }
}
