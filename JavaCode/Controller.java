package JavaCode;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;


public class Controller {
	int x = 0;
    int y = 300;
	int vx = 0;
    int vy = 1;
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;
	private Game game;

	Obstacle obstacle = new Obstacle(game);


	public Controller(Game game) {
		this.game= game;
	}

	public void move() {
		if (x + vx > 0 && x + vx < game.getWidth()-60)
			x = x + vx;
        if (y + vy > 0 && x + vy < game.getHeight()-60)
            y = y + vy;
		if (collisionObstacle()) {
			game.gameOver();
		}
		if (y < game.getHeight() / 2) {
			if (collisionGround()) {
				vy = -1;
			}
		}
		else {
			if (collisionGround()) {
				vy = 0;
			}
			else {
				vy = 1;
			}

		}

	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, WIDTH, HEIGHT);
		obstacle.paint(g, 100);

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		vx = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A)
			vx = -2;
		if (e.getKeyCode() == KeyEvent.VK_D)
			vx = 2;
		if (vy == 0) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
				do {
					y = y - 1;
				} 
				while (y > 250);
				vy = -1;
		}

	}

	private boolean collisionGround() {
		return game.ground.getBounds().intersects(getBounds());
	}

	private boolean collisionObstacle() {
		return this.obstacle.getBounds().intersects(getBounds());
	}

	


}
