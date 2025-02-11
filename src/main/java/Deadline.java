public class Deadline extends Todo {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        super.setDone(false);
        this.by = by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + String.format("[%s] ", super.getIsDone() ? "X" : " ") + super.getDescription() + " (by: " + getBy() + ")";
    }
}
