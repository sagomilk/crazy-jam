package ballfall;

import java.awt.Graphics;

import javax.swing.*;

public class MyBall {
	public static void main(String[] args) {
		JFrame w = new JFrame();
		w.setSize(400, 300);
		
		MyPanel mp = new MyPanel();
		w.add(mp);
		
		Thread t = new Thread(mp);
		t.start();
		
		
		w.setVisible(true);
	}
}

class MyPanel extends JPanel implements Runnable {
	int x = 30;
	int y = 30;
	
	public void paint(Graphics g) {
		super.paint(g);
		g.fillOval(x, y, 20, 20);
	}
	
	public void run() {
		while (true) {
			y++;
			
			if (y > 300) {
				y = 0;
			}
			
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				//pass
			}
			
			repaint();
		}
	}
}
