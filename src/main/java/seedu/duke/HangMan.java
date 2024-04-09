package seedu.duke;
import seedu.duke.exceptions.InvalidTTMoveException;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The HangMan class is a child class of Game
 * Class handles the running of the hangman game, its interfaces and interaction with inputs by user
 */
public class HangMan extends Game {
    protected String[] wordBank;
    protected ArrayList<String> allGuessedLetters = new ArrayList<>();
    protected ArrayList<String> wordsFromCategory = new ArrayList<>();
    protected int numberOfLettersGuessed = 0;
    protected String chosenWord;
    protected int chosenWordLength;
    protected String correctGuesses;
    protected int state = 0;
    protected final String LETTER_SPACE = "_";


    public HangMan(String line) {
        super(line);
        String words = "ant baboon badger bat bear beaver camel cat clam cobra cougar coyote crow deer dog donkey " +
                "duck eagle ferret fox frog goat goose hawk lion lizard llama mole monkey moose mouse mule newt " +
                "otter owl panda parrot pigeon python rabbit ram rat raven rhino salmon seal shark sheep skunk swan " +
                "snake spider stork sloth tiger toad trout turkey turtle weasel whale wolf wombat zebra afghanistan " +
                "argentina australia austria angola bangladesh belgium bolivia brazil brunei bulgaria cambodia " +
                "canada chad chile china colombia croatia cuba denmark ecuador egypt estonia ethiopia finland " +
                "france germany guinea haiti hungary iceland india indonesia iran iraq ireland israel italy jamaica " +
                "japan kenya korea laos latvia lebanon luxembourg malaysia maldives mexico mongolia morocco myanmar " +
                "nepal netherlands nigeria norway pakistan peru philippines poland portugal qatar romania russia " +
                "serbia singapore spain sudan sweden switzerland syria taiwan thailand turkey uganda ukraine " +
                "uzbekistan venezuela vietnam yemen zambia zimbabwe acai apple apricot avocado banana blackberry " +
                "blackcurrant blueberry boysenberry breadfruit cherry coconut cranberry date dragonfruit durian " +
                "elderberry fig grape raisin grapefruit guava jackfruit jujube kiwi kumquat lemon lime longan " +
                "lychee mango mangosteen cantaloupe honeydew watermelon mulberry orange mandarine tangerine papaya " +
                "passionfruit peach pear persimmon plum prune pineapple pomegranate pomelo raspberry rambutan " +
                "soursop strawberry tamarind yuzu tomato eggplant pumpkin cheerleading canoeing kayaking rafting " +
                "rowing dragonboat waterpolo swimming diving archery baseball softball cricket basketball netball " +
                "soccer rugby tchoukball hockey floorball lacrosse polo curling badminton pickleball tennis " +
                "volleyball squash skating surfing wakeboarding bouldering cycling aikido judo sumo wrestling " +
                "boxing capoeira kickboxing silat taekwondo kendo kungfu frisbee gymanastic running";

        wordBank = words.split(" ",251);
        switch(line) {
        case "animals":
            wordsFromCategory.addAll(Arrays.asList(wordBank).subList(0, 63));
            break;
        case "countries":
            wordsFromCategory.addAll(Arrays.asList(wordBank).subList(64, 145));
            break;
        case "fruits":
            wordsFromCategory.addAll(Arrays.asList(wordBank).subList(146, 203));
            break;
        case "sports":
            wordsFromCategory.addAll(Arrays.asList(wordBank).subList(204, 250));
            break;
        default:
            break;
        }
        Random rand = new Random();
        int whichWord = rand.nextInt(wordsFromCategory.size());
        chosenWord = wordsFromCategory.get(whichWord);
        chosenWordLength = chosenWord.length();
        correctGuesses = "";
        for (int i = 0; i < chosenWordLength; i++) {
            correctGuesses += LETTER_SPACE;
        }
    }

