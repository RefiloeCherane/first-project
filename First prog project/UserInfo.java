package ST10269417.Refiloe.Cherane.POE;
/**
 *
 * @author ST10269417 Refiloe Cherane
 */
import javax.swing.JOptionPane;

public class UserInfo {
    private static String[] developers;
    private static String[] taskNames;
    private static String[] taskIDs;
    private static int[] durations;
    private static String[] taskStatuses;

    private static String developerNames;
    private static String taskName;
    private static int taskNumber;
    private static String description;
    private static int duration;
    private static String status;

    public static void setNumberOfTasks(int numberOfTasks) {
        developers = new String[numberOfTasks];
        taskNames = new String[numberOfTasks];
        taskIDs = new String[numberOfTasks];
        durations = new int[numberOfTasks];
        taskStatuses = new String[numberOfTasks];
    }

    public static void setTaskName(String name) {
        taskName = name;
    }

    public static String getTaskName() {
        return taskName;
    }

    public static void setTaskNumber(int number) {
        taskNumber = number;
    }

    public static int getTaskNumber() {
        return taskNumber;
    }

    public static void setDeveloperNames(String names) {
        developerNames = names;
    }

    public static String getDeveloperNames() {
        return developerNames;
    }

    public static void setDescription(String desc) {
        description = desc;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDuration(int dur) {
        duration = dur;
    }

    public static int getDuration() {
        return duration;
    }

    public static void setStatus(String stat) {
        status = stat;
    }

    public static String getStatus() {
        return status;
    }

    public static void addTask(int index, String devName, String task, int dur, String stat) {
        developers[index] = devName;
        taskNames[index] = task;
        durations[index] = dur;
        taskStatuses[index] = stat;
        taskIDs[index] = createTaskID(task, index);
    }

    public static String createTaskID(String taskName, int index) {
        return taskName.substring(0, 2).toUpperCase() + ":" + (index + 1) + ":" + developers[index].substring(0, 2).toUpperCase();
    }

    public static void WelcomeNote(Login login) {
        int option;
        int end = 0;

        Task obj = new Task();

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Welcome to EasyKanban\n" +
                    "Please select an option \n" +
                    "1. Add task \n" +
                    "2. Display tasks with status 'Done' \n" +
                    "3. Display task with longest duration \n" +
                    "4. Search task by name \n" +
                    "5. Search tasks by developer \n" +
                    "6. Delete task by name \n" +
                    "7. Display report \n" +
                    "8. Quit"));

            switch (option) {
                case 1:
                    int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks you want to perform"));
                    setNumberOfTasks(numberOfTasks);

                    for (int count = 0; count < numberOfTasks; count++) {
                        String status = JOptionPane.showInputDialog("Choose task status \nTo Do\nDoing\nDone");
                        setStatus(status);

                        String taskName = JOptionPane.showInputDialog("Enter the task name");
                        setTaskName(taskName);

                        String devNames = JOptionPane.showInputDialog("Enter the developer Names");
                        setDeveloperNames(devNames);

                        int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration in hours"));
                        setDuration(duration);

                        setTaskNumber(count + 1);
                        addTask(count, devNames, taskName, duration, status);

                        JOptionPane.showMessageDialog(null, obj.printTaskDetails());
                    }
                    break;
                case 2:
                    displayTasksWithStatus("Done");
                    break;
                case 3:
                    displayTaskWithLongestDuration();
                    break;
                case 4:
                    String searchName = JOptionPane.showInputDialog("Enter the task name to search");
                    searchTaskByName(searchName);
                    break;
                case 5:
                    String developer = JOptionPane.showInputDialog("Enter the developer name to search");
                    searchTasksByDeveloper(developer);
                    break;
                case 6:
                    String taskNameToDelete = JOptionPane.showInputDialog("Enter the task name to delete");
                    deleteTaskByName(taskNameToDelete);
                    break;
                case 7:
                    displayReport();
                    break;
                case 8:
                    end = 8;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        } while (end != 8);
    }

    public static void displayTasksWithStatus(String status) {
        StringBuilder tasks = new StringBuilder("Tasks with status " + status + ":\n\n");
        for (int i = 0; i < developers.length; i++) {
            if (taskStatuses[i].equalsIgnoreCase(status)) {
                tasks.append("Developer: ").append(developers[i]).append("\n")
                     .append("Task Name: ").append(taskNames[i]).append("\n")
                     .append("Task Duration: ").append(durations[i]).append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, tasks.toString());
    }

    public static void displayTaskWithLongestDuration() {
        int maxDuration = 0;
        int index = 0;
        for (int i = 0; i < durations.length; i++) {
            if (durations[i] > maxDuration) {
                maxDuration = durations[i];
                index = i;
            }
        }
        JOptionPane.showMessageDialog(null, "Developer: " + developers[index] + "\nDuration: " + durations[index]);
    }

    public static void searchTaskByName(String searchName) {
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equalsIgnoreCase(searchName)) {
                JOptionPane.showMessageDialog(null, "Task Name: " + taskNames[i] + "\nDeveloper: " + developers[i] + "\nTask Status: " + taskStatuses[i]);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    public static void searchTasksByDeveloper(String developer) {
        StringBuilder tasks = new StringBuilder("Tasks assigned to " + developer + ":\n\n");
        for (int i = 0; i < developers.length; i++) {
            if (developers[i].equalsIgnoreCase(developer)) {
                tasks.append("Task Name: ").append(taskNames[i]).append("\n")
                     .append("Task Status: ").append(taskStatuses[i]).append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, tasks.toString());
    }

    public static void deleteTaskByName(String taskNameToDelete) {
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equalsIgnoreCase(taskNameToDelete)) {
                taskNames[i] = null;
                developers[i] = null;
                durations[i] = 0;
                taskStatuses[i] = null;
                taskIDs[i] = null;
                JOptionPane.showMessageDialog(null, "Task " + taskNameToDelete + " deleted.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    public static void displayReport() {
        StringBuilder report = new StringBuilder("Task Report:\n\n");
        for (int i = 0; i < developers.length; i++) {
            report.append("Developer: ").append(developers[i]).append("\n")
                  .append("Task Name: ").append(taskNames[i]).append("\n")
                  .append("Task ID: ").append(taskIDs[i]).append("\n")
                  .append("Task Duration: ").append(durations[i]).append("\n")
                  .append("Task Status: ").append(taskStatuses[i]).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }
}
