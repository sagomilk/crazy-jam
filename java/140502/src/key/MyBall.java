package key;
/**
 * 控制小球4个方向移动
 * @version 2
 */
import java.awt.*;
import java.awt.event.*;

public class MyBall {
	public static void main(String[] args) {
		Frame w = new Frame();
		w.setSize(400, 300);
		
		MyPanel mp = new MyPanel();
		w.add(mp);
		
		w.addKeyListener(mp);
		mp.addKeyListener(mp);
		
		w.show();
	}
}

class MyPanel extends Panel implements KeyListener {
	int x = 30;
	int y = 30;
	public void paint(Graphics g) {
		g.fillOval(x, y, 100, 100);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
		int keyCode = e.getKeyCode();
		if (keyCode == 37) {
			x--;
			
			if (x < 0) {
				x = 0;
			}
		}
		
		if (keyCode == 38) {
			y--;
			
			if (y < 0) {
				y = 0;
			}
		}
		
		if (keyCode == 39) {
			x++;
			
			if (x > 300) {
				x = 300;
			}
		}
		
		if (keyCode == 40) {
			y++;
			
			if (y > 200) {
				y = 200;
			}
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
	}
}
