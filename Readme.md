# TicTacToe Using OOP in JAVA

## Game Instructions
This game can be played in a 2 player version or against computer.

- *Player 1* is first to move.
- *Player 2* can be computer or another player.
- *Player 1* is represented by *X* and *Player 2* by *O*.
- The first one to make 3 cells in row,column or diagonal is a winner
- If none makes it then game is declared draw.

## How to Play
- Enter *1* to play with computer and *2* to play with another player
- Enter the names of the player(s)
- Cells in the grid are numbered from 1-9 and each player can choose the numbr to mark his/her cell.


## How to run 

Run the following 2 commands to play the game

```
javac TicTacToe.java
```
```
java TicTacToe
```

## Brief Implementaion Details 
Game comtaions the following classes

- Player.class
- Computer.class
- Grid.class

*Computer class* is a subclass of *Player class*. 
Onlu difference is in the *next move* method.Computer moves the next move defensively. If in current move computer can win then it will choose that position otherwise if in next move Player can win Computer will block that position. Otherwise computer will mark in a cell nearby an already marked cell. Thus computer plays effectively.