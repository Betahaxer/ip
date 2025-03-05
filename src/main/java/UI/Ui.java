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
    private final Scanner in;
    private final PrintStream out;

    public Ui() {
        this(System.in, System.out);
    }

    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public String getUserCommand() {
        return in.nextLine();
    }


    public void greet() {
        out.print(GREETING);
    }

    public void sayBye() {
        out.println(GOODBYE);
    }

    public void printList(ArrayList<Task> tasks) {
        out.println(TAB + LIST_HEADER);
        for (Task t : tasks) {
            out.printf(TAB + WHITE + "%d" + ". ", tasks.indexOf(t) + 1);
            out.println(t);
        }
        System.out.println(TAB + String.format(LIST_FOOTER, tasks.size()));
    }

    public void showError(String message) {
        out.println(message);
    }

    public void showToUser(String message) {
        out.println(message);
    }

    public void showCommandArrow() {
        out.print(COMMAND);
    }

}
