package seedu.duke;
import seedu.duke.exceptions.InvalidTTMoveException;

/**
 * Game class with 2 subclasses TicTacToe and HangMan
 * Contains methods for handling running of game and showing of game guide
 */
public class Game {
    protected boolean isExit; // true to exit
    protected String gameName;

    protected boolean isWin; //true if won, false if lost, quit or draw (for TTT)
    /**
     * creates a game
     *
     * @param line is used to set the gameName of the game
     */
    public Game(String line) {
        gameName = line;
        isExit = false; //not used for nw
        isWin = false;
        //assert !isExit; //not used for now
    }

    /**
     * runs game for respective class.
     * overridden in TicTacToe and HangMan
     * @throws InvalidTTMoveException if input for TTT game is not 1-9
     */
    public void runGame() throws InvalidTTMoveException {

    }

    /**
     * displays game guide when 'guide' is inputted
     * overridden in TicTacToe and Hangman
     */
    public void howToPlay() {
        System.out.println("----------------------------------------------------");
        System.out.println("Let me explain the rules of this game:");
    }

    public void gameWon() {
        this.isWin = true;
    }
}
