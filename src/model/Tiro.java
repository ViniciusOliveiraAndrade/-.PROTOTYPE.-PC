package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Tiro {


	private int x, y;
	private int width = 20,height = 10;
	private Rectangle area;


	public Tiro(int x, int y) {
		this.x = x;
		this.y = y;
		area = new Rectangle(x,y,width,height);
	}
	//recebe o grafico de desenho

	public synchronized void desenharTiros(Graphics g){

		g.setColor(Color.YELLOW);

		g.fillRect(x, y, width,height);
	}



	public void mover(){
		y-=5;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}


	public Rectangle getArea() {
		area.setBounds(x,y,width,height);
		return area;
	}









}
