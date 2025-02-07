import java.util.Scanner;

public class Bond {
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String ITALIC = "\u001B[3m";
    private static final String UNDERLINE = "\u001B[4m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String WHITE = "\033[97m";
    private static final String HIGHLIGHT = "\u001B[43m";
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
        taskCount += 1;
        System.out.println(TAB + WHITE + "added: " + taskDescription);
        System.out.print(GREEN + COMMAND);
    }

    public static void showList() {
        System.out.println(TAB + "Hmph... The future is uncertain, but these tasks must be completed:");
        for (int i = 0; taskList[i] != null; i++) {
            System.out.printf(TAB + WHITE + "%d" + ". ", i + 1);
            if (taskList[i].getIsDone()) {
                System.out.print(MARKED);
            } else {
                System.out.print(UNMARKED);
            }
            System.out.print(" " + taskList[i].getDescription() + "\n");
        }
        System.out.print(GREEN + COMMAND);
    }

    public static void markTask(int itemNumber) {
        taskList[itemNumber - 1].markAsDone();
        System.out.println(WHITE + "Woof! This task was marked as done:");
        System.out.println("  " + MARKED + " " + taskList[itemNumber - 1].getDescription());
        System.out.print(COMMAND);
    }

    public static void unmarkTask(int itemNumber) {
        taskList[itemNumber - 1].markAsNotDone();
        System.out.println(WHITE + "Awoof! I've marked this task as undone:");
        System.out.println("  " + UNMARKED + " " + taskList[itemNumber - 1].getDescription());
        System.out.print(COMMAND);
    }

    public static void main(String[] args) {
        greet();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while (!(input.equals("bye"))) {
            String command = input.split(" ")[0];
            switch (command) {
            case "list":
                showList();
                break;
            case "mark":
                markTask(Integer.parseInt(input.split(" ")[1]));
                break;
            case "unmark":
                unmarkTask(Integer.parseInt(input.split(" ")[1]));
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
