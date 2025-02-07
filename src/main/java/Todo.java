public class Todo extends Task {

    public Todo(String description) {
        super(description);
        super.setDone(false);
    }

    @Override
    public String toString() {
        return "[T]" + String.format("[%s] ", super.getIsDone() ? "X" : " ") + super.getDescription();
    }

}