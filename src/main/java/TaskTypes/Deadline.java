package TaskTypes;

/**
 * Represents a Deadline task, a specialized type of Todo task that includes a description
 * and a deadline date by which the task needs to be completed. The Deadline class extends
 * the {@link Todo} class and provides functionality to mark the task as done or not done,
 * retrieve its details, and save it in a specific format.
 */
public class Deadline extends Todo {
    protected String by;

    /**
     * Constructs a Deadline task with the specified description and deadline date.
     *
     * @param description the description of the Deadline task
     * @param by          the deadline date by which the task must be completed
     */
    public Deadline(String description, String by) {
        super(description);
        super.setDone(false);
        this.by = by;
    }

    /**
     * Retrieves the deadline date by which the task must be completed.
     *
     * @return the deadline date of the task
     */
    public String getBy() {
        return by;
    }

    /**
     * Returns a string representation of the Deadline task. The string includes
     * the task's status (done or not done), its description, and the deadline date.
     *
     * @return a string representation of the Deadline task in a user-friendly format
     */
    @Override
    public String toString() {
        return "[D]" + String.format("[%s] ", super.getIsDone() ? "X" : " ") + super.getDescription() + " (by: " + getBy() + ")";
    }

    /**
     * Converts the Deadline task into a string format that can be saved to storage.
     * The string includes the task type, completion status, description, and deadline date.
     *
     * @return a string representing the Deadline task in a saveable format
     */
    @Override
    public String toSaveString() {
        return "D | " + (this.getIsDone() ? "1" : "0") + " | " + this.getDescription() + " | " + this.getBy();
    }
}
