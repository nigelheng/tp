package seedu.duke;

import seedu.duke.exceptions.InvalidTTMoveException;

import java.util.Scanner;

import java.util.Random;

import static seedu.duke.Parser.readTTMove;

public class TicTacToe extends Game {
    protected static String[] board = new String[9];

    public TicTacToe(String line) {
        super(line);
    }

    private static void printBoard() {
        ui.println("  " + board[0] + " | " + board[1] + " | " + board[2] + "  ");
        ui.println("-------------");
        ui.println("  " + board[3] + " | " + board[4] + " | " + board[5] + "  ");
        ui.println("-------------");
        ui.println("  " + board[6] + " | " + board[7] + " | " + board[8] + "  ");
    }

    private static String checkWinner(int turnCount) {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            default:
                //this never happens
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        if (turnCount == 9) {
            return "draw";
        }
        return "unending";
    }

    private static int computerBestMove(String[] board, int turnCount) {
        Random rand = new Random();
        if (turnCount == 1 && board[4].equals(" ")) {
            return 4;
        }
        if (turnCount == 1 && board[4].equals("X")) {
            return 0;
        }
        for (int a = 0; a < 8; a++) {
            String line;
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                switch (line) {
                case "OO ":
                    return 2;
                case "O O":
                    return 1;
                case " OO":
                    return 0;
                default:
                    //nothing happens
                }

                break;
            case 1:
                line = board[3] + board[4] + board[5];
                switch (line) {
                case "OO ":
                    return 5;
                case "O O":
                    return 4;
                case " OO":
                    return 3;
                default:
                    //nothing happens
                }
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                switch (line) {
                case "OO ":
                    return 8;
                case "O O":
                    return 7;
                case " OO":
                    return 6;
                default:
                    //nothing happens
                }
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                switch (line) {
                case "OO ":
                    return 6;
                case "O O":
                    return 3;
                case " OO":
                    return 0;
                default:
                    //nothing happens
                }
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                switch (line) {
                case "OO ":
                    return 7;
                case "O O":
                    return 4;
                case " OO":
                    return 1;
                default:
                    //nothing happens
                }
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                switch (line) {
                case "OO ":
                    return 8;
                case "O O":
                    return 5;
                case " OO":
                    return 2;
                default:
                    //nothing happens
                }
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                switch (line) {
                case "OO ":
                    return 8;
                case "O O":
                    return 4;
                case " OO":
                    return 0;
                default:
                    //nothing happens
                }
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                switch (line) {
                case "OO ":
                    return 6;
                case "O O":
                    return 4;
                case " OO":
                    return 2;
                default:
                    //nothing happens
                }
                break;
            default:
                //this never happens
            }
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                switch (line) {
                case "XX ":
                    return 2;
                case "X X":
                    return 1;
                case " XX":
                    return 0;
                default:
                    //nothing happens
                }

                break;
            case 1:
                line = board[3] + board[4] + board[5];
                switch (line) {
                case "XX ":
                    return 5;
                case "X X":
                    return 4;
                case " XX":
                    return 3;
                default:
                    //nothing happens
                }
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                switch (line) {
                case "XX ":
                    return 8;
                case "X X":
                    return 7;
                case " XX":
                    return 6;
                default:
                    //nothing happens
                }
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                switch (line) {
                case "XX ":
                    return 6;
                case "X X":
                    return 3;
                case " XX":
                    return 0;
                default:
                    //nothing happens
                }
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                switch (line) {
                case "XX ":
                    return 7;
                case "X X":
                    return 4;
                case " XX":
                    return 1;
                default:
                    //nothing happens
                }
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                switch (line) {
                case "XX ":
                    return 8;
                case "X X":
                    return 5;
                case " XX":
                    return 2;
                default:
                    //nothing happens
                }
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                switch (line) {
                case "XX ":
                    return 8;
                case "X X":
                    return 4;
                case " XX":
                    return 0;
                default:
                    //nothing happens
                }
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                switch (line) {
                case "XX ":
                    return 6;
                case "X X":
                    return 4;
                case " XX":
                    return 2;
                default:
                    //nothing happens
                }
                break;
            default:
                //this never happens
            }
        }
        int computerPlacement;

        computerPlacement = rand.nextInt(9);
        while (board[computerPlacement].equals("X") ||
                board[computerPlacement].equals("O")) {
            computerPlacement = rand.nextInt(9);
        }
        return computerPlacement;
    }

    @Override
    public void runGame() {
        for (int i = 0; i < 9; i++) {
            board[i] = " ";
        }

        Random rand = new Random();

        int turnCount = 0;

        Scanner in = new Scanner(System.in);
        String line;
        String strength;

        ui.println("Choose: 'easy', our first champion, is a benchmark for all challengers to test their mettle," +
                "or 'hard', our second champion, is an Elder of the clouds. Which opponent do you desire, challenger?");

        strength = in.nextLine();

        while (checkWinner(turnCount).equals("unending")) {
            printBoard();
            ui.println(Ui.LINE);
            ui.println("Make your move, challenger.");
            line = in.nextLine();
            assert line != null;

            if (Parser.ifQuit(line)) {
                break;
            }

            if (Parser.ifShowGuide(line)) {
                howToPlay();
                line = in.nextLine();
            }
            try {
                readTTMove(line);

                while ((board[Integer.parseInt(line) - 1].equals("X")) ||
                        (board[Integer.parseInt(line) - 1].equals("O"))) {
                    ui.println("Hilarious. Try selecting a tile that is not already occupied, fledgling.");
                    line = in.nextLine();
                    readTTMove(line);
                }

                board[Integer.parseInt(line) - 1] = "X";
                turnCount++;

                if (turnCount == 9) {
                    break;
                }

                int computerPlacement;

                if (strength.equals("easy")) {
                    computerPlacement = rand.nextInt(9);
                    while (board[computerPlacement].equals("X") ||
                            board[computerPlacement].equals("O")) {
                        computerPlacement = rand.nextInt(9);
                    }
                } else {
                    computerPlacement = computerBestMove(board, turnCount);
                }

                board[computerPlacement] = "O";
                turnCount++;
            } catch (InvalidTTMoveException e) {
                ui.println("Your move is invalid, invalid. Enter only 1-9, and do not make me ask again. " +
                        "Type 'guide' for tutorial guide");

            }
        }
        String whoWon = checkWinner(turnCount);
        switch (whoWon) {
        case "X":
            printBoard();
            gameWon();
            ui.println(Ui.LINE);
            ui.println("You have claimed victory over the skies. Godspeed, champion.");
            ui.println(Ui.LINE);
            break;
        case "O":
            printBoard();
            ui.println(Ui.LINE);
            ui.println("Your defeat has brought shame to the skies. Try again, if you dare.");
            ui.println(Ui.LINE);
            break;
        case "draw":
            printBoard();
            ui.println(Ui.LINE);
            ui.println("It seems you have met your match. Try again, and this time, do try to win.");
            ui.println(Ui.LINE);
            break;
        default:
            ui.println(Ui.LINE);
            ui.println("Cowards belong on the ground.");
            ui.println(Ui.LINE);
            break;
        }
    }

    /**
     * Prints the game guide when 'guide' is inputted
     */
    @Override
    public void howToPlay() {
        super.howToPlay();

        ui.println(Ui.LINE);
        System.out.println("\t- The ancient game of Tic-Tac-Toe, as foretold by our forefathers, is a trial\n " +
                "by single combat.");
        System.out.println("\t- A grid, numbering three across and three lengthwise. Each space represents a\n " +
                "spot you can occupy.");
        System.out.println("\t- You and your opponent will take turns making your moves. " +
                "The first to complete a line, either horizontally, diagonally or vertically, will emerge the\n " +
                "victorious, and give rightful justification to their place in the skies.");
        ui.println(Ui.LINE);
        System.out.println("Commands for the game:");
        System.out.println("\t- To mark a box, simply key in the box's number.");
        System.out.println("\t- The grid is marked from left to right, top to bottom, from 1 to 9."
                + System.lineSeparator());
        ui.println(Ui.LINE);
    }
}
