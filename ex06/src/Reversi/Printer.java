package Reversi;
import GeneralDef.*;;

public interface Printer {

	void printBoard();

	void printNextPlayerMove(Player p, Vector<Point> v);

	void printLastMove(Player player, Point point);

	void printEndOfGame(Player p, status status1);

	void printError(possible_outcome outcome);

	void printMenu();

	void printInformingGameStarted(owner currentOwner);

	void printWaitingForOtherPlayer(owner currentOwner);

	void printMessage(string s);
}
