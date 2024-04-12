# Jackie Neo - Project Portfolio Page

### Project:  AeroCade

AeroCade is an In-Flight Entertainment app designed to keep users entertained during travels,
optimized for use via a Command Line Interface (CLI) while still having the core functionalities and features.

Given below are my contributions to the project.
 
### Ui Component

- **Ui Class:** Contains 6 methods that work with the other classes `Render.java` and `TimerTutorial.java`. These 
methods are extracted to display various types of messages and art. These include `greetUser()`, 
`quitUser()`, `printHelp()`, `printTTTTutorial()`, `printHangmanTutorial()`, and `println()`
  - `greetUser()` and `quitUser()` displays the greetings and _randomised_ farewells, including art.
  - `printHelp()` prints the descriptive help message.
  - `printTTTTutorial()` and `printHangmanTutorial()` displays a gameplay tutorial of each game, displaying a frame 
    every 4 seconds.
  -  `println()` is a simple and convenient method to call for other classes.


- **Render Class:** Contains all the art and messages that are called in `Ui.java`


- **TimerTutorial Class** Contains two display methods `displayTTTTutorial()` and `displayHangmanTutorial()` which 
displays every frame of the tutorial, and a schedule method `scheduleTutorialFrames(frames, interval)` is used to 
`run()` a frame every 4 seconds.

### Contributions

[Full RepoSense Contributions here.](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=jackie&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2024-02-23&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

**Enhancements to existing features:**

* Made 5 pull requests for debugging purposes, ensuring Gradle CheckStyles and I/O redirection tests passed successfully
* Included assertions and exceptions in the main `Duke.java`, ensuring no NullPointer Exceptions during testing.

**Contributions to Developer Guide and User Guide:**
* Added the Ui implementation section to both Developer Guide and User Guide

**Review/mentoring contributions:**
* Links to PRs reviewed, instances of helping team members in other ways.

**Contributions beyond the project team:**
* Evidence of helping others e.g. responses you posted in our forum, bugs you reported in other team's products,
* Evidence of technical leadership e.g. sharing useful information in the forum
