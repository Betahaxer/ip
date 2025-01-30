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
    private static final String TAB = "    ";
    private static final String COMMAND = "> ";
    private static String[] list = new String[100];
    private static int taskCount = 0;

    public static void greet() {
        String greet = TAB + WHITE + "Hello! I'm Bond, a dog that can predict the future.\n" + TAB + "What can I do for you?\n" + GREEN + COMMAND;
        System.out.print(greet);
    }

    public static void sayBye() {
        String bye = TAB + WHITE + "Woof. Hope to see you again soon!";
        System.out.println(bye);
    }

    public static void addToList (String task) {
        list[taskCount] = task;
        taskCount += 1;
        System.out.println(TAB + WHITE + "added: " + task);
        System.out.print(GREEN + COMMAND);
    }

    public static void showList () {
        for (int i = 0; list[i] != null; i++) {
            System.out.printf(TAB + WHITE + "%d" + ". " + list[i] + "\n", i + 1);
        }
        System.out.print(GREEN + COMMAND);
    }

    public static void main(String[] args) {
        greet();
        Scanner in = new Scanner(System.in);
        String instruction;
        while (!(instruction = in.nextLine()).equals("bye")) {
            if (instruction.equals("list")) {
                showList();
            }
            else {
                addToList(instruction);
            }
        }
        sayBye();
    }
}
