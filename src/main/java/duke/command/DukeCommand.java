package duke.command;

import duke.exception.InvalidCommandException;

/**
 * Enum for all the commands duke has.
 */
public enum DukeCommand {
    BYE, LIST, DONE, DELETE, TODO, DEADLINE, EVENT, FIND, HELP, REMINDER;

    /**
     * Translate a string to the respective Enum value.
     *
     * @param command the command to be translated.
     * @return the Enum corresponding to the command if it is valid.
     * @throws InvalidCommandException if command given is not a valid command.
     */
    public static DukeCommand getCommand(String command) throws InvalidCommandException {
        if (command.equals("bye")) {
            return DukeCommand.BYE;
        } else if (command.equals("list")) {
            return DukeCommand.LIST;
        } else if (command.equals("done")) {
            return DukeCommand.DONE;
        } else if (command.equals("delete")) {
            return DukeCommand.DELETE;
        } else if (command.equals("todo")) {
            return DukeCommand.TODO;
        } else if (command.equals("deadline")) {
            return DukeCommand.DEADLINE;
        } else if (command.equals("event")) {
            return DukeCommand.EVENT;
        } else if (command.equals("find")) {
            return DukeCommand.FIND;
        } else if (command.equals("help")) {
            return DukeCommand.HELP;
        } else if (command.equals("reminder")) {
            return DukeCommand.REMINDER;
        } else {
            throw new InvalidCommandException("HEY!!! I don't know what that means :-(");
        }
    }
}
