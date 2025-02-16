package Constants;

import static Constants.Formatting.COMMAND;
import static Constants.Formatting.GREEN;
import static Constants.Formatting.TAB;

public class Messages {
    public static final String GREETING = TAB + "Hello! I'm Bond, a dog that can predict the future.\n" + TAB + "What can I do for you?\n" + GREEN + COMMAND;
    public static final String GOODBYE = TAB + "Woof. Hope to see you again soon!";
    public static final String LIST_HEADER = "Hmph... The future is uncertain, but these tasks must be completed:";
    public static final String LIST_FOOTER = "Woof %d tasks… I see them all… woof";
    public static final String MARK_USAGE = "Grr... Want to mark a task? Try this: mark {task_number}.";
    public static final String UNMARK_USAGE = "Ruff! To unmark a task, just say: unmark {task_number}.";
    public static final String INVALID_MARK_COMMAND = "Hmm? That doesn't seem right... Try using mark or unmark with a task number.";
    public static final String INVALID_TASK_NUMBER = "Woof? That task number doesn't seem right. Try again!";
    public static final String TASK_MARKED_DONE = "Wag wag! This task is done now! Good job, human!";
    public static final String TASK_MARKED_UNDONE = "Awooo... This task isn't done anymore! Try again later?";
    public static final String TODO_USAGE = "To add something important (like walkies?): todo {todo_description}.";
    public static final String DEADLINE_USAGE = "Big mission ahead? Add a deadline like this: deadline {deadline_description} /by {date/time}.";
    public static final String EVENT_USAGE = "Planning something? Tell me like this: event {event_description} /from {date/time} /to {date/time}.";
    public static final String DELETE_USAGE = "Grrr... Removing something? Just say: remove {task_number}.";
    public static final String TASK_DELETED = "Woof! Task %s has been removed. Hope it wasn't a snack!";
    public static final String INVALID_COMMAND = "Uh-oh... That command doesn't smell right! Try one of these: todo, deadline, event, mark, unmark, list, delete.";
    public static final String BOND_ASCII =
            "⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠾⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⣶⣄⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡴⠶⢶⣶⣦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⡠⠒⠁⠀⠀⠀⠀⠹⣷⣾⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⢀⠎⠀⠀⠀⠀⠀⠀⠀⠀⠘⠻⠿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⢠⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⢀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⡸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⢡⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠈⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠁⠀⠘⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡜⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠈⠓⠤⠠⣀⠀⣀⠄⠒⠚⠁⠀⠀⠀⠀⠈⠓⢄⡀⠀⠀⠀⠀⠀⣀⡠⠊⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠐⠒⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣤⣄⡀⠀⠀⠀⣀⣤⣴⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣷⣿⣿⣿⣷⣶⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⠿⠛⠛⠻⢿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠈⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
}