    @Override public void runGame() {

        printHangMan();
        printLettersGuessed();
        printWordGuesser();

        ui.println("Now what is your first guess? (\'guide\' for a guide on how to play Hangman!)");
        ui.println(Ui.LINE);

        while (state < 6) {
            String userInput;
            Scanner in = new Scanner(System.in);
            userInput = in.nextLine().trim();

            if (Parser.ifQuit(userInput)) {
                ui.println("Thank you!! Hope you had flying good time.");
                break;
            }
            if (Parser.ifShowGuide(userInput)) {
                howToPlay();
            } else if (userInput.isEmpty()){
                ui.println("but that's nothing :/");
                ui.println(Ui.LINE);
            } else if (!Parser.repeatGuess(allGuessedLetters, userInput)) {
                addGuess(userInput);
                if (!Parser.checkCorrectGuess(correctGuesses)) {
                    ui.println(Ui.LINE);
                    printWordGuesser();
                    ui.println("Woahhhh you got it!!");
                    ui.println(Ui.LINE);
                    break;
                } else {
                    ui.println(Ui.LINE);
                    printHangMan();
                    ui.println(Ui.LINE);
                    printLettersGuessed();
                    printWordGuesser();
                }
            } else {
                ui.println("you've already guessed this before");
                ui.println("now try something else!");
                ui.println(Ui.LINE);
            }

            if (!Parser.checkCorrectGuess(correctGuesses)) {
                ui.println("Woahhhh you got it!!");
                gameWon();
                break;
            }
            ui.println("give me your next guess");
            ui.println(Ui.LINE);
        }

        // once state = 6, game ends in failure.
        if (state == 6) {
            printHangMan();
            ui.println("\nOh noo!! It seems you have lost   :( ");
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
            ui.println("  _______");
            ui.println("  |     |");
            ui.println("  |");
            ui.println("  |");
            ui.println("  |");
            ui.println("  |");
            ui.println("==============");
            break;
        case 1:
            ui.println("  _______");
            ui.println("  |     |");
            ui.println("  |     @");
            ui.println("  |");
            ui.println("  |");
            ui.println("  |");
            ui.println("==============");
            break;
        case 2:
            ui.println("  _______");
            ui.println("  |     |");
            ui.println("  |     @");
            ui.println("  |     |");
            ui.println("  |     |");
            ui.println("  |");
            ui.println("==============");
            break;
        case 3:
            ui.println("  _______");
            ui.println("  |     |");
            ui.println("  |     @");
            ui.println("  |    /|");
            ui.println("  |     |");
            ui.println("  |");
            ui.println("==============");
            break;
        case 4:
            ui.println("  _______");
            ui.println("  |     |");
            ui.println("  |     @");
            ui.println("  |    /|\\");
            ui.println("  |     |");
            ui.println("  |");
            ui.println("==============");
            break;
        case 5:
            ui.println("  _______");
            ui.println("  |     |");
            ui.println("  |     @");
            ui.println("  |    /|\\");
            ui.println("  |     |");
            ui.println("  |    /");
            ui.println("==============");
            break;
        case 6:
            ui.println("  _______");
            ui.println("  |     |");
            ui.println("  |     @");
            ui.println("  |    /|\\");
            ui.println("  |     |");
            ui.println("  |    / \\");
            ui.println("==============");
            break;
        default:
            ui.println("default");
            break;
        }

    }

    public void printLettersGuessed() {
        ui.println("These are the guesses you have made so far:");
        int numOfLetters = getNumberOfLettersGuessed();
        for (int index = 0; index < numOfLetters; index++) {
            String letterToDisplay = getAllGuessedLetters().get(index);
            System.out.print(letterToDisplay + "  ");
        }
        System.out.println();
    }

    public void addGuess(String userInput) {
        ui.println("Checking to see if [" + userInput + "] is part of the word...");
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
        } else if (guessType == 2) { // input is the entire word
            if (userInput.equals(chosenWord)) {
                correctGuesses = chosenWord;
            } else {
                state += 1;
            }
        }
    }

    /**
     * Prints the game guide when 'guide' is inputted
     */
    @Override public void howToPlay() {
        super.howToPlay();
        ui.println("\t- Hangman is a word guessing game played by yourself.");
        ui.println("\t- There is a SECRET word which you would have to guess.");
        ui.println("\t- You will have to guess letter by letter within 7 tries. Else, you lose!!\n");
        ui.println("Commands for the game:");
        ui.println("\t- To guess a letter, simply type in an alphabet.");
        ui.println("\t- If it is correct, the letter will be shown.");
        ui.println("\t- A list of guessed letters will be indicated at the top as well.\n");
        ui.println("Lets put your english to the test! Best of luck :D");
        ui.println(Ui.LINE);
    }
}
