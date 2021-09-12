import javax.swing.*;

public class milkBotChess {

	public static void main(String[] args) {
		
		// create window for board
		JFrame f=new JFrame("MilkBot Chess");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// call user interface
		userInterface ui=new userInterface();
		
		// add user interface to window
		f.add(ui);
		f.setSize(500, 500);
		f.setVisible(true);
		

	}

}
