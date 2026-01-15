package gui;

import task.*;
import timer.PomodoroTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
    private TaskManager taskManager = new TaskManager();
    private DefaultListModel<Task> taskListModel = new DefaultListModel<>();
    private PomodoroTimer pomodoroTimer;

    private JLabel timerLabel = new JLabel("25:00");
    private JProgressBar progressBar = new JProgressBar(0, 100);
    private JButton startButton = new JButton("Start");
    private JButton pauseButton = new JButton("Pause");
    private JButton resetButton = new JButton("Reset");
    private JList<Task> taskList = new JList<>(taskListModel);

    public MainWindow() {
        setTitle("🧘 Pomodoro Task Tracker");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Timer panel
        JPanel timerPanel = new JPanel(new GridLayout(2, 1));
        timerLabel.setFont(new Font("Arial", Font.BOLD, 32));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerPanel.add(timerLabel);
        timerPanel.add(progressBar);

        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(startButton);
        controlPanel.add(pauseButton);
        controlPanel.add(resetButton);
        timerPanel.add(controlPanel);

        add(timerPanel, BorderLayout.NORTH);

        // Task list
        JScrollPane scrollPane = new JScrollPane(taskList);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel(new FlowLayout());
        JTextField taskField = new JTextField(15);
        JButton addTaskBtn = new JButton("Add Task");
        JButton removeTaskBtn = new JButton("Remove Task");
        JButton completeBtn = new JButton("Mark Done");

        bottomPanel.add(taskField);
        bottomPanel.add(addTaskBtn);
        bottomPanel.add(removeTaskBtn);
        bottomPanel.add(completeBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        // Timer logic
        pomodoroTimer = new PomodoroTimer(e -> updateTimer());

        startButton.addActionListener(e -> pomodoroTimer.start());
        pauseButton.addActionListener(e -> pomodoroTimer.pause());
        resetButton.addActionListener(e -> {
            pomodoroTimer.reset();
            updateTimer();
        });

        addTaskBtn.addActionListener(e -> {
            String title = taskField.getText().trim();
            if (!title.isEmpty()) {
                Task t = new Task(title);
                taskManager.addTask(t);
                taskListModel.addElement(t);
                taskField.setText("");
            }
        });

        removeTaskBtn.addActionListener(e -> {
            Task selected = taskList.getSelectedValue();
            if (selected != null) {
                taskManager.removeTask(selected);
                taskListModel.removeElement(selected);
            }
        });

        completeBtn.addActionListener(e -> {
            Task selected = taskList.getSelectedValue();
            if (selected != null) {
                selected.markCompleted();
                taskList.repaint();
            }
        });

        updateTimer(); // initial
    }

    private void updateTimer() {
        int seconds = pomodoroTimer.getCurrentTime();
        int mins = seconds / 60;
        int secs = seconds % 60;
        timerLabel.setText(String.format("%02d:%02d", mins, secs));
        progressBar.setValue(pomodoroTimer.getProgressPercent());

        // Optional: assign time to selected task
        Task selected = taskList.getSelectedValue();
        if (selected != null && pomodoroTimer.isRunning()) {
            selected.addTimeSpent(1);
        }
    }
}
