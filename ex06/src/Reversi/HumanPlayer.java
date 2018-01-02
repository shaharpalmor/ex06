package Reversi;
import java.util.Scanner;

public class HumanPlayer implements Player {
	private char symbol;
	
	
	public HumanPlayer(char s){
		this.symbol = s;
	}
	
	@Override
	public char getSymbol() {
		return this.symbol;
	}

	@Override
	public Point getMove(GameState gameState) {
		int x;
		int y;
		char dummy;
		
		Scanner scanIn = new Scanner(System.in);
		x = scanIn.nextInt();
		dummy  = scanIn.next().charAt(0);
		y = scanIn.nextInt();
		scanIn.close(); 
		return new Point(x,y);
	}

}
