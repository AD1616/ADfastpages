package JavaCode;

import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Ground {

	// Rererence to the game object.
	private Game game;
	private static final int HEIGHT = 30;
	

	public Ground(Game game) {
		this.game= game;
	}

	// Paint method used to displat the ground.
	public void paint(Graphics2D g) {
		g.fillRect(0, game.getHeight() - 30, game.getWidth(), 30);
	}

	// Setting up a collider to detect collision.
	public Rectangle getBounds() {
		return new Rectangle(0, game.getHeight() - 30, game.getWidth(), HEIGHT);
	}


}
