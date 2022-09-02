package JavaCode;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Controller {
	int x = 0;
    int y = 330;
	int xa = 0;
    int ya = 0;
	private Game game;

	public Controller(Game game) {
		this.game= game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth()-60)
			x = x + xa;
        if (y + ya > 0 && x + ya < game.getHeight()-60)
            y = y + ya;
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, 30, 30);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
		while (! (329 < y) && (331 >y)) {
			ya = 2;
			y += ya;
		}
		ya = 0;


	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A)
			xa = -1;
		if (e.getKeyCode() == KeyEvent.VK_D)
			xa = 1;
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            ya = -1;
	}
}
