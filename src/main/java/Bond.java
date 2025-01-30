import java.util.Scanner;
public class Bond {
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String WHITE = "\033[97m";
    public static final String HIGHLIGHT = "\u001B[43m";

    public static void greet() {
        String greet = WHITE + "Hello! I'm Bond, a dog that can predict the future.\nWhat can I do for you?\n" + GREEN + "> ";
        System.out.print(greet);
    }

    public static void sayBye() {
        String bye = WHITE + "Woof. Hope to see you again soon!";
        System.out.println(bye);
    }
    public static void main(String[] args) {
        greet();
        Scanner in = new Scanner(System.in);
        String instruction;
        while (!(instruction = in.nextLine()).equals("bye")) {
            System.out.print(WHITE + BOLD + instruction + RESET + GREEN + "\n> ");
        }
        sayBye();
    }
}
