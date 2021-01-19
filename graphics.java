import java.awt.BorderLayout; //utsidan
import java.awt.Graphics; //grafiken
import java.awt.Point; // sätta y,x kordinater
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; // ta emot vart musen är
import java.awt.event.MouseMotionAdapter; // tar emot mouseevent

import javax.swing.JFrame; //support för swing, extended av java.awt
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class graphics extends JPanel {
	
	private Point lastPoint;
	
	public graphics() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				lastPoint = new Point(e.getX(),e.getY());
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Graphics g = getGraphics();
				g.drawLine(lastPoint.x, lastPoint.y, e.getX(), e.getY());
				g.dispose();
				
			}
		});
	}
	
	public static void main (String args[]) {
		JFrame frame = new JFrame("Great Graphcis program");
		frame.getContentPane().add(new graphics(), BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setVisible(true);
		
	}
	
}


