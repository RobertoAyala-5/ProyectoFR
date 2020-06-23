import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class MiVentana extends JFrame implements KeyListener{

	BufferedImage imagen;
	BufferedImage imagen1;
	BufferedImage subImagen;
	BufferedImage subImagen1;
	Monito monito;
	Thread enemigo1;
	/*LamparaW lamparaW;
	LamparaA lamparaA;
	LamparaS lamparaS;
	LamparaD lamparaD;*/
	int indiceX;
	int indice = 0;
	int t;
	boolean posicion = true;

	public MiVentana()
	{

		try{
			imagen = ImageIO.read(new File("./imagenes/48389841_204443183824787_1483351678198480896_n.png"));

		}catch(Exception e)
		{
			System.out.println("Error al cargar la imagen");
		}

		try{
			imagen1 = ImageIO.read(new File("./imagenes/png-sprite-generator-7.png"));

		}catch(Exception e)
		{
			System.out.println("Error al cargar la imagen");
		}

		try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("./imagenes/d0299d3be0d151eb3baac4d899e68064.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

		subImagen = imagen.getSubimage(0,0,48,48);
		subImagen1 = imagen1.getSubimage(0,0,48,48);
		monito = new Monito(subImagen, subImagen1);

		/*lamparaW = new LamparaW();
		lamparaS = new LamparaS();
		lamparaD = new LamparaD();
		lamparaA = new LamparaA();*/

		/*this.add(lamparaW);
		this.add(lamparaS);
		this.add(lamparaD);
		this.add(lamparaA);*/
		this.add(monito);
		this.setTitle("Mi Ventana");
		this.getContentPane().setBackground(Color.black);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setVisible(true);
		this.addKeyListener(this);

		crearHilo1();
	}
	
	public void keyPressed(KeyEvent e)
	{
		//System.out.println("Tecla presionada = "+e.getKeyCode());
		t = e.getKeyCode();
		Point pos = monito.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		//System.out.println( (int) pos.getX() );

		if(t==68)
		{
			x = x + 5;
			indice = (indice + 1) % 4;
			indiceX = 48 * indice;
			if (indiceX == 48*3) {
				indiceX = 48;
			}
			monito.imagen = imagen.getSubimage(indiceX,48*2,48,48);
			/*lamparaW.setVisible(false);
			repaint();
			lamparaS.setVisible(false);
			repaint();
			lamparaD.setVisible(true);
			repaint();
			lamparaA.setVisible(false);
			repaint();*/			
		}

		else if(t==65)
		{
			x = x - 5;
			indice = (indice + 1) % 4;
			indiceX = 48 * indice;
			if (indiceX == 48*3) {
				indiceX = 48;
			}
			monito.imagen = imagen.getSubimage(indiceX,48,48,48);
			/*lamparaW.setVisible(false);
			repaint();
			lamparaS.setVisible(false);
			repaint();
			lamparaD.setVisible(false);
			repaint();
			lamparaA.setVisible(true);
			repaint();*/				
		}

		else if(t==83)
		{
			y = y + 5;
			indice = (indice + 1) % 4;
			indiceX = 48 * indice;
			if (indiceX == 48*3) {
				indiceX = 48;
			}
			monito.imagen = imagen.getSubimage(indiceX,48*0,48,48);
			/*lamparaW.setVisible(false);
			repaint();
			lamparaS.setVisible(true);
			repaint();
			lamparaD.setVisible(false);
			repaint();
			lamparaA.setVisible(false);
			repaint();*/				
		}
		else if(t==87)
		{
			y = y - 5;
			indice = (indice + 1) % 4;
			indiceX = 48 * indice;
			if (indiceX == 48*3) {
				indiceX = 48;
			}
			monito.imagen = imagen.getSubimage(indiceX,48*3,48,48);
			/*lamparaW.setVisible(true);
			repaint();
			lamparaS.setVisible(false);
			repaint();
			lamparaD.setVisible(false);
			repaint();
			lamparaA.setVisible(false);
			repaint();*/
		}
		monito.setLocation(x,y);
		/*lamparaW.setLocation(x,y);
		lamparaS.setLocation(x,y);
		lamparaD.setLocation(x,y);
		lamparaA.setLocation(x,y);*/
	}

	public void keyReleased(KeyEvent e)
	{
		//System.out.println("Tecla liberada.");
	}

	public void keyTyped(KeyEvent e)
	{
		//System.out.println("Tecla en el buffer.")

	}

	public void crearHilo1()
	{
		Enemigo1 e1 = new Enemigo1(monito,imagen1);
		enemigo1 = new Thread(e1);
		enemigo1.start();
	}

}
