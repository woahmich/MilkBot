// graphics
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class userInterface extends JPanel implements MouseListener, MouseMotionListener{
	// x and y are global variables
	static int x = 0, y = 0;
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.yellow);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		g.setColor(Color.blue);
		g.fillRect(x-20, y-20, 40, 40);
		g.setColor(new Color(190, 81, 215));
		g.fillRect(40,  20, 80, 50);
		g.drawString("MilkBot", x, y);
		
		// create image for the pieces and links it to saved picture
		Image chessPieceImage;
		chessPieceImage = new ImageIcon("ChessPieces.png").getImage();
		g.drawImage(chessPieceImage, x, 0, x+120, y+100, 100, x, x+100, 100, this);
		
	}
	// must call all of these MouseListeners as blanks if not used to clear userInterface warning
	// idk what override does but it makes the IDE happy
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
