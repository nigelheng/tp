# AeroCade User Guide

## Introduction

AeroCade is an In-Flight Entertainment app designed to keep users entertained during travels, 
optimized for use via a Command Line Interface (CLI) while still having the core functionalities and features.

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `AeroCade.jar` from [here](http://link.to/duke).
3. Copy the file to the folder you want to use as the home folder for your (name).
4. Open a command terminal, cd into the folder you put the jar file in, and use the java -jar (name).jar command to run the application.
5. Type commands in the CLI and press Enter to execute it. (E.g. type and enter 'help' for a list of available commands)
6. Refer to the Features below for details of each command.

## Features


### 1. Playing a game of `TicTacToe`

Entering `tutorial` mode: type `TTT tutorial`
* Detailed tutorial showing the gameplay mechanics of how to win TicTacToe.
* Timed aspect of 4 seconds per frame.

Start of TicTacToe tutorial:
```
_________________________________________________________________
[Tutorial Mode is playing, do not input any commands!]
Tutorial Pilot: Good day! this is Tutorial Pilot and I will demonstrate
                a stellar gameplay of TTT for you!

    |   |    
-------------
    |   |    
-------------
    |   |    

Tutorial Pilot: This is a TTT board which I'll be placing an 'X' depending on
                the number I put, here is the numbered layout!
_________________________________________________________________
```

Example of usage: 
 * To start a game, type `TTT`.
 * Choose your difficulty, either `easy` or `hard`, and type it in.
 * Pick a box in the grid to occupy by choosing number `1/2/3/4/5/6/7/8/9`.
 * At any point, if you want to quit, simply type `quit`

```
  1 | 2 | 3
-------------
  4 | 5 | 6    
-------------
  7 | 8 | 9    
```
```
Which opponent do you desire, challenger?
easy
    |   |    
-------------
    |   |    
-------------
    |   |    
_________________________________________________________________
```

```
_________________________________________________________________
Make your move, challenger.
7
  X | O |    
-------------
  X |   | O  
-------------
  X |   | O  
_________________________________________________________________
You have claimed victory over the skies. Godspeed, champion.
_________________________________________________________________
Now what would you like to do?

```

### 2. Playing a game of `Hangman`

Entering `tutorial` mode: type `hangman tutorial`
* Detailed tutorial showing the ideal thought process of playing while showing
the number of mistakes allowed
* Timed aspect of 4 seconds per frame.

Start of Hangman tutorial:
```
_________________________________________________________________
[Tutorial Mode is playing, do not input any commands!]
Tutorial Pilot: Good day! this is Tutorial Pilot and I will demonstrate
                a stellar gameplay of Hangman for you!

_______        
|     |        
|              
|              
|              
|              
============== 
_ _ _ _ _      

Tutorial Pilot: This is the start of the game, for this tutorial, I'll need to
                guess a 5-letter word before the 'hangman' is drawn out, which
                means I can only make 5 wrong guesses! Let's try the letter 'a'
_________________________________________________________________
```

Example of usage:
 * To start a game, type `hangman`.
 * You will be prompted to choose a category between `animals`, `fruits`, `countries` & `sports`
 * Type in one of the 4 categories
 * Guess a letter in the secret word by typing in the letter or if you are confident
 * Guess the whole secret word.

```
_______
|     |
|
|
|
|
==============
These are the guesses you have made so far:

 _ _ _
```
```
_________________________________________________________________
These are the guesses you have made so far:
a  o  i  u  e  b  r  h  
 _ _ o r _
give me your next guess
_________________________________________________________________
  _______
  |     |
  |     @
  |    /|\
  |     |
  |    / \
==============

Oh noo!! It seems you have lost   :( 
Now what would you like to do?

```

## In-Game Guides

**Q**: Where can I find a guide on understanding the game rules? 

**A**: Open a game with `TTT` or `hangman` and open the game guide with `guide`. Below is an example when opening
`guide` while playing `hangman`

````
guide
_________________________________________________________________
Let me explain the rules of this game:
	- Hangman is a word guessing game played by yourself.
	- There is a SECRET word which you would have to guess.
	- You will have to guess letter by letter within 7 tries. Else, you lose!!

Commands for the game:
	- To guess a letter, simply type in an alphabet.
	- If it is correct, the letter will be shown.
	- A list of guessed letters will be indicated at the top as well.

Lets put your english to the test! Best of luck :D
````

**Q**: Where can I learn how to play the game?

**A**: In the main menu on the CLI, start a tutorial with either `TTT tutorial` or `hangman tutorial`. Below is an 
example of the start of a tutorial (frame 1 only) when calling `TTT tutorial`.
````
TTT tutorial
_________________________________________________________________
[Tutorial Mode is playing, do not input any commands!]
Tutorial Pilot: Good day! this is Tutorial Pilot and I will demonstrate
                a stellar gameplay of TTT for you!

    |   |    
-------------
    |   |    
-------------
    |   |    

Tutorial Pilot: This is a TTT board which I'll be placing an 'X' depending on
                the number I put, here is the numbered layout!
_________________________________________________________________
(... More Frames to be shown)
````

## Command Summary

* See list of commands in menu: `help`

* Start a game of Tic-tac-toe: `TTT`
* View Tic-tac-toe tutorial: `TTT tutorial`

* Start a game of Hangman: `hangman`
* View Hangman tutorial: `hangman tutorial`

* See guide on game: `guide`
* To quit a game anytime: `quit`
* To see your number of games won: `stats`
