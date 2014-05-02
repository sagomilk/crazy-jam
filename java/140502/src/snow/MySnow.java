package snow;

import java.awt.*;
/*
 * 漫天的雪花飘落2
 */

public class MySnow {
	public static void main(String[] args) {
		Frame w = new Frame();
		w.setSize(800, 600);
		w.setBackground(Color.BLACK);
		
		MyPanel mp = new MyPanel();
		w.add(mp);
		
		Thread t = new Thread(mp);
		t.start();
		
		w.show();
	}
}

class MyPanel extends Panel implements Runnable {
	int[] x = new int[300];
	int[] y = new int[300];
	
	public MyPanel() {
		for (int i = 0; i < 300; i++) {
			x[i] = (int)(800*Math.random());
			y[i] = (int)(600*Math.random());
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		
		for (int i = 0; i < 300; i++) {
			g.drawString("*", x[i], y[i]);
		}
	}
	
	public void run() {
		while (true) {
			for (int i = 0; i < 300; i++) {
				y[i]++;
				
				if (y[i] > 600) {
					y[i] = 0;
				}
			}
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// pass
			}
			
			repaint();
		}
	}
}