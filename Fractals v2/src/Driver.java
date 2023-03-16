import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener {

	/* Attributes a.k.a. Instance Variables */
	int w = 800, h = 800;

	public void paint(Graphics g) {
		super.paintComponent(g);
		rings(g,150,0);
		clover(g, 200, 400, 0);
		clover2(g, 200, 600, 0);
		clover3(g, 200, 400, 200);
		clover4(g, 200, 600, 200);
		squares(g,133,200,600);
		triangles(g,400,600,600);


		//rings(g, 200, 300, 400);
		

	}// end of paint method - put code above for anything dealing with drawing -
	public void rings(Graphics g, int r, int degree) {
		int center = 200-r/2;
		int yOffset =  (int) (r/2*Math.sin(degree*Math.PI/180));
		int xOffset =  (int) (r/2*Math.cos(degree*Math.PI/180));
		g.drawOval(center+xOffset, center-yOffset, r, r);
		
		if (degree != 350) {
			rings(g,150,degree+10);
		}
//		if(x != 350) {
//			rings(g, radius, x+10, y-10 );
//		}
		
	}

	public void clover(Graphics g, int radius, int x, int y) {
		//top left
		g.drawOval(x, y, radius, radius);
		
		
		if(radius > 1) {
			clover(g, radius-10, x+10, y+10);
			
		}
		//top right
		
		
	}
	public void clover2(Graphics g, int radius, int x, int y) {
		//top left
		g.drawOval(x, y, radius, radius);
		
		
		if(radius > 1) {
			clover2(g, radius-10, x, y+10);
			
		}
		//top right
		
		
	}
	public void clover3(Graphics g, int radius, int x, int y) {
		//top left
		g.drawOval(x, y, radius, radius);
		
		
		if(radius > 1) {
			clover3(g, radius-10, x+10, y);
			
		}
		//top right
		
		
	}
	public void clover4(Graphics g, int radius, int x, int y) {
		//top left
		g.drawOval(x, y, radius, radius);
		
		
		if(radius > 1) {
			clover4(g, radius-10, x, y);
			
		}
		//top right
		
		
	}
	public void triangles(Graphics g, int side, int x, int y) {
		g.setColor(Color.BLACK);
		int centerx = x-side/2;
		int centery = y-side/2;
		g.drawPolygon(new int[] {centerx+side/2,centerx,centerx+side}, new int[] {centery, centery+side, centery+side}, 3);
		
		if (side > 3) {
			triangles(g,side/2,x,y-side/4);
			triangles(g,side/2,(int) (x-side/4),y+side/4);
			triangles(g,side/2,(int) (x+side/4),y+side/4);

		}
		
	}

	public void squares(Graphics g, int len, int x, int y) {
		//center = 200,600, starting width = 100
			g.fillRect((int)(x-len*0.5), (int)(y-len*0.5), len, len);
		
			for (int i=0; i<8; i++) {
				int newlen = len/3;
				if (newlen > 1) {
				squares(g, newlen, x+len, y);
				g.setColor(Color.RED);
				squares(g, newlen, x+len, y+len);
				g.setColor(Color.GREEN);
				squares(g, newlen, x+len, y-len);
				g.setColor(Color.BLUE);
				squares(g, newlen, x, y+len);
				g.setColor(Color.YELLOW);
				squares(g, newlen, x, y-len);
				g.setColor(Color.CYAN);
				squares(g, newlen, x-len, y);
				g.setColor(Color.GRAY);
				squares(g, newlen, x-len, y+len);
				g.setColor(Color.PINK);
				squares(g, newlen, x-len, y-len);
				}
			}
	}
	

	/**
	 * Update the positions of the ball and paddle. Update the scores, counter
	 * and time
	 */
	public void update() {

	}// end of update method - put code above for any updates on variable

	// ==================code above ===========================

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	/* Instantiate any attributes here (instance variables */
	public Driver() {

		JFrame f = new JFrame();
		f.setTitle("Pong");
		f.setSize(w, h);
		f.setBackground(Color.BLACK);
		f.setResizable(false);

		f.add(this);
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	Timer t;

}