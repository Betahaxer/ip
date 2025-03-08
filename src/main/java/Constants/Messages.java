package Constants;

/**
 * This class contains constant message strings used for displaying various outputs in the application.
 * These messages include greetings, task list headers/footers, usage instructions for various commands,
 * and ASCII art for the fictional dog character, Bond.
 * <p>
 * The messages are used throughout the application to provide feedback to the user, such as confirming
 * actions (e.g., marking tasks, deleting tasks), showing error messages (e.g., invalid commands, task numbers),
 * and greeting or saying goodbye to the user.
 */
public class Messages {
    public static final String GREETING = "Hello! I'm Bond, a dog that can predict the future.\n" + "What can I do for you?\n";
    public static final String GOODBYE = "Woof. Hope to see you again soon!";
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
    public static final String INVALID_COMMAND = "Uh-oh... That command doesn't smell right! Try one of these: todo, deadline, event, mark, unmark, list, delete, find.";
    public static final String SEARCH_HEADER = "Woof. These tasks smell like a match for your search:";
    public static final String NO_TASKS_FOUND = "Hmph... No tasks found. Must’ve been a stealthy one.\uD83D\uDD75\uFE0F\u200D♂\uFE0F";
    public static final String FIND_USAGE = "Ears twitch... That format’s all wrong! Try: find {search_term}.\uD83D\uDD0E";
    public static final String BOND_ASCII =
            "⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠾⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⣶⣄⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡴⠶⢶⣶⣦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀\n" +
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
