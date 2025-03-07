package Commands;

import static Constants.Formatting.TAB;
import static Constants.Messages.TASK_MARKED_DONE;
import static Constants.Messages.TASK_MARKED_UNDONE;
import static TaskTypes.TaskList.markTask;

import java.util.ArrayList;

import TaskTypes.Task;
import TaskTypes.TaskList;
import UI.Ui;

public class CommandMark extends Command {
    private final String taskNumber;
    private final boolean isDone;

    public CommandMark(String taskNumber, boolean isDone) {
        this.taskNumber = taskNumber;
        this.isDone = isDone;
    }

    public void executeCommand() {
        markTask(this.taskNumber, this.isDone);
    }
}
