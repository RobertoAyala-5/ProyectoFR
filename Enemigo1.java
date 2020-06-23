import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class Enemigo1 implements Runnable{
	BufferedImage imagen1;
	Monito monito;
	int indice;
	int indiceX = 0;

	public Enemigo1(Monito monito, BufferedImage imagen1)
	{
		this.imagen1 = imagen1;
		this.monito = monito;
	}
	public void run()
	{
		
		while(true)
		{
			//System.out.println("Hola, soy un proceso paralelo");
			for (int y=100; y<400; y=y+5) 
			{
				indice = (indice + 1) % 4;
				indiceX = 48 * indice;
				if (indiceX == 48*3) {
					indiceX = 48;
				}
				monito.imagen1 = imagen1.getSubimage(indiceX,0,48,48);
				monito.setLocation(100,y);
				retorno(100);
			}

			for (int y=400; y>100; y=y-5) 
			{
				indice = (indice + 1) % 4;
				indiceX = 48 * indice;
				if (indiceX == 48*3) {
					indiceX = 48;
				}
				monito.imagen1 = imagen1.getSubimage(indiceX,48*3,48,48);
				monito.setLocation(100,y);
				retorno(100);
			}


		}

	}

	public void retorno(int duracion)
	{
		try{
		Thread.sleep(duracion);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}