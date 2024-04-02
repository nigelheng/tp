# AeroCade User Guide

## Introduction

AeroCade is an In-Flight Entertainment app designed to keep users entertained during travels, 
optimized for use via a Command Line Interface (CLI) while still having the core functionalities and features.

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Down the latest version of `AeroCade.jar` from [here](http://link.to/duke).
3. Copy the file to the folder you want to use as the home folder for your (name).
4. Open a command terminal, cd into the folder you put the jar file in, and use the java -jar (name).jar command to run the application.
5. Type commands in the CLI and press Enter to execute it. (E.g. type and enter 'help' for a list of available commands)
6. Refer to the Features below for details of each command.

## Features

### 1. Playing a game of `TicTacToe`

Example of usage: 
 * To start game, type`TTT`.
 * Pick a box in the grid to occupy by choosing number `1/2/3/4/5/6/7/8/9`.
```
  1 | 2 | 3
-------------
  4 | 5 | 6    
-------------
  7 | 8 | 9    
```
### 2. Playing a game of `Hangman`

Example of usage:
 * To start a game, type `hangman`.
 * Guess a letter in the secret word by typing in the letter 
```
_______
|     |
|
|
|
|
==============
```
## FAQ

**Q**: Where can I find a guide on understanding the game? 

**A**: Open a game with `TTT` or `hangman` and open the game guide with `guide`.

## Command Summary

* See list of commands in menu: `help`
* See guide on game: `guide`
* To quit a game anytime: `quit`
