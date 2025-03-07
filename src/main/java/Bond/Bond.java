package Bond;

import static Constants.Commands.EXIT_APP;
import static Constants.Formatting.TAB;
import static Constants.Messages.INVALID_COMMAND;

import Commands.Command;
import Exceptions.IllegalArgumentException;
import Exceptions.StorageOperationException;
import Parser.Parser;
import Storage.Storage;
import UI.Ui;

public class Bond {

    public static void main(String[] args) {
        Ui.greet();

        String fullInputLine = Ui.getUserCommand();

        while (!(fullInputLine.equals(EXIT_APP))) {
            try {
                Command c = Parser.parseInput(fullInputLine);
                c.executeCommand();
            } catch (IllegalArgumentException e) {
                Ui.showError(TAB + INVALID_COMMAND);
            } finally {
                Ui.showCommandArrow();
                fullInputLine = Ui.getUserCommand();
            }
        }

        try {
            Storage.save();
        } catch (StorageOperationException e) {
            Ui.showError("Error saving file");
        }
        Ui.sayBye();
    }
}
