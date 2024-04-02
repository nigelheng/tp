package seedu.duke;

import seedu.duke.exceptions.InvalidGameException;
import seedu.duke.exceptions.InvalidTTMoveException;

import java.io.IOException;
import java.util.ArrayList;


public class Duke {
    private static final Render render = new Render();
    private static final TimerTutorial tutorial = new TimerTutorial();
    private static final Ui ui = new Ui(render, tutorial);
    //private static final HangMan hangman = new HangMan();
    private static ArrayList<Game> games = new ArrayList<>();
    private static int gameCounter = 0;

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        ui.greetUser();

        boolean inGame = false;
        String input = Parser.readLine();
        assert input != null;

        while (true) {
            if (Parser.ifQuit(input)) {
                ui.quitUser();
                break;
            } else if (input.equals("testquit")) {
                ui.println("runtestbat success!");
                break;
            }


            if (!inGame) {
                try {
                    Parser.readGame(input);
                    inGame = true;
                    if (input.equals("TTT")) {
                        try {
                            games.add(new TicTacToe(input));
                            games.get(gameCounter).runGame();
                            gameCounter ++;
                            ui.println("Now what would you like to do?");
                            inGame = false;
                        } catch (InvalidTTMoveException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (input.equals("hangman")) {
                        games.add(new HangMan(input));
                        games.get(gameCounter).runGame();
                        gameCounter ++;
                        ui.println("Now what would you like to do?");
                        inGame = false;
                    } else if (Parser.ifHelp(input)) {
                        ui.printHelp();
                        inGame = false;
                    }
                    else if (Parser.ifTutorial(input)) {
                        if (input.equals("TTT tutorial")) {
                            ui.printTTTTutorial();

                        } else {
                            ui.printHangmanTutorial();
                        }
                        inGame = false;
                    }
                } catch (InvalidGameException | NullPointerException e) {
                    ui.println("Invalid Game. Type \'help\' for list of available commands.");
                } catch (InvalidTTMoveException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
            input = Parser.readLine();
        }
    }
}
