package Bond;

import static Constants.Commands.DEADLINE;
import static Constants.Commands.DELETE;
import static Constants.Commands.EVENT;
import static Constants.Commands.EXIT_APP;
import static Constants.Commands.LIST;
import static Constants.Commands.MARK;
import static Constants.Commands.TODO;
import static Constants.Commands.UNMARK;
import static Constants.Formatting.COMMAND;
import static Constants.Formatting.TAB;
import static Constants.Formatting.WHITE;
import static Constants.Messages.BOND_ASCII;
import static Constants.Messages.DEADLINE_USAGE;
import static Constants.Messages.DELETE_USAGE;
import static Constants.Messages.EVENT_USAGE;
import static Constants.Messages.GOODBYE;
import static Constants.Messages.GREETING;
import static Constants.Messages.INVALID_COMMAND;
import static Constants.Messages.INVALID_MARK_COMMAND;
import static Constants.Messages.INVALID_TASK_NUMBER;
import static Constants.Messages.LIST_FOOTER;
import static Constants.Messages.LIST_HEADER;
import static Constants.Messages.MARK_USAGE;
import static Constants.Messages.TASK_DELETED;
import static Constants.Messages.TASK_MARKED_DONE;
import static Constants.Messages.TASK_MARKED_UNDONE;
import static Constants.Messages.TODO_USAGE;
import static Constants.Messages.UNMARK_USAGE;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Exceptions.IllegalArgumentException;
import TaskTypes.Deadline;
import TaskTypes.Event;
import TaskTypes.Task;
import TaskTypes.Todo;

public class Bond {

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void greet() {
        System.out.print(GREETING);
    }

    public static void sayBye() {
        System.out.println(GOODBYE);
    }

    public static void printList() {
        System.out.println(TAB + LIST_HEADER);
        for (Task t : tasks) {
            System.out.printf(TAB + WHITE + "%d" + ". ", tasks.indexOf(t) + 1);
            System.out.println(t);
        }
        System.out.println(TAB + String.format(LIST_FOOTER, tasks.size()));
    }

    public static void markTask(String input) {
        String[] splitInput = input.split(" ");
        String command = splitInput[0];
        try {
            boolean isValidInput = splitInput.length == 2 && !splitInput[1].trim().isEmpty();
            if (!isValidInput) {
                throw new IllegalArgumentException();
            }
            findAndMarkTask(input, command);

        } catch (IllegalArgumentException | NumberFormatException e) {
            switch (command) {
            case MARK:
                System.out.println(TAB + MARK_USAGE);
                break;
            case UNMARK:
                System.out.println(TAB + UNMARK_USAGE);
                break;
            default:
                System.out.println(TAB + INVALID_MARK_COMMAND);
                break;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(TAB + INVALID_TASK_NUMBER);
        }
    }

    private static void findAndMarkTask(String input, String command) throws IllegalArgumentException, IndexOutOfBoundsException, NumberFormatException {
        int taskNumber = Integer.parseInt(input.split(" ")[1]);
        int indexOfTask = taskNumber - 1;

        switch (command) {
        case MARK:
            tasks.get(indexOfTask).markAsDone();
            System.out.println(TAB + TASK_MARKED_DONE);
            System.out.println(TAB + tasks.get(indexOfTask));
            break;
        case UNMARK:
            tasks.get(indexOfTask).markAsNotDone();
            System.out.println(TAB + TASK_MARKED_UNDONE);
            System.out.println(TAB + tasks.get(indexOfTask));
            break;
        default:
            throw new IllegalArgumentException();
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
        } catch (Exceptions.IllegalArgumentException e) {
            System.out.println(TAB + TODO_USAGE);
        }
    }

    public static void addDeadline(String input) {
        try {
            Deadline newDeadline = getDeadline(input);
            tasks.add(newDeadline);
            System.out.println(TAB + newDeadline);
        } catch (Exceptions.IllegalArgumentException e) {
            System.out.println(TAB + DEADLINE_USAGE);
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
        } catch (Exceptions.IllegalArgumentException e) {
            System.out.println(TAB + EVENT_USAGE);
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

    public static void deleteTask(String input) {
        try {
            String[] splitInput = input.split(" ", 2);
            boolean isValidInput = splitInput.length == 2 && !splitInput[1].trim().isEmpty();
            if (!isValidInput) {
                throw new IllegalArgumentException();
            }
            tasks.remove(Integer.parseInt(splitInput[1]) - 1);
            System.out.println(TAB + String.format(TASK_DELETED, splitInput[1]));
        } catch (IllegalArgumentException e) {
            System.out.println(TAB + DELETE_USAGE);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(TAB + INVALID_TASK_NUMBER);
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
            case DELETE:
                deleteTask(input);
                break;
            default:
                throw new Exceptions.IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(TAB + INVALID_COMMAND);
        } finally {
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
