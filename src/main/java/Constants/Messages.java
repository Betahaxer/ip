package Constants;

import static Constants.Formatting.COMMAND;
import static Constants.Formatting.GREEN;
import static Constants.Formatting.TAB;

public class Messages {
    public static final String GREETING = TAB + "Hello! I'm Bond, a dog that can predict the future.\n" + TAB + "What can I do for you?\n" + GREEN + COMMAND;
    public static final String GOODBYE = TAB + "Woof. Hope to see you again soon!";
    public static final String LIST_HEADER = "Hmph... The future is uncertain, but these tasks must be completed:";
    public static final String LIST_FOOTER = "Woof %d tasks… I see them all… woof";
    public static final String MARK_USAGE = "To mark a task: mark {task_number}";
    public static final String UNMARK_USAGE = "To unmark a task: unmark {task_number}";
    public static final String INVALID_MARK_COMMAND = "Invalid command. Please use mark or unmark followed by a task number.";
    public static final String INVALID_TASK_NUMBER = "Please enter a correct task number";
    public static final String TASK_MARKED_DONE = "Woof! This task was marked as done:";
    public static final String TASK_MARKED_UNDONE = "Awoof! I've marked this task as undone:";
    public static final String TODO_USAGE = "To add a todo: todo {todo_description}";
    public static final String DEADLINE_USAGE = "To add a deadline: deadline {deadline_description} /by {date/time}";
    public static final String EVENT_USAGE = "To add an event: event {event_description} /from {date/time} /to {date/time}";
    public static final String DELETE_USAGE = "To remove a task: remove {task_number}";
    public static final String TASK_DELETED = "Deleted task %s from tasks";
    public static final String INVALID_COMMAND = "Invalid command! These are the commands possible: todo, deadline, event, mark, unmark, list.";
}
