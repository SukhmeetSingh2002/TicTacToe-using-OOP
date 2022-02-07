import java.util.Scanner;

public class TicTacToe {
    public static void playComputer(Player p1, Computer p2, Grid mainGame, Scanner inputScanner) {
        while (mainGame.isWin(p2.getSymbol()) == 0) {

            // taking player 1 input

            while (!mainGame.markPosition(p1.nextMove(inputScanner), p1.getSymbol()));
            mainGame.displayMainGrid();

            // check player 1 won
            if (mainGame.isWin(p1.getSymbol()) == 1) {
                p1.declareWon();
                break;
            }

            // computers turn
            if (mainGame.isWin(p2.getSymbol()) == 0) {
                int posChoosen = p2.nextMove(inputScanner, mainGame, p1.getSymbol());
                System.out.println("Computer choosed : " + posChoosen);
                mainGame.displayMainGrid();
            }

            // check player 2 won
            if (mainGame.isWin(p2.getSymbol()) == 1) {
                p2.declareWon();
                break;
            }
        }
    }

    public static void playHuman(Player p1, Player p2, Grid mainGame, Scanner inputScanner) {
        while (mainGame.isWin(p2.getSymbol()) == 0) {

            // taking player 1 input

            while (!mainGame.markPosition(p1.nextMove(inputScanner), p1.getSymbol()));
            mainGame.displayMainGrid();

            // check player 1 won
            if (mainGame.isWin(p1.getSymbol()) == 1) {
                p1.declareWon();
                break;
            }

            // taking player 2 input
            if (mainGame.isWin(p2.getSymbol()) == 0) {

                while (!mainGame.markPosition(p2.nextMove(inputScanner), p2.getSymbol()));
                mainGame.displayMainGrid();
            }

            // check player 2 won
            if (mainGame.isWin(p2.getSymbol()) == 1) {
                p2.declareWon();
                break;
            }
        }
    }

    public static void main(String[] args) {
        // scanner and grid
        Grid mainGame = new Grid();
        Scanner inputScanner = new Scanner(System.in);

        // human or computer
        System.out.println("Welcome to TicTacToe.");
        System.out.println("Player 1 is represented by 'X' and Player 2 by 'O'");
        System.out.println("The cells in the grid are numbered from 1-9 as follows ");
        mainGame.previewGrid();
        System.out.println("Player can enter cell number to fill it.");
        System.out.println(
                "The first one to make 3 cells in row,column or diagonal is a winner, otherwise game ends in a tie.");
        System.out.print("Do you want to play with computer(1) or human(2): ");
        int againtComputer = inputScanner.nextInt();

        Player p1 = new Player('X');
        System.out.print("Enter name of Player 1 : ");

        inputScanner.nextLine();
        p1.setName(inputScanner.nextLine());

        if (againtComputer == 1) {
            Computer p2 = new Computer('O');
            mainGame.displayMainGrid();
            playComputer(p1, p2, mainGame, inputScanner);
        } else if (againtComputer == 2) {
            Player p2 = new Player('O');
            System.out.print("Enter name Of Player 2 : ");
            p2.setName(inputScanner.nextLine());
            mainGame.displayMainGrid();
            playHuman(p1, p2, mainGame, inputScanner);
        } else {
            System.out.println("'" + againtComputer + "' is a invalid choice");
        }

        inputScanner.close();
        if (mainGame.isWin(p1.getSymbol()) == 2) {
            System.out.println("This game is a draw");
        }
    }

}