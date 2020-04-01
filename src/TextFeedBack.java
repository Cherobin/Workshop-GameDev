import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class TextFeedBack extends Sprite {

	int time;
	int timeAlive;
	boolean isAlive;
	String text;
	int sizeFont;
	Font myFont; 
	
	public TextFeedBack(String text, float x, float y) {
		time = 0;
		timeAlive = 300;
		isAlive = true;
		this.text = text;
		this.x = x;
		this.y = y;
		sizeFont = 12;
		myFont = new Font("Serif", Font.BOLD, sizeFont);
	}
	
	@Override
	public void gameUpdate(long diffTime) {
		// TODO Auto-generated method stub
		time += diffTime;
		if(time%10 == 0) {
			sizeFont+=1f;
			myFont = new Font("Serif", Font.BOLD, sizeFont);
		}
		
		if(time > timeAlive) {
			isAlive = false;
		}
		
	}

	@Override
	public void gameRender(Graphics2D dbg) {
		// TODO Auto-generated method stub
		
		dbg.setFont(myFont);
		dbg.setColor(Color.WHITE);
		dbg.drawString(text, x, y);
		
		dbg.setColor(Color.YELLOW);
		dbg.drawString(text, x+1, y+1);
		
		
	}

}
