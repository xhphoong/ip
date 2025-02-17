package anya;

/**
 * Represents a command to delete the task with this taskNo in the current tasklist.
 */
public class DeleteCommand extends Command {

    private final int taskNo;

    DeleteCommand(int taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * Execute the delete command.
     * @param tasks current tasklist.
     * @param ui interaction class.
     * @return the response of Anya.
     */
    String execute(TaskList tasks, Ui ui) throws AnyaException {
        String[] taskInfo = tasks.delete(this.taskNo);
        int noOfTasks = Integer.parseInt(taskInfo[1]);
        String task = taskInfo[0];
        String response = ui.deleted(task, noOfTasks);
        return response;
    }

}
