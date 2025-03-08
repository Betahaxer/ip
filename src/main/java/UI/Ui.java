package UI;

import static Constants.Formatting.COMMAND;
import static Constants.Formatting.RED;
import static Constants.Formatting.TAB;
import static Constants.Formatting.WHITE;
import static Constants.Messages.GOODBYE;
import static Constants.Messages.GREETING;
import static Constants.Messages.LIST_FOOTER;
import static Constants.Messages.LIST_HEADER;

import java.io.InputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.Scanner;

import TaskTypes.Task;
import TaskTypes.TaskList;

public class Ui {
    private static final Scanner in = new Scanner(System.in);

    public static String getUserCommand() {
        return in.nextLine();
    }


    public static void greet() {
        Ui.showToUser(GREETING);
        Ui.showCommandArrow();
    }

    public static void sayBye() {
        Ui.showToUser(GOODBYE);
    }

    public static void printList() {
        ArrayList<Task> tasks = TaskList.getTasks();
        Ui.showToUser(LIST_HEADER);
        for (Task t : tasks) {
            Ui.showToUser(String.format("%d" + ". ", tasks.indexOf(t) + 1) + t);
        }
        Ui.showToUser(String.format(LIST_FOOTER, tasks.size()));
    }

    public static void showError(String message) {
        System.out.println(TAB + RED + message);
    }

    public static void showToUser(String message) {
        String[] splitMessage = message.split("\n");
        for (String m : splitMessage) {
            System.out.println(TAB + WHITE + m);
        }
    }

    public static void showCommandArrow() {
        System.out.print(COMMAND);
    }

}
