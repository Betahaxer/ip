import java.util.Scanner;

public class Bond {
    private static final String GREEN = "\u001B[32m";
    private static final String WHITE = "\033[97m";
    private static final String TAB = WHITE + "    ";
    private static final String COMMAND = GREEN + "> ";
    private static final String UNMARKED = "[ ]";
    private static final String MARKED = "[X]";

    private static final Task[] taskList = new Task[100];
    private static int taskCount = 0;

    public static void greet() {
        String greet = TAB + WHITE + "Hello! I'm Bond, a dog that can predict the future.\n" + TAB + "What can I do for you?\n" + GREEN + COMMAND;
        System.out.print(greet);
    }

    public static void sayBye() {
        String bye = TAB + WHITE + "Woof. Hope to see you again soon!";
        System.out.println(bye);
    }

    public static void addToList(String taskDescription) {
        taskList[taskCount] = new Task(taskDescription);
        System.out.println(TAB + "added: " + taskList[taskCount].getDescription());
        System.out.print(COMMAND);
        taskCount++;
    }

    public static void printList() {
        System.out.println(TAB + "Hmph... The future is uncertain, but these tasks must be completed:");
        for (int i = 0; taskList[i] != null; i++) {
            System.out.printf(TAB + WHITE + "%d" + ". ", i + 1);
            System.out.println(taskList[i]);
        }
        System.out.println(TAB + String.format("Woof %d tasks… I see them all… woof", taskCount));
        System.out.print(GREEN + COMMAND);
    }

    public static void markTask(String input) {
        int taskNumber = Integer.parseInt(input.split(" ")[1]);
        taskList[taskNumber - 1].markAsDone();
        System.out.println(WHITE + "Woof! This task was marked as done:");
        System.out.println("  " + MARKED + " " + taskList[taskNumber - 1].getDescription());
        System.out.print(COMMAND);
    }

    public static void unmarkTask(String input) {
        int taskNumber = Integer.parseInt(input.split(" ")[1]);
        taskList[taskNumber - 1].markAsNotDone();
        System.out.println(WHITE + "Awoof! I've marked this task as undone:");
        System.out.println("  " + UNMARKED + " " + taskList[taskNumber - 1].getDescription());
        System.out.print(COMMAND);
    }

    public static void addTodo(String input) {
        taskList[taskCount] = new Todo(input.substring(5));
        System.out.println(TAB + taskList[taskCount]);
        System.out.print(COMMAND);
        taskCount++;
    }

    public static void addDeadline(String input) {
        String deadlineDescription = input.substring(8, input.indexOf("/by")).trim();
        String by = input.substring(input.indexOf("/by") + 4).trim();
        taskList[taskCount] = new Deadline(deadlineDescription, by);
        System.out.println(TAB + taskList[taskCount]);
        System.out.print(COMMAND);
        taskCount++;
    }

    public static void addEvent(String input) {
        String eventDescription = input.substring(6, input.indexOf("/from")).trim();
        String from = input.substring(input.indexOf("/from") + 6, input.indexOf("/to")).trim();
        String to = input.substring(input.indexOf("/to") + 4).trim();
        taskList[taskCount] = new Event(eventDescription, from, to);
        System.out.println(TAB + taskList[taskCount]);
        System.out.print(COMMAND);
        taskCount++;
    }

    public static void main(String[] args) {
        greet();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while (!(input.equals("bye"))) {
            String command = input.split(" ")[0];
            switch (command) {
            case "list":
                printList();
                break;
            case "mark":
                markTask(input);
                break;
            case "unmark":
                unmarkTask(input);
                break;
            case "todo":
                addTodo(input);
                break;
            case "deadline":
                addDeadline(input);
                break;
            case "event":
                addEvent(input);
                break;
            default:
                addToList(input);
                break;
            }
            input = in.nextLine();
        }
        sayBye();
    }
}
