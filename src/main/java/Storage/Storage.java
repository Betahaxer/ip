package Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import TaskTypes.Deadline;
import TaskTypes.Event;
import TaskTypes.Task;
import TaskTypes.Todo;

public class Storage {
    private final String path;

    public static final String DEFAULT_FILE_PATH = "./data_test/Tasks.txt";

    public Storage() throws InvalidStorageFilePathException, StorageOperationException {
        this(DEFAULT_FILE_PATH);
    }

    public Storage(String filePath) throws InvalidStorageFilePathException, StorageOperationException {
        Path path = Paths.get(filePath);
        if (!isValidPath(path)) {
            throw new InvalidStorageFilePathException("Storage file should end with '.txt'");
        }
        this.path = filePath;
        try {
            File taskFile = new File(this.path);
            File parentDirectory = taskFile.getParentFile();
            createDirectoriesIfNeeded(parentDirectory);
            createFileIfNeeded(taskFile);
        } catch (IOException ioe) {
            throw new StorageOperationException("Error loading file: " + path);
        }
    }

    private static boolean isValidPath(Path filePath) {
        return filePath.toString().endsWith(".txt");
    }

    public static class InvalidStorageFilePathException extends Exception {
        public InvalidStorageFilePathException(String message) {
            super(message);
        }
    }

    public static class StorageOperationException extends Exception {
        public StorageOperationException(String message) {
            super(message);
        }
    }

    public void load(ArrayList<Task> tasks) throws StorageOperationException {
        File taskFile = new File(path);

        try {
            Scanner scanner = new Scanner(taskFile);
            while (scanner.hasNext()) {
                String[] taskArguments = scanner.nextLine().trim().split(" \\| ");
                processTaskFromFile(taskArguments, tasks);
            }
        } catch (IOException ioe) {
            throw new StorageOperationException("Error loading file: " + path);
        }
    }

    public void save(ArrayList<Task> tasks) throws StorageOperationException {
        try {
            FileWriter fw = new FileWriter(path);
            for (Task t : tasks) {
                fw.write(t.toSaveString() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            throw new StorageOperationException("Error writing to file: " + path);
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

    private void processTaskFromFile(String[] taskArguments, ArrayList<Task> tasks) throws IOException {
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
