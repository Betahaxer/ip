package TaskTypes;

/**
 * An abstract class representing a task with a description and a completion status.
 * The task can be marked as done or not done, and it has a description that is saved
 * and retrieved. The task can also be represented as a string for displaying to the user
 * or saving to a storage medium.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected int index;

    /**
     * Constructs a Task with a description and an initial status of not done.
     *
     * @param description the description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done.
     */
    public void markAsNotDone() {
        this.isDone = false;
    }

    /**
     * Retrieves the description of the task.
     *
     * @return the description of the task
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Retrieves the completion status of the task.
     *
     * @return true if the task is done, false otherwise
     */
    public boolean getIsDone() {
        return this.isDone;
    }

    /**
     * Sets the completion status of the task.
     *
     * @param done the new completion status of the task
     */
    public void setDone(boolean done) {
        isDone = done;
    }

    /**
     * Returns a string representation of the task. The task is represented as
     * a checkbox-like format, showing whether the task is done or not along
     * with its description.
     *
     * @return a string representation of the task
     */
    @Override
    public String toString() {
        return String.format("[%s] ", getIsDone() ? "X" : " ") + getDescription();
    }

    /**
     * Converts the task into a string format that can be saved to storage.
     *
     * @return a string representing the task in a savable format
     */
    public abstract String toSaveString();
}
