// 5
import java.awt.*;

public class MyTest {
	public static void main(String[] args) {
		Frame w = new Frame();		
		w.setSize(200, 300);
		
		MyPanel mp = new MyPanel();
		w.add(mp);
		
		w.show();
	}
}

class MyPanel extends Panel {
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval(20, 20 ,100, 100);
		g.drawLine(20, 20, 300, 300);
	}
}