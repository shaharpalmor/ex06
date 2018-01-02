package Reversi;

import java.util.Vector;

public class GameState {
	
	private Board board;
	Vector <Point> vec1;
	Vector <Point> vec2;
	public GameState(Board board) {
		this.board = board;
	}
	
	public GameState(GameState gameState) {
	    //creates a new board like the board of the game state we get.
	    board = new Board(gameState.board);
	    
	    // creating the same vectors of the options of the player as the game state parameter.
	    for (int i = 0; i < gameState.vec1.size(); i++) {
	        Point pointToBeAdded = new Point(gameState.vec1.elementAt(i));
	        vec1.addElement(pointToBeAdded);
	    }

	    for (int i = 0; i < gameState.vec2.size(); i++) {
	        Point *pointToBeAdded = new Point(*gameState.vec2.at(i));
	        vec2.push_back(pointToBeAdded);
	    }

	}
	
	

}
