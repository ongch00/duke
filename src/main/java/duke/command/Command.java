package duke.command;

import duke.task.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Represents a Command.
 * This is an interface meant as a template for the commands.
 */
public interface Command {
    /**
     * Method to execute the command.
     * Must be overridden by implementing classes.
     *
     * @param tasks TaskList object that contains the tasks of the application.
     * @param ui Ui object for the command to interact with the user.
     * @param storage storage object for the retrieval/saving of tasks.
     */
    void execute(TaskList tasks, Ui ui, Storage storage);
}
