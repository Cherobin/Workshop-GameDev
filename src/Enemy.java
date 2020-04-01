import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Enemy extends Sprite {

	Color color;
	int velX, velY;
	int initLife;
	int life;
	public boolean isAlive;
	public ArrayList<Shot> shots;
	public int score;
	Character heroi;
	public ArrayList<TextFeedBack> texts;
	
	public Enemy(float x, float y, int sizeX, int sizeY, Color color, int velX, int velY, ArrayList<Shot> shots, int score, Character heroi, ArrayList<TextFeedBack> texts) {
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.color = color;
		this.velX = velX;
		this.velY = velY;
		this.shots = shots;
		initLife = life = 100;
		isAlive = true;
		this.score = score;
		this.heroi = heroi;
		this.texts = texts;
	}
	
	
	
	@Override
	public void gameUpdate(long diffTime) {
		// TODO Auto-generated method stub
		
		if(x > GamePanel.PWIDTH) {
			x = 0 - sizeX;
		}
		
		
		if(x < 0 - sizeX) {
			x = GamePanel.PWIDTH;
		}
	
		/*
		if(y < 0 - sizeY) {
			y = GamePanel.PHEIGHT;
		}
		*/
		
		if(y > GamePanel.PHEIGHT) {
			y = 0 - sizeY;
		}
		
		y += velY * diffTime / 1000.0f;
		
		for (int i = 0; i < shots.size(); i++) {
			if(Utils.collisionQuad(this, shots.get(i))){
				life -= shots.get(i).damage;
				createText(shots.get(i).damage);
				shots.get(i).isAlive = false;
				
			}
		}
		
		if(Utils.collisionQuad(this, heroi)){
			this.life -= initLife/2;
			createText(initLife/2);
			heroi.life -= heroi.initLife/2;
			heroi.y += sizeY;		
		}
		
		
		if(life <= 0) {
			this.isAlive = false;
		}

		
	}

	private void createText(int value) {
		
		TextFeedBack text = new TextFeedBack("Damage "+ value, x, y);
		texts.add(text);
		
	}
	@Override
	public void gameRender(Graphics2D dbg) {
		// TODO Auto-generated method stub
		dbg.setColor(color);
		dbg.fillOval((int) x, (int) y, sizeX, sizeY);
		
		dbg.setColor(Color.yellow);
		dbg.fillRect((int) x, (int) y - 10, 50, 10);
		
		dbg.setColor(Color.red);
		dbg.fillRect((int) x, (int) y - 10, (50*life/100), 10);
		
	 
	}

}
