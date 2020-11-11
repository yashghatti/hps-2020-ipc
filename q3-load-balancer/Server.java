import java.util.ArrayList;
import java.util.List;

public class Server {

    private List<Task> taskList = new ArrayList<>();
    private int rupm; //Resource Units per minute
    private int position;

    public Server(int rupm, int position) {
        this.rupm = rupm;
        this.position = position;
    }

    public boolean canAddTask(Task t) {
        int remainingRUpm = rupm - taskList.stream()
                .mapToInt(task -> task.getResourceUnits())
                .sum();
        if(t.getResourceUnits() > remainingRUpm)
            return false;
        return true;
    }

    public void addTask(Task t) {
        this.taskList.add(t);
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public int getRupm() {
        return rupm;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Server{" +
                "taskList=" + taskList +
                ", rupm=" + rupm +
                '}';
    }
}
