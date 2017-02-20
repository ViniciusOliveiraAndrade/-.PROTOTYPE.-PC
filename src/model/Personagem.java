package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Personagem {

	private int x, y;
	private int width = 60,height = 60;
	private Rectangle body, head;
	private Dimension dimension;

	private int larguraTela;
	
	public Personagem(Dimension dimension) {
		this.dimension = dimension;
		x=3;
		y = dimension.height-63;
		head = new Rectangle(x + 20, y, 20, 25);
		body = new Rectangle(x , y + 25, 60, 35);
		
		larguraTela = (int) (dimension.width * 0.8);
		
	}


	public synchronized void desenhar(Graphics g){

		//		Cor = DarkRed
		g.setColor(new Color(139, 0, 0));
		
//		Desenho da cabeça
		g.fillRect(x+20, head.y, head.width, head.height);;
		
//		Desenho do corpo
		g.fillRect(x, body.y, body.width, body.height);
	}

	public synchronized void moverEsquerda(){
		if(x>3)x-=4;
		else x=3;
	}
	public synchronized void moverDireita(){
		if(x< (larguraTela - 63))x+=4;
		else x = larguraTela -63; 
	}

	public boolean checkHit(Rectangle rectangle){
		
		if(head.intersects(rectangle))return true;
		if(body.intersects(rectangle))return true;
		
		return false;
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}

	public Rectangle getBody() {
		return body;
	}

	public Rectangle getHead() {
		return head;
	}
	
	public Dimension getDimension() {
		return dimension;
	}

}
