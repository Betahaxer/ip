package Bond;

import static Constants.Commands.EVENT;
import static Constants.Commands.EXIT_APP;
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

import Commands.Command;
import Exceptions.IllegalArgumentException;
import Parser.Parser;
import TaskTypes.Deadline;
import TaskTypes.Event;
import TaskTypes.Task;
import TaskTypes.Todo;

import UI.Ui;
import Storage.Storage;

public class Bond {

    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Ui ui;
    private static Storage storage;

    public Bond() {
        ui = new Ui();
        try {
            storage = new Storage();
        } catch (Storage.InvalidStorageFilePathException | Storage.StorageOperationException e) {
            ui.showError("Invalid file path!");
        }
    }

    public static void markTask(String taskNumber, boolean mark, ArrayList<Task> tasks) {
        try {
            int index = Integer.parseInt(taskNumber) - 1;
            findAndMarkTask(index, mark, tasks);

        } catch (IllegalArgumentException | NumberFormatException e) {
            if (mark) {
                ui.showError(TAB + MARK_USAGE);
            } else {
                ui.showError(TAB + UNMARK_USAGE);
            }
        } catch (IndexOutOfBoundsException e) {
            ui.showError(TAB + INVALID_TASK_NUMBER);
        }
    }

    private static void findAndMarkTask(int taskNumber, boolean mark, ArrayList<Task> tasks) throws IllegalArgumentException, IndexOutOfBoundsException, NumberFormatException {
        if (mark) {
            tasks.get(taskNumber).markAsDone();
            ui.showToUser(TAB + TASK_MARKED_DONE);
            ui.showToUser(TAB + tasks.get(taskNumber));
        } else {
            tasks.get(taskNumber).markAsNotDone();
            ui.showToUser(TAB + TASK_MARKED_UNDONE);
            ui.showToUser(TAB + tasks.get(taskNumber));
        }
    }

    public static void addTodo(String arguments) {
        try {
            if (arguments.isEmpty()) {
                throw new Exceptions.IllegalArgumentException();
            }
            Todo newTodo = new Todo(arguments);
            tasks.add(newTodo);
            ui.showToUser(TAB + newTodo);
        } catch (Exceptions.IllegalArgumentException e) {
            ui.showError(TAB + TODO_USAGE);
        }
    }

    public static void addDeadline(String arguments) {
        try {
            Deadline newDeadline = getDeadline(arguments);
            tasks.add(newDeadline);
            ui.showToUser(TAB + newDeadline);
        } catch (Exceptions.IllegalArgumentException e) {
            ui.showError(TAB + DEADLINE_USAGE);
        }
    }

    private static Deadline getDeadline(String input) throws IllegalArgumentException {
        String[] splitInput = input.split("/by", 2);
        boolean containsAllArguments = splitInput.length == 2;
        if (!containsAllArguments) {
            throw new IllegalArgumentException();
        }

        String deadlineDescription = splitInput[0].trim();
        String byDescription = splitInput[1].trim();
        if (deadlineDescription.isEmpty() || byDescription.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return new Deadline(deadlineDescription, byDescription);
    }

    public static void addEvent(String input) {
        try {
            boolean containsAllArguments = input.contains("/from") && input.contains("/to");
            if (!containsAllArguments) {
                throw new Exceptions.IllegalArgumentException();
            }
            Event newEvent = getEvent(input);
            tasks.add(newEvent);
            ui.showToUser(TAB + newEvent);
        } catch (Exceptions.IllegalArgumentException e) {
            ui.showError(TAB + EVENT_USAGE);
        }
    }

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

    public static void deleteTask(String taskNumber) {
        try {
            tasks.remove(Integer.parseInt(taskNumber) - 1);
            ui.showToUser(TAB + String.format(TASK_DELETED, taskNumber));
        } catch (IllegalArgumentException e) {
            ui.showError(TAB + DELETE_USAGE);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            ui.showError(TAB + INVALID_TASK_NUMBER);
        }
    }


    public static void main(String[] args) {
        new Bond();
        try {
            storage.load(tasks);
        } catch (Storage.StorageOperationException e) {
            ui.showError("Error loading file");
        }
        ui.greet();

        String fullInputLine = ui.getUserCommand();

        while (!(fullInputLine.equals(EXIT_APP))) {
            Command c = Parser.parseInput(fullInputLine);
            c.executeCommand(tasks);
            fullInputLine = ui.getUserCommand();
        }

        try {
            storage.save(tasks);
        } catch (Storage.StorageOperationException e) {
            ui.showError("Error saving file");
        }
        ui.sayBye();
    }
}
