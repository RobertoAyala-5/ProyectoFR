import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class LamparaA extends JPanel{

	@Override
	public void paintComponent(Graphics g){

		super.paintComponent(g);

		g.setColor(Color.YELLOW);
        int [] vx2 = {138,100,100};
        int [] vy2 = {140,80,180};
        g.fillPolygon (vx2, vy2, 3);
		this.setOpaque(false);	
	}

}