package seedu.duke;
import java.util.Random;


public class Render {

    /**
     * Array of sentences to be chosen at random for quitUser()
     */
    private static final String[] BYE_SENTENCES = {
        "AeroCade dismissed. Fly with honor and return victorious.",
        "Departure clearance granted. Execute your aero-maneuvers with expertise.",
        "Aero-Launch sequence initiated. Depart with purpose.",
        "Permission to depart granted. Execute your flight plan with discipline."
    };

    public static String logo = "\n\n\n" + Ui.LINE + "\n" +
            "               _______  _______  ______    _______              \n" +
            "              |   _   ||       ||    _ |  |       |             \n" +
            "  __|____|__  |  |_|  ||    ___||   | ||  |   _   |             \n" +
            "    |  X |    |       ||   |___ |   |_||_ |  | |  |             \n" +
            "  __|____|__  |       ||    ___||    __  ||  |_|  |             \n" +
            "   O|  X |O   |   _   ||   |___ |   |  | ||       |             \n" +
            "              |__| |__||_______||___|  |_||_______|             \n" +
            "               _______  _______  ______   _______               \n" +
            "              |       ||   _   ||      | |       |              \n" +
            "              |       ||  |_|  ||  _    ||    ___|              \n" +
            "              |       ||       || | |   ||   |___     |  @      \n" +
            "              |      _||       || |_|   ||    ___|    | /|\\    \n" +
            "              |     |_ |   _   ||       ||   |___     |  |      \n" +
            "              |_______||__| |__||______| |_______|    | / \\  \n\n" ;

    public static String boeing =
            "                                |                              \n" +
            "                              .-'-.                            \n" +
            "                             ' ___ '                           \n" +
            "                   ---------'  .-.  '---------                 \n" +
            "   _________________________'  '-'  '_________________________ \n" +
            "    ''''''-|---|--/    \\==][^',_m_,'^][==/    \\--|---|-''''''\n" +
            "                  \\    /  ||/   H   \\||  \\    /             \n" +
            "                   '--'   OO   O|O   OO   '--' \n              \n";


    private final String menu =
            "\n              [      Welcome to the AeroCade      ]\n" + Ui.LINE + "\n" +
            "              [          Choose your game:        ]                \n" +
            "                                |                                  \n" +
            "        X  |  -  |  -           |          _______                 \n" +
            "       ____|_____|____          |          |     |                 \n" +
            "           |     |              |          |     @                 \n" +
            "        -  |  O  |  X           |          |    /|\\               \n" +
            "       ____|_____|____          |          |     |                 \n" +
            "           |     |              |          |    / \\               \n" +
            "        -  |  O  |  -           |        ==============            \n" +
            "________________________________|________________________________  \n" +
            "         TIC-TAC-TOE            |           HANGMAN                \n" +
            "          Type 'TTT'            |        Type 'hangman'            \n" +
            "\n\nType 'help' for a list of available commands!                  \n";


    /**
     * Prints the given string to the console.
     *
     * @param s The string to be printed.
     */
    public void println(String s) {
        System.out.println(s);
    }

    /**
     * Greets the user by displaying the AeroCade logo, boeing, and game menu.
     */
    public void displayGameMenu() {
        println(logo + boeing + Ui.LINE + menu + Ui.LINE);
    }

    /**
     * Displays a random farewell message from an array to the user.
     */
    public void displayFarewellMessage() {
        int randomIndex = new Random().nextInt(BYE_SENTENCES.length);
        println(Ui.LINE + "\n\n" + boeing + BYE_SENTENCES[randomIndex] + "\n");
    }

    /**
     * Prints a help message listing the available commands.
     */
    public void displayHelpMessage() {
        println(Ui.LINE + "\nHere are the list of commands:\n" + Ui.LINE +
                "\n[Gameplay:]" +
                "\ntype 'TTT tutorial' for a Tic-tac-toe example gameplay\n" +
                "'TTT' - Starts Tic-tac-toe Game\n" +
                "type 'hangman tutorial' for a Hangman example gameplay\n" +
                "'hangman' - Starts Hangman Game\n" +
                "[Miscellaneous:]\n" +
                "'stats' to see games won\n"  +
                "'quit' to exit the program\n"+ Ui.LINE);
    }
}
