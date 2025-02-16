package TaskTypes;

public class Event extends Todo {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "[E]" + String.format("[%s] ", super.getIsDone() ? "X" : " ") + super.getDescription() + " (from: " + this.from + " to: " + this.to + ")";
    }

    @Override
    public String toSaveString() {
        return "E | " + (this.getIsDone() ? "1" : "0") + " | " + this.getDescription() + " | " + this.getFrom() + " | " + this.getTo();
    }

}
