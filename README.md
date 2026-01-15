# 🧘 Pomodoro Task Tracker

A functional productivity tool built with Java that combines a classic Pomodoro timer with a task management system. This application helps users maintain focus by breaking work into intervals and tracking time spent on specific goals.


## ✨ Key Features
* **Interactive Timer:** A 25-minute Pomodoro countdown with Start, Pause, and Reset functionality.
* **Visual Progress:** A real-time progress bar to track your focus session at a glance.
* **Task Management:** Create, track, and remove tasks within a clean list interface.
* **Time Tracking:** Automatically logs focus time to the currently selected task while the timer is running.
* **Completion Status:** Mark tasks as complete with a visual indicator (`[✔]`).

## 🛠️ Technical Stack
* **Language:** Java
* **GUI Library:** Java Swing & AWT
* **Design Pattern:** Object-Oriented approach with separated logic for timers and task management.

## 📂 Project Structure
* `timer/`: Contains `PomodoroTimer.java` - logic for the countdown and progress percentage.
* `task/`: Contains `Task.java` and `TaskManager.java` - the data models for user goals.
* `gui/`: Contains `MainWindow.java` - the visual assembly and event handling.

## 🚀 How to Run
1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/your-username/pomodoro-task-tracker.git](https://github.com/your-username/pomodoro-task-tracker.git)
    ```
2.  **Compile and Run:**
    Open the project in your favorite IDE (like IntelliJ or Eclipse) and run `Main.java`.

## 📈 Future Enhancements
* Customizable timer durations for breaks.
* Exp/Leveling system (Gamification) for completed tasks.
* Persistent storage to save tasks between sessions.
