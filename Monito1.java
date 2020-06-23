import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class Monito1 extends JPanel{

	BufferedImage imagen1;

	public Monito1(BufferedImage imagen1)
	{
		this.imagen1 = imagen1;
		this.setOpaque(false);	
	}
	public void paintComponent(Graphics g){

		super.paintComponent(g);	
        g.drawImage(imagen1,200,200,48,48,null);

        
   	}

}