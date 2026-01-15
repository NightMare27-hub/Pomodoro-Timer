package task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task t) { tasks.add(t); }
    public void removeTask(Task t) { tasks.remove(t); }
    public List<Task> getTasks() { return tasks; }
}
