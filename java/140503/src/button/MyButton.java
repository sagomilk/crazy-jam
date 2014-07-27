package button;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyButton {
	public static void main(String[] args) {
		JFrame w = new JFrame();
		w.setSize(400, 300);
		
		MyPanel mp = new MyPanel();
		w.add(mp);
		
		w.addMouseListener(mp);
		mp.addMouseListener(mp);
		
		w.setVisible(true);
	}
}

class MyPanel extends JPanel implements MouseListener {
	boolean b = true;
	public void paint(Graphics g) {
		super.paint(g);
		if (b) {
			g.setColor(Color.WHITE);
			g.drawLine(30, 30, 80, 30);
			g.drawLine(30, 30, 30, 50);
			g.fillRect(31, 31, 49, 20);
			
			g.setColor(Color.BLACK);
			g.drawLine(30, 50, 80, 50);
			g.drawLine(80, 30, 80, 50);
		} else {
			g.setColor(Color.BLACK);
			g.drawLine(30, 30, 80, 30);
			g.drawLine(30, 30, 30, 50);
			
			g.setColor(Color.WHITE);
			g.drawLine(30, 50, 80, 50);
			g.drawLine(80, 30, 80, 50);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getX() > 30 && e.getX() < 80 && e.getY() > 30 && e.getY() < 50) {
			b = false;
			repaint();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		b = true;
		repaint();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
