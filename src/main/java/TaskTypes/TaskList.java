package TaskTypes;

import static Constants.Formatting.TAB;
import static Constants.Messages.DEADLINE_USAGE;
import static Constants.Messages.DELETE_USAGE;
import static Constants.Messages.EVENT_USAGE;
import static Constants.Messages.INVALID_TASK_NUMBER;
import static Constants.Messages.MARK_USAGE;
import static Constants.Messages.TASK_DELETED;
import static Constants.Messages.TASK_MARKED_DONE;
import static Constants.Messages.TASK_MARKED_UNDONE;
import static Constants.Messages.TODO_USAGE;
import static Constants.Messages.UNMARK_USAGE;

import java.util.ArrayList;

import Exceptions.IllegalArgumentException;
import Storage.Storage;
import Exceptions.StorageOperationException;
import UI.Ui;

/**
 * A class representing a task list, where tasks can be added, marked as done or undone,
 * deleted, and retrieved. The tasks are stored in an ArrayList, and the data is loaded
 * from storage at class initialization.
 */
public class TaskList {
    public static ArrayList<Task> tasks;

    static {
        try {
            tasks = Storage.load();
        } catch (StorageOperationException e) {
            Ui.showError("Unable to load data from file!");
        }
    }

    /**
     * Retrieves the array list of tasks.
     *
     * @return the array list of tasks
     */
    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Marks a task as either done or undone based on the specified task number and mark status.
     *
     * @param taskNumber the number of the task to mark
     * @param mark       true to mark the task as done, false to mark it as undone
     */
    public static void markTask(String taskNumber, boolean mark) {
        try {
            if (taskNumber.isEmpty()) {
                throw new IllegalArgumentException();
            }
            int index = Integer.parseInt(taskNumber) - 1;
            if (mark) {
                tasks.get(index).markAsDone();
                Ui.showToUser(TAB + TASK_MARKED_DONE);
                Ui.showToUser(TAB + tasks.get(index));
            } else {
                tasks.get(index).markAsNotDone();
                Ui.showToUser(TAB + TASK_MARKED_UNDONE);
                Ui.showToUser(TAB + tasks.get(index));
            }
        } catch (NumberFormatException | IllegalArgumentException e) {
            if (mark) {
                Ui.showError(TAB + MARK_USAGE);
            } else {
                Ui.showError(TAB + UNMARK_USAGE);
            }
        } catch (IndexOutOfBoundsException e) {
            Ui.showError(TAB + INVALID_TASK_NUMBER);
        }
    }

    /**
     * Adds a Todo task to the task list.
     *
     * @param todo the Todo task object to add
     */
    public static void addTodo(Todo todo) {
        try {
            if (todo.getDescription().isEmpty()) {
                throw new Exceptions.IllegalArgumentException();
            }
            tasks.add(todo);
            Ui.showToUser(TAB + todo);
        } catch (Exceptions.IllegalArgumentException e) {
            Ui.showError(TAB + TODO_USAGE);
        }
    }

    /**
     * Adds a Deadline task to the task list.
     *
     * @param arguments the string containing the deadline description and deadline date, marked by "/by"
     */
    public static void addDeadline(String arguments) {
        try {
            String[] splitInput = arguments.split("/by", 2);
            boolean containsAllArguments = splitInput.length == 2;
            if (!containsAllArguments) {
                throw new Exceptions.IllegalArgumentException();
            }
            String deadlineDescription = splitInput[0].trim();
            String byDescription = splitInput[1].trim();
            if (deadlineDescription.isEmpty() || byDescription.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Deadline deadline = new Deadline(deadlineDescription, byDescription);
            tasks.add(deadline);
            Ui.showToUser(TAB + deadline);
        } catch (Exceptions.IllegalArgumentException e) {
            Ui.showError(TAB + DEADLINE_USAGE);
        }
    }

    /**
     * Adds an Event task to the task list.
     *
     * @param arguments the string containing the event description and time range, marked by "/from" and "to"
     */
    public static void addEvent(String arguments) {
        try {
            boolean containsAllArguments = arguments.contains("/from") && arguments.contains("/to");
            if (!containsAllArguments) {
                throw new Exceptions.IllegalArgumentException();
            }
            Event newEvent = getEvent(arguments);
            tasks.add(newEvent);
            Ui.showToUser(TAB + newEvent);
        } catch (Exceptions.IllegalArgumentException e) {
            Ui.showError(TAB + EVENT_USAGE);
        }
    }

    /**
     * Parses the event arguments and creates an Event object.
     *
     * @param arguments the string containing the event description and time range, marked by "/from" and "to"
     * @return the created Event object
     * @throws IllegalArgumentException if the event arguments are invalid
     */
    private static Event getEvent(String arguments) throws IllegalArgumentException {
        String[] splitByTo = arguments.split("/to", 2);
        String[] splitByFrom = splitByTo[0].split("/from", 2);
        String eventDescription = splitByFrom[0].trim();
        String fromDescription = splitByFrom[1].trim();
        String toDescription = splitByTo[1].trim();
        if (eventDescription.isEmpty() || fromDescription.isEmpty() || toDescription.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return new Event(eventDescription, fromDescription, toDescription);
    }

    /**
     * Deletes a task from the task list by its task number.
     *
     * @param arguments the task number to delete
     */
    public static void deleteTask(String arguments) {
        try {
            tasks.remove(Integer.parseInt(arguments) - 1);
            Ui.showToUser(TAB + String.format(TASK_DELETED, arguments));
        } catch (IllegalArgumentException e) {
            Ui.showError(TAB + DELETE_USAGE);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            Ui.showError(TAB + INVALID_TASK_NUMBER);
        }
    }
}
