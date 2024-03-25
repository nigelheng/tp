package seedu.duke;
import java.util.Random;

/**
 * The Ui class handles user interface interactions.
 */
public class Ui {
    private static final String LINE = "_________________________________________________________________";
    private String[] byeSentences = {
        "AeroCade dismissed. Fly with honor and return victorious.",
        "Departure clearance granted. Execute your aero-maneuvers with expertise.",
        "Aero-Launch sequence initiated. Depart with purpose.",
        "Permission to depart granted. Execute your flight plan with discipline."
    };

    private String logo = "\n\n\n" + LINE + "\n" +
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

    private String boeing =
            "                                |                              \n" +
            "                              .-'-.                            \n" +
            "                             ' ___ '                           \n" +
            "                   ---------'  .-.  '---------                 \n" +
            "   _________________________'  '-'  '_________________________ \n" +
            "    ''''''-|---|--/    \\==][^',_m_,'^][==/    \\--|---|-''''''\n" +
            "                  \\    /  ||/   H   \\||  \\    /             \n" +
            "                   '--'   OO   O|O   OO   '--' \n              \n";
    public void println(String s) {
        System.out.println(s);
    }

    
    public void greetUser() {
        println(logo + boeing + LINE +
            "\n              [      Welcome to the AeroCade      ]\n" + LINE);
        println(
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
            "\n\nType 'help' for a list of available commands!                  \n");
    }

    public void byeUser() {
        int randomIndex = new Random().nextInt(byeSentences.length);
        println(LINE + "\n\n" + boeing + byeSentences[randomIndex] + "\n");
    }

    public void printHelp() {
        println(LINE + "\nHere are the list of commands:\n" +
                "'TTT' - Starts Tic-tac-toe Game\n" +
                "type 'help TTT' for Tic-tac-toe commands\n\n" +
                "'hangman' - Starts Hangman Game\n" +
                "type 'help hangman' for Hangman commands\n" + LINE);
    }
}


