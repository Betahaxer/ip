package Commands;

import UI.Ui;

/**
 * CommandList is a concrete subclass of the {@link Command} class that represents
 * a command to display the list of tasks. When executed, it triggers the UI to print
 * the current list of tasks, showing the details of each task in a user-friendly format.
 * <p>
 * This command is typically used when the user wants to view all the tasks currently
 * present in the task list.
 */
public class CommandList extends Command {

    /**
     * Executes the command to display the list of tasks.
     * This method calls {@link Ui#printList()} to output the task list to the user.
     */
    public void executeCommand() {
        Ui.printList();
    }
}
