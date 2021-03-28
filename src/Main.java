import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI(); 
	            }
	        });

	}
	private static void createAndShowGUI() {
        JFrame f = new JFrame("Krzywe Bezier");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    }
}
class MyPanel extends JPanel {
    
    @Override
    public Dimension getPreferredSize() {
    	setValues();
        return new Dimension(500,500);
    }
    double x[][] = new double[7][4];
    double y[][] = new double[7][4];
    double putx;
    double puty;
    
    public void setValues()
    {
    	x[0][0] = 152;
    	  y[0][0] = 258; 
    	x[0][1] = 247;
    	  y[0][1] = 190;
    	x[0][2] = 270;
    	  y[0][2] = 256;
    	x[0][3] = 285;
    	  y[0][3] = 256;
    	
    	
    	x[1][0] = 285;
    	  y[1][0] = 256;
    	x[1][1] = 300;
    	  y[1][1] = 256;
    	x[1][2] = 298;
    	  y[1][2] = 414;
    	x[1][3] = 303;
    	  y[1][3] = 394;
    	  
    	x[2][0] = 303;
    	  y[2][0] = 394;
    	x[2][1] = 307;
    	  y[2][1] = 379;
    	x[2][2] = 274;
    	  y[2][2] = 128;
    	x[2][3] = 260;
    	  y[2][3] = 124;
    	
    	x[3][0] = 260;
    	  y[3][0] = 124;
    	x[3][1] = 227;
    	  y[3][1] = 114;
    	x[3][2] = 65;
    	  y[3][2] = 430;
    	x[3][3] = 56;
    	  y[3][3] = 418;
    	  
    	 x[4][0] = 56;
    	  y[4][0] = 418;
    	x[4][1] = 47;
    	  y[4][1] = 407;
    	x[4][2] = 60;
    	  y[4][2] = 130;
    	x[4][3] = 90;
    	  y[4][3] = 125;
    	  
    	 x[5][0] = 90;
    	  y[5][0] = 125;
    	x[5][1] = 136;
    	  y[5][1] = 117;
    	x[5][2] = 191;
    	  y[5][2] = 130;
    	x[5][3] = 180;
    	  y[5][3] = 184;
    	  
    	 x[6][0] = 180;
    	  y[6][0] = 184;
    	x[6][1] = 177;
    	  y[6][1] = 199;
    	x[6][2] = 94;
    	  y[6][2] = 255;
    	x[6][3] = 66;
    	  y[6][3] = 243;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);         
        Graphics2D g2d = (Graphics2D) g; 
        g2d.setColor(Color.black);
        for(int i=0; i<7; i++)
        {
        	for(double t = 0.0; t<=1.0; t=t+0.001)
            {
            	putx = Math.pow(1-t, 3)*x[i][0] + 3*t*Math.pow(1-t, 2)*x[i][1] + 3*t*t*Math.pow(1-t, 1)*x[i][2] + Math.pow(t, 3) * x[i][3];
            	puty = Math.pow(1-t, 3)*y[i][0] + 3*t*Math.pow(1-t, 2)*y[i][1] + 3*t*t*Math.pow(1-t, 1)*y[i][2] + Math.pow(t, 3) * y[i][3];
            	g2d.drawLine((int)putx, (int)puty, (int)putx, (int)puty);
            }
        }
        g2d.dispose();
    }
}
