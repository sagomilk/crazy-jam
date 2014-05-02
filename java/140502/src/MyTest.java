import java.awt.*;

// 1
public class MyTest {
	public static void main(String[] args){
		Frame w = new Frame();
		w.setSize(1024, 768);
		w.setBackground(Color.BLACK);
		
		MyPanel mp = new MyPanel();
		w.add(mp);
		
		w.show();
	}
}

class MyPanel extends Panel {
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.drawString("*", 30, 30);
		for (int i = 0; i < 300; i++) {
			g.drawString("*", (int)(1024*Math.random()), (int)(768*Math.random()));
		}
	}
}