import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Sprite {
	
	public float x, y;
	public int sizeX, sizeY;
	public BufferedImage img;
	
	public abstract void gameUpdate(long diffTime);
	public abstract void gameRender(Graphics2D dbg);
}
