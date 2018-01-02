package Reversi;

import GeneralDef.Owner;

public class Board {

	private int row;
	private int col;
	private Cell[][] matrix;

	Board(int row, int col) {
		this.row = row;
		this.col = col;

		matrix = new Cell[row][col];
		for (int i = 0; i < row; i++) 
			for (int j = 0; j < col; j++) 
				this.matrix[i][j] = new Cell();
		
		initBoard();
	}
	
	public void initBoard() {
	    // Initialize all the board with no owners.
	    for (int i = 0; i < row; i++) 
	        for (int j = 0; j < col; j++) 
	            matrix[i][j].setSymbol(Owner.NONE);
	        
	    // Set the center of the board with the 2 players.
	    matrix[(row / 2) - 1][(col / 2) - 1].setSymbol(Owner.PLAYER_2);
	    matrix[(row / 2) - 1][(col / 2)].setSymbol(Owner.PLAYER_1);
	    matrix[(row / 2)][(col / 2)].setSymbol(Owner.PLAYER_2);
	    matrix[(row / 2)][(col / 2) - 1].setSymbol(Owner.PLAYER_1);

	}

}
