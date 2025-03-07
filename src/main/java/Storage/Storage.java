package Storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import Exceptions.StorageOperationException;
import TaskTypes.Deadline;
import TaskTypes.Event;
import TaskTypes.Task;
import TaskTypes.TaskList;
import TaskTypes.Todo;

public class Storage {

    public static final String DEFAULT_FILE_PATH = "./data/Tasks.txt";

    public static ArrayList<Task> load() throws StorageOperationException {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            File taskFile = new File(DEFAULT_FILE_PATH);
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

    private void createDirectoriesIfNeeded(File parentDirectory) {
        if (parentDirectory != null && !parentDirectory.exists()) {
            boolean dirsCreated = parentDirectory.mkdirs();
            if (!dirsCreated) {
                System.err.println("Failed to create directories: " + parentDirectory.getAbsolutePath());
            }
        }
    }

    private void createFileIfNeeded(File taskFile) throws IOException {
        if (!taskFile.exists()) {
            boolean fileCreated = taskFile.createNewFile();
            if (!fileCreated) {
                throw new IOException("Failed to create the file: " + taskFile.getAbsolutePath());
            }
        }
    }

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
