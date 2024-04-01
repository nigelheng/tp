package seedu.duke;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
public class HangMan extends Game {
    protected String[] wordBank = new String[11];
    protected ArrayList<String> allGuessedLetters = new ArrayList<>();
    protected int numberOfLettersGuessed = 0;
    protected String chosenWord;
    protected int chosenWordLength;
    protected String correctGuesses;
    protected int state = 0;
    protected final String LETTER_SPACE = "_";

    public HangMan(String line) {
        super(line);
        String words = "ant baboon badger bat bear beaver camel cat clam cobra cougar";
        wordBank = words.split(" ",11);
        Random rand = new Random();
        int whichWord = rand.nextInt(11);
        chosenWord = wordBank[whichWord];
        chosenWordLength = wordBank[whichWord].length();
        correctGuesses = LETTER_SPACE.repeat(chosenWordLength);
    }

    @Override public void runHangMan() {

        printHangMan();
        printLettersGuessed();
        printWordGuesser();

        System.out.println("Now what is your first guess?");

        while (state < 6) {
            String userInput;
            Scanner in = new Scanner(System.in);
            userInput = in.nextLine();

            if (Parser.ifQuit(userInput)) {
                System.out.println("Thank you!! Hope you had flying good time.");
                break;
            }
            if (Parser.ifGuide(userInput)) {
                howToPlay();
            } else if (!Parser.repeatGuess(allGuessedLetters, userInput)) {
                addGuess(userInput);
                printHangMan();
                printLettersGuessed();
                printWordGuesser();
            } else {
                System.out.println("you've already guessed this before");
                System.out.println("now try something else");
                System.out.println("___________________________________");
            }

            if (!Parser.checkCorrectGuess(correctGuesses)) {
                System.out.println("Woahhhh you got it!!");
                break;
            }
            System.out.println("give me your next guess");
        }

        // once state = 6, game ends in failure.
        if (state == 6) {
            printHangMan();
            System.out.println();
            System.out.println("Oh noo!! It seems you have lost   :( ");
        }
    }
    public int getNumberOfLettersGuessed() {
        return numberOfLettersGuessed;
    }
    public ArrayList<String> getAllGuessedLetters() {
        return allGuessedLetters;
    }
    /*
    public static String getChosenWord() {
        return chosenWord;
    }
    public static int getChosenWordLength() {
        return chosenWordLength;
    }
     */
    public int getState() {
        return state;
    }

    /**
     * Takes the chosen word from the word bank and prints the appropriate
     * number of lines for each letter.
     */
    public void printWordGuesser() {
        char[] charCorrectGuesses = correctGuesses.toCharArray();
        for (int i = 0; i < chosenWordLength; i++) {
            System.out.print(" " + charCorrectGuesses[i]);
        }
        System.out.println();
    }

    /**
     * Prints the HangMan image to represent the number of chances left to guess
     */
    public void printHangMan() {
        state = getState();
        switch(state) {
        case 0:
            System.out.println("  _______");
            System.out.println("  |     |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("==============");
            break;
        case 1:
            System.out.println("  _______");
            System.out.println("  |     |");
            System.out.println("  |     @");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("==============");
            break;
        case 2:
            System.out.println("  _______");
            System.out.println("  |     |");
            System.out.println("  |     @");
            System.out.println("  |     |");
            System.out.println("  |     |");
            System.out.println("  |");
            System.out.println("==============");
            break;
        case 3:
            System.out.println("  _______");
            System.out.println("  |     |");
            System.out.println("  |     @");
            System.out.println("  |    /|");
            System.out.println("  |     |");
            System.out.println("  |");
            System.out.println("==============");
            break;
        case 4:
            System.out.println("  _______");
            System.out.println("  |     |");
            System.out.println("  |     @");
            System.out.println("  |    /|\\");
            System.out.println("  |     |");
            System.out.println("  |");
            System.out.println("==============");
            break;
        case 5:
            System.out.println("  _______");
            System.out.println("  |     |");
            System.out.println("  |     @");
            System.out.println("  |    /|\\");
            System.out.println("  |     |");
            System.out.println("  |    /");
            System.out.println("==============");
            break;
        case 6:
            System.out.println("  _______");
            System.out.println("  |     |");
            System.out.println("  |     @");
            System.out.println("  |    /|\\");
            System.out.println("  |     |");
            System.out.println("  |    / \\");
            System.out.println("==============");
            break;
        default:
            System.out.println("default");
            break;
        }

    }

    public void printLettersGuessed() {
        System.out.println("These are the guesses you have made so far:");
        int numOfLetters = getNumberOfLettersGuessed();
        for (int index = 0; index < numOfLetters; index++) {
            String letterToDisplay = getAllGuessedLetters().get(index);
            System.out.print(letterToDisplay + "  ");
        }
        System.out.println();
    }

    public void addGuess(String userInput) {
        System.out.println("Checking to see if [" + userInput + "] is part of the word...");
        int guessType = Parser.parseGuess(userInput);
        if (guessType == 1) { // input is a single character
            allGuessedLetters.add(userInput);
            numberOfLettersGuessed += 1;
            if (chosenWord.contains(userInput)) { // if guess is correct
                String tempWord = chosenWord;
                char[] charCorrectGuesses = correctGuesses.toCharArray();
                int lastSearchedIndex = 0;
                while (tempWord.indexOf(userInput,lastSearchedIndex) != -1) {
                    lastSearchedIndex = tempWord.indexOf(userInput,lastSearchedIndex);
                    charCorrectGuesses[lastSearchedIndex] = userInput.charAt(0);
                    lastSearchedIndex++;
                }
                correctGuesses = String.valueOf(charCorrectGuesses);
            } else {
                state += 1;
            }
        }
    }

    @Override public void howToPlay() {
        super.howToPlay();
        System.out.println("\t- Hangman is a word guessing game played by yourself.");
        System.out.println("\t- There is a SECRET word which you would have to guess.");
        System.out.println("\t- You will have to guess letter by letter within 7 tries. Else, you lose!!"
                            + System.lineSeparator());
        System.out.println("Commands for the game:");
        System.out.println("\t- To guess a letter, simply type in an alphabet.");
        System.out.println("\t- If it is correct, the letter will be shown.");
        System.out.println("\t- A list of guessed letters will be indicated at the top as well.\""
                            + System.lineSeparator());
        System.out.println("Lets put your english to the test! Best of luck :D");
        System.out.println("----------------------------------------------------");
    }
}
