package timer;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PomodoroTimer {
    private int totalTime = 25 * 60; // 25 minutes default
    private int currentTime = totalTime;
    private Timer timer;
    private boolean running = false;

    public PomodoroTimer(ActionListener tickListener) {
        timer = new Timer(1000, e -> {
            if (currentTime > 0) {
                currentTime--;
                tickListener.actionPerformed(null);
            } else {
                stop();
                JOptionPane.showMessageDialog(null, "Pomodoro Complete!");
            }
        });
    }

    public void start() {
        if (!running) {
            timer.start();
            running = true;
        }
    }

    public void pause() {
        timer.stop();
        running = false;
    }

    public void reset() {
        timer.stop();
        currentTime = totalTime;
        running = false;
    }
    public void stop() {
        timer.stop();
        running = false;
    }
    public boolean isRunning() { return running; }
    public int getCurrentTime() { return currentTime; }

    public int getProgressPercent() {
        return 100 - (currentTime * 100 / totalTime);
    }
}
