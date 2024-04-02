package seedu.duke;

import java.util.Timer;
import java.util.TimerTask;


public class TimerTutorial {

    /**
     * Displays the Tic-tac-toe (TTT) tutorial.
     */
    public void displayTTTTutorial() {

        String[] tttFrames = {
                "Tutorial Mode:\n" +
                "This is the start of the game, choose a square to place an 'X'\n" +
                "    |   |    \n" +
                "-------------\n" +
                "    |   |    \n" +
                "-------------\n" +
                "    |   |    ",

                "\nExample:\n" +
                "    |   |    \n" +
                "-------------\n" +
                "    | X |    \n" +
                "-------------\n" +
                "    |   |    ",
                "TTT Frame 3",
        };
        int tttInterval = 3000; // 3 seconds interval

        scheduleTutorialFrames(tttFrames, tttInterval);
    }

    /**
     * Displays the Hangman tutorial.
     */
    public void displayHangmanTutorial() {

        // Define frames and interval for Hangman tutorial
        String[] hangmanFrames = {
                // Add your Hangman frames here
                "Hangman Frame 1",
                "Hangman Frame 2",
                "Hangman Frame 3",
                // Add more frames as needed
        };
        int hangmanInterval = 3000; // 3 seconds interval

        scheduleTutorialFrames(hangmanFrames, hangmanInterval);
    }

    /**
     * Displays tutorial frames at specified intervals using a timer.
     *
     * @param frames   The frames of the tutorial.
     * @param interval The interval (in milliseconds) between displaying each frame.
     */
    private void scheduleTutorialFrames(String[] frames, int interval) {
        Timer timer = new Timer();
        int[] index = {0}; // Array to store the current frame index

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (index[0] < frames.length) {
                    System.out.println(frames[index[0]]); // Print the current frame
                    index[0]++;
                } else {
                    timer.cancel(); // Cancel the timer when all frames are printed
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, interval); // Schedule the task to run at fixed intervals

        while (index[0] < frames.length) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
