package Reversi;

import GeneralDef.*;
import java.util.Scanner;

public class GameManager {

	protected GameState gameState;
	protected Player player1; // Reference to player 1.
	protected Player player2; // Reference to player 2.
	protected Printer printer; // Reference to the printer.
	protected GameRules gameRules; // Reference to the game rules with the game
									// logic.
	protected Player currentPlayer; // Pointer to the current player.
	protected boolean firstRun; // Boolean switch if it's the first turn.
	protected Point lastMove; // Pointer to the last player move, NULL if there
								// isn't one.
	protected boolean isAIPlayer; // True if the second player is AIPlayer.

	public GameManager(GameState gameState, Player player1, Player player2, Printer printer, GameRules gameRules,
			boolean isAIPlayer) {
		this.gameState = gameState;
		this.player1 = player1;
		this.player2 = player2;
		this.printer = printer;
		this.gameRules = gameRules;
		this.isAIPlayer = isAIPlayer;

		this.currentPlayer = player1;
		this.lastMove = null;
		this.firstRun = true;
		this.isAIPlayer = isAIPlayer;
	}

	public Owner getWinner() {
		int p1Counter = 0, p2Counter = 0;
		int row = gameState.getBoard().getRow();
		int col = gameState.getBoard().getCol();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Point p = new Point(i, j);
				if (gameState.getBoard().getCell(p).getSymbol() == Owner.PLAYER_1)
					p1Counter++;
				else
					p2Counter++;
			}
		}
		if (p1Counter > p2Counter)
			return Owner.PLAYER_1;

		if (p1Counter < p2Counter)
			return Owner.PLAYER_2;

		return Owner.NONE;
	}

	public Status checkStatus() {
		gameRules.makePossibleMoves(gameState, Owner.PLAYER_1);
		gameRules.makePossibleMoves(gameState, Owner.PLAYER_2);

		boolean isFirstEmpty = gameState.vec1.isEmpty();
		boolean isSecondEmpty = gameState.vec2.isEmpty();

		if (gameState.getBoard().isBoardFull() || (isFirstEmpty && isSecondEmpty)) {
			Owner result = getWinner();
			if (result == Owner.NONE)
				return Status.DRAW;
			else
				return Status.WIN;
		}

		return Status.RUNNING;
	}

	public void run() {
	    Status status1 = checkStatus();

	    while (status1 == Status.RUNNING) {
	        playOneTurn();
	        if (currentPlayer == player1) 
	            currentPlayer = player2;
	         else 
	            currentPlayer = player1;
	        
	        status1 = checkStatus();
	    }

	    printer.printBoard();
	    printer.printLastMove(currentPlayer, lastMove);

	    if (checkStatus() == Status.WIN) {
	        Owner winner = getWinner();
	        if (winner == Owner.PLAYER_1)
	            printer.printEndOfGame(player1, status1);

	        if (winner == Owner.PLAYER_2)
	            printer.printEndOfGame(player2, status1);

	        char dummy;
			Scanner scanIn = new Scanner(System.in);
	        dummy = scanIn.next().charAt(0);
	    }

	    if (status1 == Status.DRAW)
	        printer.printEndOfGame(player1, Status.DRAW);

	}

}
