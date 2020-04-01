import java.awt.Color;
import java.awt.Graphics2D;

public class Estrelinha extends Sprite {

	public Estrelinha(float x, float y) {
		this.x = x;
		this.y = y;
		sizeX = 1;
		sizeY = 1;
	}

	@Override
	public void gameUpdate(long diffTime) {
		// TODO Auto-generated method stub
		x += 150 * diffTime / 1000.0f;
		y += 150 * diffTime / 1000.0f;

		if (x > GamePanel.PWIDTH + 600) {
			x = 0 - sizeX;
		}

		if (x < 0 - sizeX) {
			x = GamePanel.PWIDTH + 600;
		}

		if (y < 0 - sizeY) {
			y = GamePanel.PHEIGHT + 800;
		}

		if (y > GamePanel.PHEIGHT + 800) {
			y = 0 - sizeY;
		}

	}

	@Override
	public void gameRender(Graphics2D dbg) {
		// TODO Auto-generated method stub
		dbg.setColor(Color.white);
		dbg.fillRect((int) x, (int) y, sizeX, sizeY);
	}

}
