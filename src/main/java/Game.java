public class Game {
    private Ui ui;
    protected int gameType; // 0 to exit, 1 for tictactoe, 2 for hangman
    protected TicTacToe game;

    public Game(String line) {
        ui = new Ui();
     gameType = Integer.parseInt(line);
     switch (gameType) {
     case 0:
         //exit game
         break;
     case 1:
         game = new TicTacToe();
         break;
     case 2:
         //enters hangman game
         break;
     }

    }
}
