package Storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Exceptions.StorageOperationException;
import TaskTypes.Deadline;
import TaskTypes.Event;
import TaskTypes.Task;
import TaskTypes.TaskList;
import TaskTypes.Todo;

/**
 * The Storage class is responsible for loading and saving task data to and from
 * a file. It provides functionality to read tasks from a file, process them,
 * and save the task data back to a file. The class works with various types of
 * tasks including {@link Todo}, {@link Deadline}, and {@link Event}.
 * <p>
 * The default file path for storing tasks is {@link #DEFAULT_FILE_PATH}.
 */
public class Storage {

    public static final String DEFAULT_FILE_PATH = "./data/Tasks.txt";

    /**
     * Loads tasks from the storage file and returns them as an ArrayList of
     * Task objects. This method reads the task data from the file, processes
     * each line, and creates corresponding task objects (Todo, Deadline, Event).
     *
     * @return an ArrayList of Task objects loaded from the file
     * @throws StorageOperationException if an error occurs during the loading process
     */
    public static ArrayList<Task> load() throws StorageOperationException {
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            File taskDirectory = new File("./data");
            File taskFile = new File(DEFAULT_FILE_PATH);
            createDirectoryAndFile(taskDirectory, taskFile);

            Scanner scanner = new Scanner(taskFile);
            while (scanner.hasNext()) {
                String[] taskArguments = scanner.nextLine().trim().split(" \\| ");
                processTaskFromFile(taskArguments, tasks);
            }
            return tasks;

        } catch (IOException ioe) {
            throw new StorageOperationException("Error loading file: " + DEFAULT_FILE_PATH);
        }
    }

    private static void createDirectoryAndFile(File taskDirectory, File taskFile) throws IOException {
        if (!taskDirectory.exists()) {
            taskDirectory.mkdirs();
        }

        if (!taskFile.exists()) {
            taskFile.createNewFile();
        }
    }


    /**
     * Saves the current list of tasks to the storage file. It retrieves the
     * list of tasks from {@link TaskList#getTasks()} and writes each task's
     * saved string representation to the file.
     *
     * @throws StorageOperationException if an error occurs during the saving process
     */
    public static void save() throws StorageOperationException {
        ArrayList<Task> tasks = TaskList.getTasks();
        try {
            FileWriter fw = new FileWriter(DEFAULT_FILE_PATH);
            for (Task t : tasks) {
                fw.write(t.toSaveString() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            throw new StorageOperationException("Error writing to file: " + DEFAULT_FILE_PATH);
        }
    }

    /**
     * Processes a line of task data from the file and adds the corresponding task
     * object to the list of tasks.
     *
     * @param taskArguments the arguments representing a task, split from a line in the file
     * @param tasks         the list of tasks to add the new task to
     * @throws IOException if an error occurs while processing the task
     */
    private static void processTaskFromFile(String[] taskArguments, ArrayList<Task> tasks) throws IOException {
        switch (taskArguments[0]) {
        case "T":
            Todo newTodo = new Todo(taskArguments[2]);
            tasks.add(newTodo);
            if (taskArguments[1].equals("1")) {
                newTodo.markAsDone();
            }
            break;
        case "D":
            Deadline newDeadline = new Deadline(taskArguments[2], taskArguments[3]);
            tasks.add(newDeadline);
            if (taskArguments[1].equals("1")) {
                newDeadline.markAsDone();
            }
            break;
        case "E":
            Event newEvent = new Event(taskArguments[2], taskArguments[3], taskArguments[4]);
            tasks.add(newEvent);
            if (taskArguments[1].equals("1")) {
                newEvent.markAsDone();
            }
            break;
        default:
            throw new IOException();
        }
    }
}
