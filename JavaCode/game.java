package JavaCode;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class game extends JPanel {


	int x = 0;
	int y = 330;
	int xa = 1;

	private void moveBall() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > getWidth() - 30)
			xa = -1;
		
		x = x + xa;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillOval(x, y, 30, 30);

	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		game game = new game();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.moveBall();
			game.repaint();
			Thread.sleep(10);
		}
	}
}
