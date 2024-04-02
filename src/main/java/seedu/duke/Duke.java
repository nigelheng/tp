package seedu.duke;

import seedu.duke.exceptions.InvalidGameException;
import seedu.duke.exceptions.InvalidTTMoveException;

import java.util.ArrayList;


public class Duke {
    private static final Render render = new Render();
    private static final Ui ui = new Ui(render);
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
                            System.out.println("Now what would you like to do?");
                            inGame = false;
                        } catch (InvalidTTMoveException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (input.equals("hangman")) {
                        System.out.println("What category would you like to choose? These are the options:");
                        System.out.println("animals, countries, fruits & sports");
                        String category = Parser.readLine();
                        games.add(new HangMan(category));
                        games.get(gameCounter).runGame();
                        gameCounter ++;
                        System.out.println("Now what would you like to do?");
                        inGame = false;
                    } else if (Parser.ifHelp(input)) {
                        ui.printHelp();
                        inGame = false;
                    }
                } catch (InvalidGameException | NullPointerException e) {
                    ui.println("Invalid Game. Type \'help\' for list of available commands.");
                } catch (InvalidTTMoveException e) {
                    throw new RuntimeException(e);
                }
            }
            input = Parser.readLine();
        }
    }
}
