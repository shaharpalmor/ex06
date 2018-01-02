package Reversi;

public interface Player {
	
	public char getSymbol();
	public Point getMove(GameState gameState);
}
