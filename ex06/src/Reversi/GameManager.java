package Reversi;

public class GameManager {

	protected GameState gameState;
	protected Player player1; // Reference to player 1.
	protected Player player2; // Reference to player 2.
	protected Printer printer; // Reference to the printer.
	protected GameRules gameRules; // Reference to the game rules with the game logic.
	protected Player currentPlayer; // Pointer to the current player.
	protected boolean firstRun; // Boolean switch if it's the first turn.
	protected Point lastMove; // Pointer to the last player move, NULL if there isn't one.
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
	    this.isAIPlayer = aiPlayer;
	}
	
	
}
