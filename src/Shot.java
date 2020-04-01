import java.awt.Color;
import java.awt.Graphics2D;
 

public class Shot extends Sprite {

	int velY;

	boolean isAlive;
	int damage;
	public Shot(float x, float y, int velY) {
		this.x = x;
		this.y = y;
		this.velY = velY;
		sizeX = 4;
		sizeY = 4;
		isAlive = true;
		damage = 50;
		
	}

	@Override
	public void gameUpdate(long diffTime) {
		// TODO Auto-generated method stub
		
		y += velY * diffTime / 1000.0f;

		if (y > GamePanel.PHEIGHT || y + sizeY < 0) {
			isAlive = false;
		}

	}

	@Override
	public void gameRender(Graphics2D dbg) {
		// TODO Auto-generated method stub
		dbg.setColor(Color.BLUE);
		dbg.fillRect((int) x, (int) y, sizeX, sizeY);

	}

}
