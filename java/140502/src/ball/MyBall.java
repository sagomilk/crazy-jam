package ball;
import java.awt.*;

//2

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

class MyPanel extends Panel implements Runnable{
	int x = 30;
	int y = 30;
	public void paint(Graphics g) {
		g.fillOval(x, y, 20, 20);
	}
	
	public void run() {

		while (true) {
			y++;
			if (y > 400) {
				y = 0;
			}
			
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				
			}
			repaint();
		}
		
	}
}