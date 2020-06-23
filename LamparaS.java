import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class LamparaS extends JPanel{

	@Override
	public void paintComponent(Graphics g){

		super.paintComponent(g);

		g.setColor(Color.YELLOW);
        int [] vx2 = {138,100,168};
        int [] vy2 = {140,180,180};
        g.fillPolygon (vx2, vy2, 3);
		this.setOpaque(false);	
	}

}