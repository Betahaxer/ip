package Bond;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
    private static final String EXIT_APP = "bye";

    private static final int TASK_SIZE = 100;

    public static ArrayList<Task> tasks = new ArrayList<>();

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
        String[] splitInput = input.split(" ");
        String command = splitInput[0];
        try {
            boolean isValidInput = splitInput.length == 2 && !splitInput[1].trim().isEmpty();
            if (!isValidInput) {
                throw new IllegalArgumentException();
            }

            int taskNumber = Integer.parseInt(input.split(" ")[1]);
            int indexOfTask = taskNumber - 1;

            switch (command) {
            case MARK:
                tasks.get(indexOfTask).markAsDone();
                System.out.println(TAB + "Woof! This task was marked as done:");
                System.out.println(TAB + tasks.get(indexOfTask));
                break;
            case UNMARK:
                tasks.get(indexOfTask).markAsNotDone();
                System.out.println(TAB + "Awoof! I've marked this task as undone:");
                System.out.println(TAB + tasks.get(indexOfTask));
                break;
            default:
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException | NumberFormatException e) {
            switch (command) {
            case MARK:
                System.out.println(TAB + "To mark a task: mark {task_number}");
                break;
            case UNMARK:
                System.out.println(TAB + "To unmark a task: mark {task_number}");
                break;
            default:
                System.out.println(TAB + "Invalid command. Please use mark or unmark followed by a task number.");
                break;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(TAB + "Please enter a correct task number");
        } finally {
            System.out.print(COMMAND);
        }
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

    public static void executeCommand(String input) {
        try {
            String command = input.split(" ", 2)[0];
            switch (command) {
            case LIST:
                printList();
                break;
            case MARK:
            case UNMARK:
                markTask(input);
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
            default:
                throw new Exceptions.IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(TAB + "Invalid command! These are the commands possible: todo, deadline, event, mark, unmark, list.");
            System.out.print(COMMAND);
        }
    }

    public static void createFile(String filePath) {
        File taskFile = new File(filePath);
        File parentDirectory = taskFile.getParentFile();

        if (parentDirectory != null && !parentDirectory.exists()) {
            boolean dirsCreated = parentDirectory.mkdirs();
            if (dirsCreated) {
                System.out.println("Directories created: " + parentDirectory.getAbsolutePath());
            } else {
                System.out.println("Failed to create directories!");
            }
        }
        if (!taskFile.exists()) {
            try {
                if (taskFile.createNewFile()) {
                    System.out.println("File created: " + taskFile.getAbsolutePath());
                } else {
                    System.out.println("Failed to create the file!");
                }
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
            }
        }
    }

    public static void parseFile(String filePath) {
        try {
            File taskFile = new File(filePath);
            Scanner s = new Scanner(taskFile);
            while (s.hasNext()) {
                String[] taskArguments = s.nextLine().trim().split(" \\| ");
                processTaskFromFile(taskArguments);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error processing file");
        }
    }

    private static void processTaskFromFile(String[] taskArguments) throws IOException {
        switch (taskArguments[0]) {
        case "T":
            Todo newTodo = new Todo(taskArguments[2]);
            tasks.add(newTodo);
            if (taskArguments[1].equals("1")) {
                newTodo.markAsDone();
            }
            break;
        case "D":
            Deadline newDeadline = new Deadline(taskArguments[2], taskArguments[3]);
            tasks.add(newDeadline);
            if (taskArguments[1].equals("1")) {
                newDeadline.markAsDone();
            }
            break;
        case "E":
            Event newEvent = new Event(taskArguments[2], taskArguments[3], taskArguments[4]);
            tasks.add(newEvent);
            if (taskArguments[1].equals("1")) {
                newEvent.markAsDone();
            }
            break;
        default:
            throw new IOException();
        }
    }

    public static void saveFile(String filePath, ArrayList<Task> tasks) {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (Task t : tasks) {
                fw.write(t.toSaveString() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.err.println("Error writing to file");
        }

    }

    public static void main(String[] args) {
        String filePath = "./data/Tasks.txt";
        createFile(filePath);
        parseFile(filePath);
        greet();

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while (!(input.equals(EXIT_APP))) {
            executeCommand(input);
            input = in.nextLine();
        }

        saveFile(filePath, tasks);
        sayBye();
    }
}
