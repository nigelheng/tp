package seedu.duke;

import java.io.IOException;
import java.util.Scanner;

/**
 * The Ui class handles user interface interactions.
 */
public class Ui {
    public static final String LINE = "_________________________________________________________________";
    private final Render render;
    private final TimerTutorial tutorial;
    /**
     * Constructs Ui object with the specified Render object.
     *
     * @param render The Render object used to render UI elements.
     */
    public Ui(Render render, TimerTutorial tutorial) {
        this.render = render;
        this.tutorial = tutorial;
    }

    /**
     * Displays the initial greeting message to the user.
     * This method should be called when the application starts.
     */
    public void greetUser() {
        render.displayGameMenu();
    }

    /**
     * Displays a random farewell message to the user when quitting the application.
     * This method should be called when the user decides to quit the application.
     */
    public void quitUser() {
        render.displayFarewellMessage();
    }

    /**
     * Displays the help message to guide the user on how to use the application.
     * This method should be called when the user requests help.
     */
    public void printHelp() {
        render.displayHelpMessage();
    }

    /**
     * Displays a timed TTT tutorial to see an example gameplay.
     * Any input during this tutorial is ignored.
     */
    public void printTTTTutorial() {
        Scanner in = new Scanner(System.in);
        tutorial.displayTTTTutorial();

        while (tutorial.isTutorialRunning()) {
            if (in.hasNextLine()) {
                // Ignore any input during the tutorial
                println("Tutorial Pilot: Hey! I'm still teaching a tutorial here!");
                in.nextLine();
            }
        }
    }

    /**
     * Displays a timed Hangman tutorial to see an example gameplay.
     * Any input during this tutorial is ignored.
     */
    public void printHangmanTutorial() {
        Scanner in = new Scanner(System.in);
        tutorial.displayHangmanTutorial();

        while (tutorial.isTutorialRunning()) {
            if (in.hasNextLine()) {
                // Ignore any input during the tutorial,
                println("Tutorial Pilot: Hey! I'm still teaching a tutorial here!");
                in.nextLine();
            }
        }
    }

    /**
     * Prints the specified string to the console, followed by a newline.
     *
     * @param s The string to be printed.
     */
    public void println(String s) {
        System.out.println(s);
    }
}
