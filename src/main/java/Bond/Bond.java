package Bond;

import java.util.Scanner;
import java.util.ArrayList;

import Exceptions.IllegalArgumentException;
import TaskTypes.Deadline;
import TaskTypes.Event;
import TaskTypes.Task;
import TaskTypes.Todo;

public class Bond {
    //colours for text output
    private static final String GREEN = "\u001B[32m";
    private static final String WHITE = "\033[97m";

    //formatting related
    private static final String TAB = WHITE + "    ";
    private static final String COMMAND = GREEN + "> ";

    //for lists
    private static final String UNMARKED = "[ ]";
    private static final String MARKED = "[X]";

    //commands
    private static final String LIST = "list";
    private static final String MARK = "mark";
    private static final String UNMARK = "unmark";
    private static final String TODO = "todo";
    private static final String DEADLINE = "deadline";
    private static final String EVENT = "event";
    private static final String DELETE = "delete";
    private static final String EXIT_APP = "bye";

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void greet() {
        String greet = TAB + WHITE + "Hello! I'm Bond, a dog that can predict the future.\n" + TAB + "What can I do for you?\n" + GREEN + COMMAND;
        System.out.print(greet);
    }

    public static void sayBye() {
        String bye = TAB + WHITE + "Woof. Hope to see you again soon!";
        System.out.println(bye);
    }

    public static void printList() {
        System.out.println(TAB + "Hmph... The future is uncertain, but these tasks must be completed:");
        for (Task t : tasks) {
            System.out.printf(TAB + WHITE + "%d" + ". ", tasks.indexOf(t) + 1);
            System.out.println(t);
        }
        System.out.println(TAB + String.format("Woof %d tasks… I see them all… woof", tasks.size()));
        System.out.print(GREEN + COMMAND);
    }

    public static void markTask(String input) {
        int taskNumber = Integer.parseInt(input.split(" ")[1]);
        tasks.get(taskNumber - 1).markAsDone();
        System.out.println(WHITE + "Woof! This task was marked as done:");
        System.out.println("  " + MARKED + " " + tasks.get(taskNumber - 1).getDescription());
        System.out.print(COMMAND);
    }

    public static void unmarkTask(String input) {
        int taskNumber = Integer.parseInt(input.split(" ")[1]);
        tasks.get(taskNumber - 1).markAsNotDone();
        System.out.println(WHITE + "Awoof! I've marked this task as undone:");
        System.out.println("  " + UNMARKED + " " + tasks.get(taskNumber - 1).getDescription());
        System.out.print(COMMAND);
    }

    public static void addTodo(String input) {
        try {
            String[] splitInput = input.split(" ", 2);
            boolean isValidInput = splitInput.length == 2 && !splitInput[1].trim().isEmpty();
            if (!isValidInput) {
                throw new Exceptions.IllegalArgumentException();
            }
            Todo newTodo = new Todo(input.substring(TODO.length() + 1));
            tasks.add(newTodo);
            System.out.println(TAB + newTodo);
            System.out.print(COMMAND);
        } catch (Exceptions.IllegalArgumentException e) {
            System.out.println(TAB + "To add a todo: todo {todo_description}");
            System.out.print(COMMAND);
        }
    }

    public static void addDeadline(String input) {
        try {
            Deadline newDeadline = getDeadline(input);
            tasks.add(newDeadline);
            System.out.println(TAB + newDeadline);
            System.out.print(COMMAND);
        } catch (Exceptions.IllegalArgumentException e) {
            System.out.println(TAB + "To add a deadline: deadline {deadline_description} /by {date/time}");
            System.out.print(COMMAND);
        }
    }

    private static Deadline getDeadline(String input) throws IllegalArgumentException {
        String[] splitInput = input.split("/by", 2);
        boolean containsAllArguments = splitInput.length == 2;
        if (!containsAllArguments) {
            throw new IllegalArgumentException();
        }

        String deadlineDescription = splitInput[0].substring(DEADLINE.length() + 1).trim();
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
            System.out.println(TAB + newEvent);
            System.out.print(COMMAND);
        } catch (Exceptions.IllegalArgumentException e) {
            System.out.println(TAB + "To add an event: event {event_description} /from {date/time} /to {date/time}");
            System.out.print(COMMAND);
        }
    }

    private static Event getEvent(String input) throws IllegalArgumentException {
        String[] splitInput = input.split("/to", 2);
        String eventDescription = splitInput[0].substring(EVENT.length() + 1, splitInput[0].indexOf("/from")).trim();
        String fromDescription = splitInput[0].substring(splitInput[0].indexOf("/from") + "/from".length()).trim();
        String toDescription = splitInput[1].trim();
        if (eventDescription.isEmpty() || fromDescription.isEmpty() || toDescription.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return new Event(eventDescription, fromDescription, toDescription);
    }

    public static void removeTask(String input) {
        try {
            String[] splitInput = input.split(" ", 2);
            boolean isValidInput = splitInput.length == 2 && !splitInput[1].trim().isEmpty();
            if (!isValidInput) {
                throw new IllegalArgumentException();
            }
            tasks.remove(Integer.parseInt(splitInput[1]) - 1);
            System.out.println(TAB + "Deleted task " + splitInput[1] + " from tasks");
            System.out.print(COMMAND);
        } catch (IllegalArgumentException e) {
            System.out.println("To remove a task: remove {task_number}");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please check the task number again");
        }
    }

    public static void executeCommand(String input) {
        try {
            String command = input.split(" ", 2)[0];
            switch (command) {
            case LIST:
                printList();
                break;
            case MARK:
                markTask(input);
                break;
            case UNMARK:
                unmarkTask(input);
                break;
            case TODO:
                addTodo(input);
                break;
            case DEADLINE:
                addDeadline(input);
                break;
            case EVENT:
                addEvent(input);
                break;
            case DELETE:
                removeTask(input);
                break;
            default:
                throw new Exceptions.IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(TAB + "Invalid command! These are the commands possible: todo, deadline, event, mark, unmark, list.");
            System.out.print(COMMAND);
        }
    }

    public static void main(String[] args) {
        greet();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while (!(input.equals(EXIT_APP))) {
            executeCommand(input);
            input = in.nextLine();
        }
        sayBye();
    }
}
