public class Deadline extends Todo {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        super.setDone(false);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + String.format("[%s] ", this.isDone ? "X" : " ") + this.description + " (by: " + this.by + ")";
    }
}
