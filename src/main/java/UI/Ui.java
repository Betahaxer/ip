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

public class Ui {
    private Scanner in = new Scanner(System.in);

    public String getUserCommand() {
        return in.nextLine();
    }


    public void greet() {
        System.out.print(GREETING);
    }

    public void sayBye() {
        System.out.println(GOODBYE);
    }

    public static void printList(ArrayList<Task> tasks) {
        System.out.println(TAB + LIST_HEADER);
        for (Task t : tasks) {
            System.out.printf(TAB + WHITE + "%d" + ". ", tasks.indexOf(t) + 1);
            System.out.println(t);
        }
        System.out.println(TAB + String.format(LIST_FOOTER, tasks.size()));
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showToUser(String message) {
        System.out.println(message);
    }

    public void showCommandArrow() {
        System.out.print(COMMAND);
    }

}
