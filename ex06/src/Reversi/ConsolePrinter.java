package Reversi;

import java.util.Vector;

import GeneralDef.Owner;
import GeneralDef.Possible_OutCome;
import GeneralDef.Status;

public class ConsolePrinter implements Printer {

	Board board;
	Player player1; // A reference to player 1 from GameManager.
	Player player2; // A reference to player 2 from GameManager.

	@Override
	public void printBoard() {
		int row = board.getRow();
		int col = board.getCol();

		System.out.println("Current board: \n");

		// Print the numbers of the columns.
		System.out.print(" |");
		for (int i = 1; i <= col; i++)
			System.out.print(' ' + i + " |");

		System.out.println();

		// Print a line of commas.
		printCommas();

		// Print each line of the board.
		for (int i = 0; i < row; i++) {
			printLine(i);
		}

	}

	private void printCommas() {
		int col = board.getCol();

		System.out.print("--");
		// Print commas as separators
		for (int i = 0; i < col; i++)
			System.out.print("----");

		System.out.println();
	}

	private void printLine(int currentRow) {
		int col = board.getCol();

		// Print the number of the row at the start
		int printRow = currentRow + 1;
		System.out.print(printRow + '|');

		for (int currentCol = 0; currentCol < col; currentCol++) {
			Point p = new Point(currentRow, currentCol);

			Owner symbolToCheck = board.getCell(p).getSymbol();

			if (symbolToCheck == Owner.PLAYER_1)
				System.out.println(' ' + player1.getSymbol() + " |");
			else if (symbolToCheck == Owner.PLAYER_2)
				System.out.println(' ' + player2.getSymbol() + " |");
			else
				System.out.print("   |");

		}
		System.out.println();

		printCommas();
	}

	@Override
	public void printNextPlayerMove(Player p, Vector<Point> v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printLastMove(Player player, Point point) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printEndOfGame(Player p, Status status1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printError(Possible_OutCome outcome) {
		 switch (outcome) {
	        case OUT_OF_BOUND: printOutOfBound();
	            break;
	        case ILLEGAL_MOVE : printIllegalMove();
	            break;
	        case OCCUPIED_CELL : printOccupiedCell();
	            break;
	        default:
	            break;
	    }

	}

	@Override
	public void printMenu() {
		System.out.println("Welcome to Reversi Game! :)");
		System.out.println();
		System.out.println("Choose an opponent type:");
		System.out.println("1. a human local player");
		System.out.println("2. an AIPlayer");
		System.out.println("3. a remote player");
	}

	@Override
	public void printInformingGameStarted(Owner currentOwner) {
		if(currentOwner == Owner.PLAYER_1){
			System.out.println("Game started!");
	        System.out.println();
	    }
	    else{
	    	System.out.println("Game started, waiting for player #1 move");
	    	System.out.println();
	    }

	}

	@Override
	public void printWaitingForOtherPlayer(Owner currentOwner) {
		if (currentOwner == Owner.PLAYER_1) {
			System.out.println("Waiting for Player #2 move");
			System.out.println();
		} else {
			System.out.println("waiting for player #1 move");
			System.out.println();
		}

	}

	@Override
	public void printMessage(String s) {
		System.out.println(s);
	}

}
