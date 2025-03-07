package UI;

import static Constants.Formatting.COMMAND;
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
        System.out.print(GREETING);
    }

    public static void sayBye() {
        System.out.println(GOODBYE);
    }

    public static void printList() {
        ArrayList<Task> tasks = TaskList.getTasks();
        System.out.println(TAB + LIST_HEADER);
        for (Task t : tasks) {
            System.out.printf(TAB + WHITE + "%d" + ". ", tasks.indexOf(t) + 1);
            System.out.println(t);
        }
        System.out.println(TAB + String.format(LIST_FOOTER, tasks.size()));
    }

    public static void showError(String message) {
        System.out.println(message);
    }

    public static void showToUser(String message) {
        System.out.println(message);
    }

    public static void showCommandArrow() {
        System.out.print(COMMAND);
    }

}
