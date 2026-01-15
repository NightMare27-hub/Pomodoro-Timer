package task;

public class Task {
    private String title;
    private boolean completed;
    private int timeSpentSeconds = 0;

    public Task(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }
    public int getTimeSpentSeconds() { return timeSpentSeconds; }

    public void markCompleted() { this.completed = true; }
    public void addTimeSpent(int seconds) { this.timeSpentSeconds += seconds; }

    @Override
    public String toString() {
        return (completed ? "[✔] " : "[ ] ") + title + " (" + (timeSpentSeconds / 60) + " min)";
    }
}
