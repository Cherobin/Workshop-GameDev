import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class CanvasGameOver extends MyCanvas{

	int score;
	
	public CanvasGameOver(int score) {
		this.score = score;
	}
	
	Font myFont = new Font("Serif", Font.BOLD, 40);
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_R) {
			GamePanel.instance.canvasDraw = new CanvasMain();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameUpdate(long diffTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameRender(Graphics2D dbg) {
		// TODO Auto-generated method stub
		
		
		dbg.setFont(myFont);
		
		dbg.setColor(Color.WHITE);
		dbg.drawString("Score:" + score, 200, 300);
		
		dbg.setColor(Color.WHITE);
		dbg.drawString("Press R to Restart", 200, 350);
		
		dbg.setColor(Color.WHITE);
		dbg.drawString("GAME OVER", 200, 400);
		
		dbg.setColor(Color.YELLOW);
		dbg.drawString("GAME OVER", 200, 400);
		
		
	}

}
