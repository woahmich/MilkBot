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
			        {" "," "," "," "," "," "," "," "},
			        {" "," "," "," "," "," ","b"," "},
			        {" "," "," "," "," "," "," "," "},
			        {" "," "," "," ","A"," "," "," "},
			        {"P","P","P","P","P","P","P","P"},
			        {"R","K","B","Q"," ","B","K","R"}};
	
	// C is for capitol and L is for lower case
	static int kingPositionC, kingPositionL;

	public static void main(String[] args) {
		// searches for king's position and updates it
		while(!"A".equals(chessBoard[kingPositionC/8][kingPositionC%8])) {kingPositionC++;}
		while(!"a".equals(chessBoard[kingPositionL/8][kingPositionL%8])) {kingPositionL++;}
		
		
		
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
		System.out.println(possibleMoves());
		

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
		
		return list; // x1, y1, x2, y2, captured piece
	}
	
	// adds possible moves to a list for each piece
	public static String possibleP(int i) {
		String list="";
		return list; 
	}
	
	public static String possibleR(int i) {
		String list="", oldPiece;
		int r=i/8, c=i%8;
		int temp = 1;
		for (int j= -1; j<=1; j+=2) {
			// check vertical
			try {
				while(" ".equals(chessBoard[r][c+temp*j])) {
					oldPiece=chessBoard[r][c+temp*j];
					// set former position to blank
					chessBoard[r][c]=" ";
					// set new position to rook
					chessBoard[r][c+temp*j]="R";
					// check if king is in check
					if(kingSafe()) {
						list=list+r+c+r+(c+temp*j) + oldPiece;
					}
					// reset positions
					chessBoard[r][c]="R";
					chessBoard[r][c+temp*j]=" ";
					temp++;
				}
				if(Character.isLowerCase(chessBoard[r][c+temp*j].charAt(0))) {
					oldPiece=chessBoard[r][c+temp*j];
					// set former position to blank
					chessBoard[r][c]=" ";
					// set new position to rook
					chessBoard[r][c+temp*j]="R";
					// check if king is in check
					if(kingSafe()) {
						list=list+r+c+r+(c+temp*j) + oldPiece;
					}
					// reset positions
					chessBoard[r][c]="R";
					chessBoard[r][c+temp*j]=" ";
				}
			}
			catch (Exception e) {}
			temp=1;
			// check horizontal
			try {
				while(" ".equals(chessBoard[r+temp*j][c])) {
					oldPiece=chessBoard[r+temp*j][c];
					// set former position to blank
					chessBoard[r][c]=" ";
					// set new position to rook
					chessBoard[r+temp*j][c]="R";
					// check if king is in check
					if(kingSafe()) {
						list=list+r+c+(r+temp*j)+c + oldPiece;
					}
					// reset positions
					chessBoard[r][c]="R";
					chessBoard[r+temp*j][c]=" ";
					temp++;
				}
				if(Character.isLowerCase(chessBoard[r+temp*j][c].charAt(0))) {
					oldPiece=chessBoard[r+temp*j][c];
					// set former position to blank
					chessBoard[r][c]=" ";
					// set new position to rook
					chessBoard[r+temp*j][c]="R";
					// check if king is in check
					if(kingSafe()) {
						list=list+r+c+(r+temp*j)+c + oldPiece;
					}
					// reset positions
					chessBoard[r][c]="R";
					chessBoard[r+temp*j][c]=" ";
				}
			}
			catch (Exception e) {}
			temp=1;
		}
		return list; 
	}
	
	public static String possibleK(int i) {
		String list="", oldPiece;
        int r=i/8, c=i%8;
        for (int j=-1; j<=1; j+=2) {
            for (int k=-1; k<=1; k+=2) {
                try {
                    if (Character.isLowerCase(chessBoard[r+j][c+k*2].charAt(0)) || " ".equals(chessBoard[r+j][c+k*2])) {
                        oldPiece=chessBoard[r+j][c+k*2];
                        chessBoard[r][c]=" ";
                        if (kingSafe()) {
                            list=list+r+c+(r+j)+(c+k*2)+oldPiece;
                        }
                        chessBoard[r][c]="K";
                        chessBoard[r+j][c+k*2]=oldPiece;
                    }
                } catch (Exception e) {}
                try {
                    if (Character.isLowerCase(chessBoard[r+j*2][c+k].charAt(0)) || " ".equals(chessBoard[r+j*2][c+k])) {
                        oldPiece=chessBoard[r+j*2][c+k];
                        chessBoard[r][c]=" ";
                        if (kingSafe()) {
                            list=list+r+c+(r+j*2)+(c+k)+oldPiece;
                        }
                        chessBoard[r][c]="K";
                        chessBoard[r+j*2][c+k]=oldPiece;
                    }
                } catch (Exception e) {}
            }
        }
        return list;
    }
    public static String posibleB(int i) {
        String list="", oldPiece;
        int r=i/8, c=i%8;
        int temp=1;
        for (int j=-1; j<=1; j+=2) {
            for (int k=-1; k<=1; k+=2) {
                try {
                    while(" ".equals(chessBoard[r+temp*j][c+temp*k]))
                    {
                        oldPiece=chessBoard[r+temp*j][c+temp*k];
                        chessBoard[r][c]=" ";
                        chessBoard[r+temp*j][c+temp*k]="B";
                        if (kingSafe()) {
                            list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                        }
                        chessBoard[r][c]="B";
                        chessBoard[r+temp*j][c+temp*k]=oldPiece;
                        temp++;
                    }
                    if (Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0))) {
                        oldPiece=chessBoard[r+temp*j][c+temp*k];
                        chessBoard[r][c]=" ";
                        chessBoard[r+temp*j][c+temp*k]="B";
                        if (kingSafe()) {
                            list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                        }
                        chessBoard[r][c]="B";
                        chessBoard[r+temp*j][c+temp*k]=oldPiece;
                    }
                } catch (Exception e) {}
                temp=1;
            }
        }
        return list; 
	}
	
	public static String possibleB(int i) {
		// almost the exact same as queen with a couple tweaks
		String list="", oldPiece;
		int r=i/8, c=i%8;
		int temp=1;
		// += 2 instead of ++ because it makes sure j and k don't become 0
		// because 0 means horizontal movement
		for(int j=-1; j<=1; j+=2) {
			for(int k=-1; k<=1; k+=2) {
				try {
					while(" ".equals(chessBoard[r+temp*j][c+temp*k])) {
						oldPiece=chessBoard[r+temp*j][c+temp*k];
						// sets bishops original position to empty
						chessBoard[r][c]=" ";
						// updates new position to a bishop
						chessBoard[r+temp*j][c+temp*k]="B";
						// check if king is in check
						if(kingSafe()) {
							list=list+r+c+(r+temp*j)+(c+temp*k) + oldPiece;
						}
						// reset bishop's position
						chessBoard[r][c]="B";
						// reset other position
						chessBoard[r+temp*j][c+temp*k]=oldPiece;
						temp++;
					}
					// check if piece can get captured
					if(Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0))) {
						oldPiece=chessBoard[r+temp*j][c+temp*k];
						// sets bishop's original position to empty
						chessBoard[r][c]=" ";
						// updates new position to a bishop
						chessBoard[r+temp*j][c+temp*k]="B";
						// check if king is in check
						if(kingSafe()) {
							list=list+r+c+(r+temp*j)+(c+temp*k) + oldPiece;
						}
						// reset bishop's position
						chessBoard[r][c]="B";
						// reset other position
						chessBoard[r+temp*j][c+temp*k]=oldPiece;
					}
				}
				catch (Exception e) {}
				temp = 1;
			}
		}
		return list; 
	}
	
	public static String possibleQ(int i) {
		String list="", oldPiece;
		int r=i/8, c=i%8;
		int temp=1;
		for(int j=-1; j<=1; j++) {
			for(int k=-1; k<=1; k++) {
				if(j!=0 || k!=0) {
					try {
						while(" ".equals(chessBoard[r+temp*j][c+temp*k])) {
							oldPiece=chessBoard[r+temp*j][c+temp*k];
							// sets queens original position to empty
							chessBoard[r][c]=" ";
							// updates new position to a queen
							chessBoard[r+temp*j][c+temp*k]="Q";
							// check if king is in check
							if(kingSafe()) {
								list=list+r+c+(r+temp*j)+(c+temp*k) + oldPiece;
							}
							// reset queen's position
							chessBoard[r][c]="Q";
							// reset other position
							chessBoard[r+temp*j][c+temp*k]=oldPiece;
							temp++;
						}
						// check if piece can get captured
						if(Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0))) {
							oldPiece=chessBoard[r+temp*j][c+temp*k];
							// sets queens original position to empty
							chessBoard[r][c]=" ";
							// updates new position to a queen
							chessBoard[r+temp*j][c+temp*k]="Q";
							// check if king is in check
							if(kingSafe()) {
								list=list+r+c+(r+temp*j)+(c+temp*k) + oldPiece;
							}
							// reset queen's position
							chessBoard[r][c]="Q";
							// reset other position
							chessBoard[r+temp*j][c+temp*k]=oldPiece;
						}
					}
					catch (Exception e) {}
					temp = 1;
				}
			}
		}
		return list; 
	}
	
	public static String possibleA(int i) {
		
		String list="", oldPiece;
		int r=i/8, c=i%8;
		for(int j=0; j<9; j++) {
			if(j!=4) {
				
				try {

					if(Character.isLowerCase(chessBoard[r-1+j/3][c-1+j%3].charAt(0)) || " ".equals(chessBoard[r-1+j/3][c-1+j%3])) {
						oldPiece=chessBoard[r-1+j/3][c-1+j%3];
						// make king's old position a blank, update king's new position
						chessBoard[r][c]=" ";
						chessBoard[r-1+j/3][c-1+j%3]="A";
						int kingTemp=kingPositionC;
						kingPositionC=i+(j/3)*8+j%3-9;
						// check if kings move is legal (does it put king in check?)
						if(kingSafe()) {
							list=list+r+c+(r-1+j/3)+(c-1+j%3) + oldPiece;
						}
						// return king to original position after checking new one
						chessBoard[r][c]="A";
						chessBoard[r-1+j/3][c-1+j%3]=oldPiece;
						kingPositionC=kingTemp;

					}
				} catch(Exception e) {}
			}
		}
		// still need to add castling
		return list; 
	}
	
	// method to check if King is in check
	public static boolean kingSafe() {
		// bishop and queen diagonal
		int temp=1;
		for(int j=-1; j<=1; j+=2) {
			for(int k=-1; k<=1; k+=2) {
				try {
					while(" ".equals(chessBoard[kingPositionC/8+temp*j][kingPositionC%8+temp*k])) {temp++;} 
					if("b".equals(chessBoard[kingPositionC/8+temp*j][kingPositionC%8+temp*k]) || ("q".equals(chessBoard[kingPositionC/8+temp*j][kingPositionC%8+temp*k]))){
						return false;
					}
				}
				catch (Exception e) {}
				temp = 1;
			}
		}
		
		// rook and queen horizontal/vertical
		temp=1;
		for(int j=-1; j<=1; j+=2) {
			try {
				while(" ".equals(chessBoard[kingPositionC/8][kingPositionC%8+temp*j])) {temp++;} 
				if("r".equals(chessBoard[kingPositionC/8][kingPositionC%8+temp*j]) || ("q".equals(chessBoard[kingPositionC/8][kingPositionC%8+temp*j]))){
					return false;
				}
			}
			catch (Exception e) {}
			temp = 1;
			
			try {
				while(" ".equals(chessBoard[kingPositionC/8+temp*j][kingPositionC%8])) {temp++;} 
				if("r".equals(chessBoard[kingPositionC/8+temp*j][kingPositionC%8]) || ("q".equals(chessBoard[kingPositionC/8+temp*j][kingPositionC%8]))){
					return false;
				}
			}
			catch (Exception e) {}
			temp = 1;
		}
		return true;
	}
	
}
