import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;

public class CanvasMain extends MyCanvas {

	private boolean LEFT, RIGHT, UP, DOWN, SHIFT, SPACE;

	private ArrayList<Enemy> enemies;
	public ArrayList<Shot> shots;
	public ArrayList<TextFeedBack> texts;

	public ArrayList<Estrelinha> estrelinhas;

	Character heroi = null;

	public CanvasMain() {

		shots = new ArrayList<Shot>();

		texts = new ArrayList<TextFeedBack>();

		estrelinhas = new ArrayList<Estrelinha>();

		heroi = new Character(420, 550, GamePanel.instance.heroiImage, shots);
		enemies = new ArrayList<Enemy>();

		createEnemies();

		//createEstrelinhas();

	}

	public void createEstrelinhas() {

		//TODO ahsduhuasd arrumar
		
		int x = 10;
		int y = 8;
		
		
		
		for (int i = 0; i < GamePanel.PHEIGHT + 800; i+=50) {
			for (int j = 0; j < GamePanel.PWIDTH + 600; j+=30) {
				x = j;
				Estrelinha estrela = new Estrelinha(x, y);
				estrelinhas.add(estrela);
			}
			y = i;

		}

	}

	public void createEnemies() {

		Random rnd = GamePanel.instance.rnd;

		for (int i = 0; i < 40; i++) {
			int size = rnd.nextInt(30) + 20;

			Enemy my = new Enemy(rnd.nextInt(GamePanel.PWIDTH), rnd.nextInt(GamePanel.PHEIGHT) - 800, size, size,
					new Color(rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat()), rnd.nextInt(50) + 50,
					rnd.nextInt(50) + 50, shots, rnd.nextInt(50), heroi, texts);
			enemies.add(my);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
			LEFT = true;
		}

		if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
			RIGHT = true;
		}

		if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
			UP = true;
		}

		if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
			DOWN = true;
		}

		if (keyCode == KeyEvent.VK_SHIFT) {
			SHIFT = true;
		}

		if (keyCode == KeyEvent.VK_SPACE) {
			SPACE = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
			LEFT = false;
		}

		if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
			RIGHT = false;
		}

		if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
			UP = false;
		}

		if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
			DOWN = false;
		}

		if (keyCode == KeyEvent.VK_SHIFT) {
			SHIFT = false;
		}

		if (keyCode == KeyEvent.VK_SPACE) {
			SPACE = false;
		}
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
		heroi.LEFT = LEFT;
		heroi.RIGHT = RIGHT;
		heroi.SHIFT = SHIFT;
		heroi.DOWN = DOWN;
		heroi.UP = UP;
		heroi.SPACE = SPACE;

		if (heroi.isAlive) {
			heroi.gameUpdate(diffTime);
		} else {
			// TODO GAME_OVER
		}

		for (int i = 0; i < estrelinhas.size(); i++) {
			estrelinhas.get(i).gameUpdate(diffTime);
		}
		
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if (enemy.isAlive) {
				enemy.gameUpdate(diffTime);
			} else {
				heroi.score += enemy.score;
				enemies.remove(enemy);
				i--;
			}
		}

		for (int i = 0; i < shots.size(); i++) {
			Shot shot = shots.get(i);
			if (shot.isAlive) {
				shot.gameUpdate(diffTime);
			} else {
				shots.remove(shot);
				i--;
			}
		}

		for (int i = 0; i < texts.size(); i++) {
			TextFeedBack text = texts.get(i);
			if (text.isAlive) {
				text.gameUpdate(diffTime);
			} else {
				texts.remove(text);
				i--;
			}
		}

		gameOver();
	}

	void gameOver() {
		if (!heroi.isAlive) {
			GamePanel.instance.canvasDraw = new CanvasGameOver(heroi.score);
		}
	}

	@Override
	public void gameRender(Graphics2D dbg) {
		// TODO Auto-generated method stub
		
		dbg.drawImage(GamePanel.instance.background, 0, 0, GamePanel.instance.background.getWidth() , GamePanel.instance.background.getHeight(), null);
	
		
		heroi.gameRender(dbg);

		for (int i = 0; i < estrelinhas.size(); i++) {
			estrelinhas.get(i).gameRender(dbg);
		}
		
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).gameRender(dbg);
		}

		for (int i = 0; i < shots.size(); i++) {
			shots.get(i).gameRender(dbg);
		}

		for (int i = 0; i < texts.size(); i++) {
			texts.get(i).gameRender(dbg);
		}

		dbg.setFont(new Font("Serif", Font.BOLD, 12));

		dbg.setColor(Color.white);
		dbg.drawString("SCORE: " + heroi.score, 600, 20);

	}

}
