package JavaCode;

import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Obstacle {

	// Rererence to the game object.
	private Game game;
    private static final int WIDTH = 20;
	private static final int HEIGHT = 20;
    private int localx = 60;
	

	public Obstacle(Game game) {
		this.game= game;
	}

	// Paint method used to displat the ground.
	public void paint(Graphics2D g, int x) {
        localx = x;
		g.fillRect(localx, 325, WIDTH, HEIGHT);
	}

	// Setting up a collider to detect collision.
	public Rectangle getBounds() {
		return new Rectangle(localx, 325, WIDTH, HEIGHT);
	}


}
