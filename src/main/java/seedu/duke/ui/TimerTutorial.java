package seedu.duke.ui;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTutorial {
    private boolean tutorialRunning = false; // Flag to track if tutorial is running


    public boolean isTutorialRunning() {
        return tutorialRunning;
    }

    /**
     * Displays the Tic-tac-toe (TTT) tutorial.
     */
    public void displayTTTTutorial() {
        tutorialRunning = true;
        String[] tttFrames = Render.getTTTFrames();
        int tttInterval = 4000; // 4 seconds interval
        scheduleTutorialFrames(tttFrames, tttInterval);
    }

    /**
     * Displays the Hangman tutorial.
     */
    public void displayHangmanTutorial() {
        tutorialRunning = true;
        String[] hangmanFrames = Render.getHangmanFrames();
        int hangmanInterval = 4000; // 4 seconds interval
        scheduleTutorialFrames(hangmanFrames, hangmanInterval);
    }


    /**
     * Displays tutorial frames at specified intervals using a timer. Inputs will not be read till
     * all frames are displayed
     *
     * @param frames   The frames of the tutorial.
     * @param interval The interval (in milliseconds) between displaying each frame.
     */
    private void scheduleTutorialFrames(String[] frames, int interval) {
        Timer timer = new Timer();
        int[] index = {0}; // Array to store the current frame index

        tutorialRunning = true;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (Ui.stopTutorial) { // Check if stop command
                    timer.cancel();
                    tutorialRunning = false;
                    return;
                }
                if (index[0] != frames.length) {
                    tutorialRunning = true;
                    System.out.println(frames[index[0]]); // Print the current frame
                    index[0]++;
                } else {
                    tutorialRunning = false;
                    timer.cancel();
                    return;
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, interval); // Schedule the task to run at fixed intervals
    }
}
