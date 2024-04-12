package seedu.duke;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class UiTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printTTTTutorial_displaysTutorialAndIgnoresInput() {
        Ui ui = new Ui(new Render(), new TimerTutorial());

        System.setIn(new java.io.ByteArrayInputStream("random input\n".getBytes()));
        ui.printTTTTutorial();

        // Check if the correct output was printed
        assertTrue(outContent.toString().contains("Tutorial Pilot: Hey! I'm still teaching a tutorial here!"));
    }

    @Test
    public void printHangmanTutorial_displaysTutorialAndIgnoresInput() {
        Ui ui = new Ui(new Render(), new TimerTutorial());

        System.setIn(new java.io.ByteArrayInputStream("random input\n".getBytes()));
        ui.printHangmanTutorial();

        // Check if the correct output was printed
        assertTrue(outContent.toString().contains("Tutorial Pilot: Hey! I'm still teaching a tutorial here!"));
    }

    @Test
    public void println_printsCorrectMessage() {
        Ui ui = new Ui(null, null); // Constructor won't be used to invoke println
        ui.println("Hello world!");

        assertTrue(outContent.toString().contains("Hello world!"));
    }

    @Test
    public void greetUser_displaysCorrectMessage() {
        Ui ui = new Ui(new Render(), new TimerTutorial());
        ui.greetUser();
        assertTrue(outContent.toString().contains(Render.logo));
    }

    @Test
    public void greetUser_displaysLine() {
        Ui ui = new Ui(new Render(), new TimerTutorial());
        ui.printHelp();
        ui.printHangmanTutorial();
        ui.printTTTTutorial();
        assertTrue(outContent.toString().contains(Ui.LINE));
    }

    @Test
    public void quitUser_displaysCorrectMessage() {
        Ui ui = new Ui(new Render(), new TimerTutorial());
        ui.quitUser();
        assertTrue(outContent.toString().contains(Render.boeing));
    }
}

