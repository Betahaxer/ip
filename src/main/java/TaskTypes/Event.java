package TaskTypes;

/**
 * Represents an Event task, a specialized subclass of the {@link Todo} class.
 * The Event task includes a description, a start time ("from"), and an end time ("to").
 * It provides methods to mark the event as completed or not, retrieve its details,
 * and save the event in a specific format.
 */
public class Event extends Todo {
    protected String from;
    protected String to;

    /**
     * Constructs an Event object with the specified description, start time, and end time.
     *
     * @param description the description of the event
     * @param from        the start time of the event
     * @param to          the end time of the event
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Retrieves the start time of the event.
     *
     * @return the start time of the event
     */
    public String getFrom() {
        return from;
    }

    /**
     * Retrieves the end time of the event.
     *
     * @return the end time of the event
     */
    public String getTo() {
        return to;
    }

    /**
     * Returns a string representation of the Event. The string includes
     * the event's completion status, description, and time range (from and to times).
     *
     * @return a string representation of the Event in a user-friendly format
     */
    @Override
    public String toString() {
        return "[E]" + String.format("[%s] ", super.getIsDone() ? "X" : " ") + super.getDescription() + " (from: " + this.from + " to: " + this.to + ")";
    }

    /**
     * Converts the Event task into a string format that can be saved to storage.
     * The string includes the task type, completion status, description,
     * start time, and end time.
     *
     * @return a string representing the Event in a saveable format
     */
    @Override
    public String toSaveString() {
        return "E | " + (this.getIsDone() ? "1" : "0") + " | " + this.getDescription() + " | " + this.getFrom() + " | " + this.getTo();
    }
}
