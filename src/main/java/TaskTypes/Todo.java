package TaskTypes;

/**
 * Represents a Todo task, a type of task that is characterized by a description
 * and a completion status. The Todo task can be marked as done or not done,
 * and it provides functionality to display its details and save it in a specific format.
 * This class extends the {@link Task} class and provides a basic implementation
 * for tasks without additional attributes like dates or time ranges.
 */
public class Todo extends Task {

    /**
     * Constructs a Todo task with the specified description and an initial status of not done.
     *
     * @param description the description of the Todo task
     */
    public Todo(String description) {
        super(description);
        super.setDone(false);
    }

    /**
     * Returns a string representation of the Todo task. The string includes the
     * task's status (done or not done) and its description.
     *
     * @return a string representation of the Todo task in a user-friendly format
     */
    @Override
    public String toString() {
        return "[T]" + String.format("[%s] ", super.getIsDone() ? "X" : " ") + super.getDescription();
    }

    /**
     * Converts the Todo task into a string format that can be saved to storage.
     * The string includes the task type, completion status, and description of the task.
     *
     * @return a string representing the Todo task in a saveable format
     */
    public String toSaveString() {
        return "T | " + (this.getIsDone() ? "1" : "0") + " | " + this.getDescription();
    }
}
