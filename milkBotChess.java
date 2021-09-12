import javax.swing.*;

public class milkBotChess {
	
	// create array of board with pieces
	// lower case = black pieces
	// upper case = white pieces
	// r = rook, k = knight, b = bishop, q = queen, a = king, p = pawn
	// (1234q) = row 1, column 2 moves to row 3, column 4 and captured q
	// a space at the end instead of a piece would mean no capture
			
	static String chessBoard[][] = {
					{"r","k","b","q","a","b","k","r"},
			        {"p","p","p","p","p","p","p","p"},
			        {" "," "," "," "," "," ","P"," "},
			        {" "," "," "," "," "," "," "," "},
			        {" "," "," "," "," "," "," "," "},
			        {" "," "," "," "," "," "," "," "},
			        {"P","P","P","P","P","P","P","P"},
			        {"R","K","B","Q","A","B","K","R"}};

	public static void main(String[] args) {
		
		
		
		/* 
		// create window for board
		JFrame f=new JFrame("MilkBot Chess");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// call user interface
		userInterface ui=new userInterface();
		
		// add user interface to window
		f.add(ui);
		f.setSize(500, 500);
		f.setVisible(true); */
		

	}
	
	// goes through every position on board
	public static String possibleMoves() {
		String list="";
		for(int i=0; i<64; i++) {
			switch (chessBoard[i/8][i%8]) {
			case "P": list+=possibleP(i);
				break;
			case "R": list+=possibleR(i);
				break;
			case "K": list+=possibleK(i);
				break;
			case "B": list+=possibleB(i);
				break;
			case "Q": list+=possibleQ(i);
				break;
			case "A": list+=possibleA(i);
				break;
			
			}
		}
		
		return ""; // x1,y1, x2, y2, captured piece
	}
	
	// adds possible moves to a list for each piece
	public static String possibleP(int i) {
		String list="";
		return list; 
	}
	public static String possibleR(int i) {
		String list="";
		return list; 
	}public static String possibleK(int i) {
		String list="";
		return list; 
	}public static String possibleB(int i) {
		String list="";
		return list; 
	}public static String possibleQ(int i) {
		String list="";
		return list; 
	}public static String possibleA(int i) {
		String list="";
		return list; 
	}
	
}
