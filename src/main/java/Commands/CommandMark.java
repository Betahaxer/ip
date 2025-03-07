package Commands;

import static TaskTypes.TaskList.markTask;

import TaskTypes.TaskList;

/**
 * CommandMark is a concrete subclass of the {@link Command} class that represents
 * a command to mark a task as either done or not done. When executed, it updates the
 * status of a specific task based on the task number and the desired status (done or not done).
 * <p>
 * This command is typically used when the user wants to change the completion status
 * of a task, either marking it as completed or resetting it to not done.
 */
public class CommandMark extends Command {
    private final String taskNumber;
    private final boolean isDone;

    /**
     * Constructs a CommandMark object with the specified task number and the status
     * to set for the task (either done or not done).
     *
     * @param taskNumber the number identifying the task to be marked
     * @param isDone     the desired status for the task, true for done, false for not done
     */
    public CommandMark(String taskNumber, boolean isDone) {
        this.taskNumber = taskNumber;
        this.isDone = isDone;
    }

    /**
     * Executes the command to mark the task as done or not done.
     * This method calls {@link TaskList#markTask(String, boolean)} to update the task's status.
     */
    public void executeCommand() {
        markTask(this.taskNumber, this.isDone);
    }
}
