import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class LamparaD extends JPanel{

	@Override
	public void paintComponent(Graphics g){

		super.paintComponent(g);

		g.setColor(Color.YELLOW);
        int [] vx2 = {38,100,168};
        int [] vy2 = {40,80,80};
        g.fillPolygon (vx2, vy2, 3);
		this.setOpaque(false);	
	}

}