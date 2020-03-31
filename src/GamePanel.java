import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	public static GamePanel instance = null;

	public static final int PWIDTH = 640; // size of panel
	public static final int PHEIGHT = 600;
	private Thread animator; // for the animation
	private boolean running = false; // stops the animation

	private Graphics2D dbg;
	private int FPS, SFPS;
	private long CurrentSecond = 0;
	private long NewSecond = 0;
 

	private Canvas gui = null;
	private BufferStrategy strategy = null;

	public GamePanel() {
		instance = this;

		setBackground(Color.white); // white background
		setPreferredSize(new Dimension(PWIDTH, PHEIGHT));

		gui = new Canvas();
		gui.setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		add(gui, BorderLayout.CENTER);

		setFocusable(true); // create game components
		requestFocus(); // JPanel now receives key events

		// Add KeyListner
		gui.addKeyListener(new KeyAdapter() {
			// listen for esc, q, end, ctrl-c
			public void keyPressed(KeyEvent e) {
	 
			}

			public void keyReleased(KeyEvent e) {
	 
			}
		});
		
		// Add MouseWheelListener
		gui.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
		 
				
			}
		});
		
		// Add MouseMotionListener
		gui.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) { 
			 
			}
			
			@Override
			public void mouseDragged(MouseEvent e) { 
			 
			}
		});
		 
		// Add MouseListener
		gui.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			 
			}
			
			public void mouseReleased(MouseEvent e) {
				 
			}
			
			public void mouseExited(MouseEvent e) {
			 
			}
			
			public void mouseEntered(MouseEvent e) {
				 
			}
			
			public void mouseClicked(MouseEvent e) {
			 
			}
		});


	} // end of GamePanel()


	public void addNotify() {
		super.addNotify(); // creates the peer
		startGame(); // start the thread
	}

	private void startGame()
	// initialise and start the thread
	{
		if (animator == null || !running) {
			animator = new Thread(this);
			animator.start();
		}
	} // end of startGame()

	public void stopGame()
	// called by the user to stop execution
	{
		running = false;
	}

	public void run()
	/* Repeatedly update, render, sleep */
	{
		running = true;

		long diffTime, oldTime;

		diffTime = 0;
		oldTime = System.currentTimeMillis();
		CurrentSecond = (long) (oldTime / 1000);

		gui.createBufferStrategy(2);
		strategy = gui.getBufferStrategy();

		while (running) {

			dbg = (Graphics2D) strategy.getDrawGraphics();
			dbg.setClip(0, 0, PWIDTH, PHEIGHT);
			dbg.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			gameUpdate(diffTime);
			gameRender();

			dbg.dispose();
			strategy.show();

			try {
				Thread.sleep(1); // sleep a bit
			} catch (InterruptedException ex) {
			}

			diffTime = System.currentTimeMillis() - oldTime;
			oldTime = System.currentTimeMillis();
			NewSecond = (long) (oldTime / 1000);

			if (NewSecond != CurrentSecond) {
				FPS = SFPS;
				CurrentSecond = NewSecond;
				SFPS = 1;
			} else {
				SFPS++;
			}

		}
		System.exit(0); // so enclosing JFrame/JApplet exits
	} // end of run()

	private void gameUpdate(long diffTime) {
		// update game elements
	 
	}

	private void gameRender()
	// draw the current frame to an image buffer
	{
		// clear the background
		dbg.setColor(Color.black);
		dbg.fillRect(0, 0, PWIDTH, PHEIGHT);
		
		// draw game elements
		
		// draw FPS
		dbg.setColor(Color.WHITE);
		dbg.drawString("FPS: " + FPS, 20, 20);
		
		
		

	} // end of gameRender()

	public static void main(String args[]) {
		GamePanel ttPanel = new GamePanel();

		// create a JFrame to hold the timer test JPanel
		JFrame app = new JFrame("Game Core");
		app.getContentPane().add(ttPanel, BorderLayout.CENTER);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		app.pack();
		app.setResizable(false);
		app.setVisible(true);
	} // end of main()

	
	public BufferedImage loadImage(String filename) {

		try {
			BufferedImage imgtmp = ImageIO.read(getClass().getResource(filename));
			BufferedImage imgfinal = new BufferedImage(imgtmp.getWidth(), imgtmp.getHeight(),
					BufferedImage.TYPE_INT_ARGB);
			imgfinal.getGraphics().drawImage(imgtmp, 0, 0, null);
			return imgfinal;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

} // end of GamePanel class
