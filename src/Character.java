import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Character extends Sprite{
 
	
	public boolean LEFT, RIGHT, UP, DOWN, SHIFT, SPACE;
	
	int velX, velY;
	int initLife;
	int life;
	boolean isAlive;
	ArrayList<Shot> shots;
	
	float timeShot;
	long timer;
	
	public int score;
	
	public Character(float x, float y, BufferedImage img, ArrayList<Shot> shots) {
		this.x = x;
		this.y = y;
		this.img = img;
		this.sizeX = img.getWidth();
		this.sizeY = img.getHeight();
		velX = velY = 100;
		initLife = life = 100;
		isAlive = true;
		this.shots = shots;
		timeShot = 300;
		score = 0;
		
	}
	
	@Override
	public void gameUpdate(long diffTime) {
		
		timer += diffTime;
		
		if(LEFT) {
			x -= velX * diffTime/1000.0f;
		}
		
		if(RIGHT) {
			x += velX * diffTime/1000.0f;
		}
		
		if(UP) {
			y -= velY * diffTime/1000.0f;
		}
		
		if(DOWN) {
			y += velY * diffTime/1000.0f;
		}
		
		if(SPACE && timer > timeShot) {
			timer = 0;
			Shot shot = new Shot(x + (sizeX/2 - 2), y, -100);
			shots.add(shot);
		}
		
		if(life <= 0) {
			isAlive = false;
		}
		
	}

	@Override
	public void gameRender(Graphics2D dbg) {
		// TODO Auto-generated method stub
		dbg.drawImage(img, null, (int)x, (int)y); 
		dbg.setColor(Color.blue);
		dbg.fillRect((int) x, (int) y + 40, (40*life/100), 10);
	}

}
