package seedu.duke;

import java.util.Timer;
import java.util.TimerTask;


public class TimerTutorial {

    /**
     * Displays the Tic-tac-toe (TTT) tutorial.
     */
    public void displayTTTTutorial() {

        String[] tttFrames = { Ui.LINE +
                "\n[Tutorial Mode is playing, do not input any commands!]\n" +
                "Tutorial Pilot: Good day! this is Tutorial Pilot and I will demonstrate\n" +
                "                a stellar gameplay of TTT for you!\n\n" +
                "    |   |    \n" +
                "-------------\n" +
                "    |   |    \n" +
                "-------------\n" +
                "    |   |    \n\n" +
                "Tutorial Pilot: This is a TTT board which I'll be placing an 'X' depending on\n" +
                "                the number I put, here is the numbered layout!\n" + Ui.LINE,

            "  1 | 2 | 3  \n" +
                "-------------\n" +
                "  4 | 5 | 6  \n" +
                "-------------\n" +
                "  7 | 8 | 9  \n\n" +
                "Tutorial Pilot: I shall put '5'. I must get a row, column or diagonal of 'X' to win!\n" + Ui.LINE,

            "    |   |    \n" +
                "-------------\n" +
                "    | X |    \n" +
                "-------------\n" +
                "    |   |    \n\n" +
                "Tutorial Pilot: I wonder how my opponent will respond...\n" + Ui.LINE,

            "    |   |    \n" +
                "-------------\n" +
                "    | X | O  \n" +
                "-------------\n" +
                "    |   |    \n\n" +
                "Tutorial Pilot: Goodness gracious! I'll perform a flank by putting '9'!\n" + Ui.LINE,

            "    |   |    \n" +
                "-------------\n" +
                "    | X | O  \n" +
                "-------------\n" +
                "    |   | X  \n\n" +
                "Tutorial Pilot: Surely my opponent will get stumped!\n" + Ui.LINE,

            "    |   |    \n" +
                "-------------\n" +
                "  O | X | O  \n" +
                "-------------\n" +
                "    |   | X  \n\n" +
                "Tutorial Pilot: The opponent made a mistake! Now is my chance to put '1'!\n" + Ui.LINE,

            "  X |   |    \n" +
                "-------------\n" +
                "  O | X | O  \n" +
                "-------------\n" +
                "    |   | X  \n\n" +
                "Tutorial Pilot: I won! Hope this tutorial gameplay was helpful.\n" +
                "                Tutorial Pilot, signing off~\n" +
                "[Tutorial Mode over, resume commands!]\n" + Ui.LINE
        };
        int tttInterval = 4000; // 4 seconds interval

        scheduleTutorialFrames(tttFrames, tttInterval);
    }

    /**
     * Displays the Hangman tutorial.
     */
    public void displayHangmanTutorial() {

        // Define frames and interval for Hangman tutorial
        String[] hangmanFrames = { Ui.LINE +
                "\n[Tutorial Mode is playing, do not input any commands!]\n" +
                "Tutorial Pilot: Good day! this is Tutorial Pilot and I will demonstrate\n" +
                "                a stellar gameplay of Hangman for you!\n\n" +
                "_______        \n" +
                "|     |        \n" +
                "|              \n" +
                "|              \n" +
                "|              \n" +
                "|              \n" +
                "============== \n" +
                "_ _ _ _ _      \n\n" +
                "Tutorial Pilot: This is the start of the game, for this tutorial, I'll need to\n" +
                "                guess a 5-letter word before the 'hangman' is drawn out, which\n" +
                "                means I can only make 5 wrong guesses! Let's try the letter 'a'\n" + Ui.LINE,

            "_______        \n" +
                "|     |        \n" +
                "|     @        \n" +
                "|              \n" +
                "|              \n" +
                "|              \n" +
                "============== \n" +
                "_ _ _ _ _      \n\n" +
                "Tutorial Pilot: Oh no! There is no 'a' in this word, looks like I'll try another vowel 'o'\n"
                + Ui.LINE,

            "_______        \n" +
                "|     |        \n" +
                "|     @        \n" +
                "|     |        \n" +
                "|     |        \n" +
                "|              \n" +
                "============== \n" +
                "_ _ _ _ _      \n\n" +
                "Tutorial Pilot: I'm in trouble! How about 'e'?\n" + Ui.LINE,

            "_______        \n" +
                "|     |        \n" +
                "|     @        \n" +
                "|    /|        \n" +
                "|     |        \n" +
                "|              \n" +
                "============== \n" +
                "_ _ _ _ _      \n\n" +
                "Tutorial Pilot: Goodness gracious, maybe 'i'?\n" + Ui.LINE,

            "_______        \n" +
                "|     |        \n" +
                "|     @        \n" +
                "|    /|\\      \n" +
                "|     |        \n" +
                "|              \n" +
                "============== \n" +
                "_ _ _ _ _      \n\n" +
                "Tutorial Pilot: I have two tries left! This word is strange, I might have to change\n" +
                "                my strategy here, I'll try 'y'!\n" + Ui.LINE,

            "_______        \n" +
                "|     |        \n" +
                "|     @        \n" +
                "|    /|\\      \n" +
                "|     |        \n" +
                "|              \n" +
                "============== \n" +
                "_ _ y _ _      \n\n" +
                "Tutorial Pilot: Yes! I might win here, I'm going with 'h' now!\n" + Ui.LINE,

            "_______        \n" +
                "|     |        \n" +
                "|     @        \n" +
                "|    /|\\      \n" +
                "|     |        \n" +
                "|              \n" +
                "============== \n" +
                "_ _ y _ h      \n\n" +
                "Tutorial Pilot: Awesome, I'll try my luck with the whole word 'psych'!\n" + Ui.LINE,

            "_______        \n" +
                "|     |        \n" +
                "|     @        \n" +
                "|    /|\\      \n" +
                "|     |        \n" +
                "|    /         \n" +
                "============== \n" +
                "_ _ y _ h      \n\n" +
                "Tutorial Pilot: NOOO, I have only 1 try left, I'm going with 'glyph' now\n" + Ui.LINE,

            "g l y p h      \n\n" +
                "Tutorial Pilot: Whew that was a close one! Hope this tutorial gameplay was helpful.\n" +
                "                Tutorial Pilot, signing off~\n" +
                "[Tutorial Mode over, resume commands!]\n" + Ui.LINE
        };
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
