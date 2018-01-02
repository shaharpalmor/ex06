package Reversi;

public class Main {
	public static void main (String[] args){
		Board board = new Board(8,8);
		HumanPlayer player1 = new HumanPlayer('x');
		HumanPlayer player2 = new HumanPlayer('o');
		GameState gameState = new GameState(board);
		ReversiDefaultRules rules = new ReversiDefaultRules();
		ConsolePrinter printer = new ConsolePrinter();
		GameManager gameManager = new GameManager(board, player1, player2, printer, rules, false);
		
		gameManager.run();
	}
}
