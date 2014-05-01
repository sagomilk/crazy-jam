import java.awt.*;

// 6



public class MyTest {
	public static void main(String[] args){
		Frame w = new Frame();
		w.setSize(300, 400);
		
		MyPanel mp = new MyPanel();
		w.add(mp);
		
		w.show();
	}
}

class MyPanel extends Panel {
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval(30, 30, 50, 20);
		g.drawLine(10, 10, 400, 400);
	}
}

