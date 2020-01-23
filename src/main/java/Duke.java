import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        boolean isRunning  = true;
        List<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("    ____________________________________________________________\n" +
                "     Hello! I'm Duke\n" +
                "     What can I do for you?\n" +
                "    ____________________________________________________________");

        while (isRunning) {
            try {
                String input = scanner.nextLine();
                String[] commandLine = input.split(" ", 2);
                Command command = Command.getCommand(commandLine[0]);
                switch (command) {
                    case BYE:
                        System.out.println("    ____________________________________________________________\n"
                                + "     Bye. Hope to see you again soon!\n"
                                + "    ____________________________________________________________");
                        isRunning = false;
                        break;
                    case LIST:
                        System.out.println("    ____________________________________________________________\n"
                                + "     Here are the tasks in your list:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.printf("     %d. %s\n", (i + 1), tasks.get(i));
                        }
                        System.out.println("    ____________________________________________________________");
                        break;
                    case DONE:
                        int taskNumToDone = Integer.parseInt(commandLine[1]);
                        if (taskNumToDone > tasks.size() || taskNumToDone <= 0) {
                            throw new InvalidCommandException("     ☹ OOPS!!! I cannot set a "
                                    + "non-existent task to be done.");
                        }

                        Task taskToMark = tasks.get(taskNumToDone - 1);
                        taskToMark.markDone();
                        System.out.println("    ____________________________________________________________\n"
                                + "     Nice! I've marked this task as done:");
                        System.out.printf("     %s\n", taskToMark);
                        System.out.println("    ____________________________________________________________");
                        break;
                    case DELETE:
                        int taskNumtoDelete = Integer.parseInt(commandLine[1]);
                        if (taskNumtoDelete > tasks.size() || taskNumtoDelete <= 0) {
                            throw new InvalidCommandException("     ☹ OOPS!!! I cannot delete a "
                                    + "non-existent task.");
                        }

                        Task taskToDelete = tasks.remove(taskNumtoDelete - 1);
                        System.out.println("    ____________________________________________________________");
                        System.out.printf("     Noted. I've removed this task:\n         %s\n", taskToDelete);
                        System.out.printf("     Now you have %d tasks in the list.\n", tasks.size());
                        System.out.println("    ____________________________________________________________");
                        break;
                    case TODO:
                        if (commandLine.length < 2) {
                            throw new InvalidCommandException("     ☹ OOPS!!! The description of a "
                                    + "todo cannot be empty.");
                        }
                        Task newTodoTask = new Todo(commandLine[1]);
                        tasks.add(newTodoTask);
                        System.out.println("    ____________________________________________________________");
                        System.out.printf("     Got it. I've added this task:\n       %s\n", newTodoTask);
                        System.out.printf("     Now you have %d tasks in the list.\n", tasks.size());
                        System.out.println("    ____________________________________________________________");
                        break;
                    case DEADLINE:
                        if (commandLine.length < 2) {
                            throw new InvalidCommandException("     ☹ OOPS!!!"
                                    + " The description of a deadline cannot be empty.");
                        }
                        String[] deadlineDescriptionDate = commandLine[1].split(" /by ");
                        Task newDeadlineTask = new Deadline(deadlineDescriptionDate[0], deadlineDescriptionDate[1]);
                        tasks.add(newDeadlineTask);
                        System.out.println("    ____________________________________________________________");
                        System.out.printf("     Got it. I've added this task:\n       %s\n", newDeadlineTask);
                        System.out.printf("     Now you have %d tasks in the list.\n", tasks.size());
                        System.out.println("    ____________________________________________________________");
                        break;
                    case EVENT:
                        if (commandLine.length < 2) {
                            throw new InvalidCommandException("     ☹ OOPS!!! The description of a "
                                    + "event cannot be empty.");
                        }
                        String[] eventDescriptionDate = commandLine[1].split(" /at ");
                        Task newEventTask = new Event(eventDescriptionDate[0], eventDescriptionDate[1]);
                        tasks.add(newEventTask);
                        System.out.println("    ____________________________________________________________");
                        System.out.printf("     Got it. I've added this task:\n       %s\n", newEventTask);
                        System.out.printf("     Now you have %d tasks in the list.\n", tasks.size());
                        System.out.println("    ____________________________________________________________");
                        break;
                    default:
                        break;
                }

            } catch (InvalidCommandException e) {
                System.out.println("    ____________________________________________________________");
                System.out.println(e.getMessage());
                System.out.println("    ____________________________________________________________");
            }
        }
    }
}
