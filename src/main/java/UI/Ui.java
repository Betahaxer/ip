package UI;

import static Constants.Formatting.COMMAND;
import static Constants.Formatting.RED;
import static Constants.Formatting.TAB;
import static Constants.Formatting.WHITE;
import static Constants.Messages.GOODBYE;
import static Constants.Messages.GREETING;
import static Constants.Messages.LIST_FOOTER;
import static Constants.Messages.LIST_HEADER;

import java.util.ArrayList;
import java.util.Scanner;

import TaskTypes.Task;
import TaskTypes.TaskList;

/**
 * The Ui class is responsible for managing all user interface interactions in the application.
 * It provides methods for displaying messages to the user, receiving user input, and printing
 * the list of tasks. It acts as an intermediary between the application's logic and the user,
 * ensuring that the user experience is seamless and interactive.
 * <p>
 * This class handles greetings, farewells, displaying task lists, showing errors, and other
 * user interaction messages. It also provides a method to capture user commands.
 */
public class Ui {
    private static final Scanner in = new Scanner(System.in);

    /**
     * Prompts and returns the user's input from the command line.
     *
     * @return the user's input as a String
     */
    public static String getUserCommand() {
        return in.nextLine();
    }

    /**
     * Prints a greeting message to the user.
     */
    public static void greet() {
        Ui.showToUser(GREETING);
        Ui.showCommandArrow();
    }

    /**
     * Prints a farewell message to the user.
     */
    public static void sayBye() {
        Ui.showToUser(GOODBYE);
    }

    /**
     * Displays the list of tasks to the user in a formatted manner.
     * It shows each task with its index, description, and completion status.
     */
    public static void printList() {
        ArrayList<Task> tasks = TaskList.getTasks();
        Ui.showToUser(LIST_HEADER);
        for (Task t : tasks) {
            Ui.showToUser(String.format("%d" + ". ", tasks.indexOf(t) + 1) + t);
        }
        Ui.showToUser(String.format(LIST_FOOTER, tasks.size()));
    }

    /**
     * Displays an error message to the user.
     *
     * @param message the error message to be displayed
     */
    public static void showError(String message) {
        System.out.println(TAB + RED + message);
    }

    /**
     * Displays a message to the user.
     *
     * @param message the message to be displayed
     */
    public static void showToUser(String message) {
        String[] splitMessage = message.split("\n");
        for (String m : splitMessage) {
            System.out.println(TAB + WHITE + m);
        }
    }

    /**
     * Displays a command prompt arrow to indicate that the program is waiting for user input.
     */
    public static void showCommandArrow() {
        System.out.print(COMMAND);
    }
}
