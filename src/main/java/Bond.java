import java.util.Scanner;
public class Bond {
    public static void greet() {
        String greet = "Hello! I'm Bond, a dog that can predict the future.\nWhat can I do for you?";
        String line = "-----------------------------------------------------";
        System.out.println(line + "\n" + greet + "\n" + line);
    }

    public static void sayBye() {
        String bye = "Woof. Hope to see you again soon!";
        String line = "-----------------------------------------------------";
        System.out.println(bye + "\n" + line);
    }
    public static void main(String[] args) {
        greet();
        Scanner in = new Scanner(System.in);
        String instruction;
        String line ="-----------------------------------------------------";

        while (!(instruction = in.nextLine()).equals("bye")) {
            System.out.println(line + "\n" + instruction + "\n" + line);
        }
        sayBye();
    }
}
