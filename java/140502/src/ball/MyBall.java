package ball;
import java.awt.*;

//4

public class MyBall {
	public static void main(String[] args) {
		Frame w = new Frame();
		w.setSize(300, 500);
		
		MyPanel mp = new MyPanel();
		w.add(mp);
		
		Thread t = new Thread(mp);
		t.start();
		
		w.show();
	}
}

class MyPanel extends Panel implements Runnable {
	int x = 30;
	int y = 30;
	int att = 0;
	Color color = Color.BLACK;
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 30, 30);
	}
	
	public void run() {
		while (true) {
			if (x > 260) {
				if (att == 0) {
					att = 1;
				} else {
					att = 2;
				}
			}
			
			if (y > 460) {
				if (att == 1) {
					att = 2;
				} else {
					att = 3;
				}
			}
			
			if (x < 0) {
				if (att == 2) {
					att = 3;
				} else {
					att = 0;
				}
			}

			if (y < 0) {
				if (att == 3) {
					att = 0;
				} else {
					att = 1;
				}
			}
			if (att == 0) {
				color = Color.RED;
				x++;
				y++;
			}
			
			if (att == 1) {
				color = Color.BLUE;
				x--;
				y++;
			}
			
			if (att == 2) {
				color = Color.GREEN;
				x--;
				y--;
			}
			
			if (att == 3) {
				color = Color.PINK;
				x++;
				y--;
			}
			
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				
			}
			
			repaint();
		}
	}
}