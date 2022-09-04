package JavaCode;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Game extends JPanel {

	// Instantiating the player (ball)
	Controller controller = new Controller(this);
	// Instantiating the ground
	Ground ground = new Ground(this);


	public Game() {
		// Adding key listener to constructor. 
		// This allows for user input.
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				controller.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				controller.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	// Game loop, simply calling the method for the player to move.
	private void move() {
		controller.move();
	}

	// Overriding the paint method.
	// Super.paint is needed since we repaint every 10 miliseconds.
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		// Painting the ground and the player.
		controller.paint(g2d);
		ground.paint(g2d);
	}

	// Simple Game Over screen
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	// Creating the JFrame
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("ADfastpages Game");
		// New Game Object
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// The game loop. Causes the progression of things in the game.
		while (true) {
			game.move();
			game.repaint();
			// Things aren't updated every frame. They are updated every 10 ms.
			Thread.sleep(10);
		}
	}
}
