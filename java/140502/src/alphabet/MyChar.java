package alphabet;

import java.awt.*;
import java.awt.event.*;

public class MyChar {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Frame w = new Frame();
		w.setBackground(Color.BLACK);
		w.setSize(300, 400);
		
		MyPanel mp = new MyPanel();
		w.add(mp);
		
		Thread t = new Thread(mp);
		t.start();
		
		w.addKeyListener(mp);
		mp.addKeyListener(mp);
		
		w.show();
	}
}

class MyPanel extends Panel implements Runnable, KeyListener {
	int[] x = new int[10];
	int[] y = new int[10];
	char[] c = new char[10];
	int sum = 0;
	int life = 10;
	
	public MyPanel() {
		for (int i = 0; i < 10; i++) {
			x[i] = (int)(280*Math.random());
			y[i] = (int)(200*Math.random());
			c[i] = (char) (65 + (int)(26*Math.random()));
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		
		for (int i = 0; i < life; i++) {
			g.drawString("*", 35+10*i, 20);
		}
		
		for (int i = 0; i < 10; i++) {
			g.drawString(new Character(c[i]).toString(), x[i], y[i]);
		}
		
		g.setColor(Color.RED);
		g.drawString("生命:", 5, 20);
		g.drawString("分数:", 230, 20);
		g.drawString(Integer.toString(sum), 270, 20);
		
		if (life == 0) {
			g.drawString("GAME OVER", 110, 200);
		}
		
	}
	
	public void run() {
		while (true && life > 0) {
			for (int i = 0; i < 10; i++) {
				y[i]++;
				
				if (y[i] > 370) {
					life--;
					c[i] = (char)(65 + 26*Math.random());
					y[i] = (int) (100*Math.random());
				}
			}
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// pass
			}
			
			repaint();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		System.out.println(keyCode);

		int maxIndex = -1;
		int maxY = -1;
		for (int i = 0; i < 10; i++) {
			if (c[i] == keyCode) {
				if (y[i] > maxY) {
					maxY = y[i];
					maxIndex = i;
				}
			}
		}
		
		if (maxIndex != -1) {
			System.out.println("bingo"+keyCode);
			x[maxIndex] = (int) (280*Math.random());
			y[maxIndex] = (int) (50*Math.random());;
			c[maxIndex] = (char) (65 + (int)(26*Math.random()));
			sum++;
		} else {
			sum--;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
