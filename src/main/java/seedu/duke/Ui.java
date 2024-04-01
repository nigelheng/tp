package seedu.duke;

/**
 * The Ui class handles user interface interactions.
 */
public class Ui {
    private final Render render;
    /**
     * Constructs Ui object with the specified Render object.
     *
     * @param render The Render object used to render UI elements.
     */
    public Ui(Render render) {
        this.render = render;
    }

    /**
     * Displays the initial greeting message to the user.
     * This method should be called when the application starts.
     */
    public void greetUser() {
        render.displayGameMenu();
    }

    /**
     * Displays a farewell message to the user when quitting the application.
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
     * Prints the specified string to the console, followed by a newline.
     *
     * @param s The string to be printed.
     */
    public void println(String s) {
        System.out.println(s);
    }
}