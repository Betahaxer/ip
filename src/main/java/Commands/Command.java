package Commands;

/**
 * The Command class serves as the base class for all command types in the system.
 * It provides an abstract method {@link #executeCommand()} that must be implemented
 * by subclasses to define the specific behavior when the command is executed.
 * Each command is expected to perform a distinct action based on its type.
 * <p>
 * Subclasses of this class should override the {@link #executeCommand()} method
 * to implement the functionality associated with the command they represent.
 */
public abstract class Command {

    /**
     * Executes the command. The specific implementation of this method is provided
     * by subclasses and defines what happens when the command is triggered.
     */
    public abstract void executeCommand();
}

