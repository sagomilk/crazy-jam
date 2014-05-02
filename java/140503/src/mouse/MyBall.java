package mouse;

import java.awt.*;
import java.awt.event.*;

public class MyBall {
	public static void main(String[] args) {
		Frame w = new Frame();
		w.setSize(400, 300);
		
		MyPanel mp = new MyPanel();
		w.add(mp);
		
		Thread t = new Thread(mp);
		t.start();
		
		mp.addMouseListener(mp);
		mp.addMouseMotionListener(mp);
		
		w.show();
	}
}


class MyPanel extends Panel implements MouseListener, MouseMotionListener, Runnable {
	int x = 30;
	int y = 30;
	boolean isMoving = false;
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x-25, y-25, 50, 50);
	}
	
	public void run() {
		while (true) {
			repaint();
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// pass
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mousePressed");
		isMoving = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseReleased end");
		isMoving = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (isMoving) {
			x = e.getX() < 350 ? e.getX() : 350;
			y = e.getY() < 250 ? e.getY() : 250;			
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}