public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + String.format("[%s] ", this.isDone ? "X" : " ") + this.description;
    }

}