package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Personagem {

	private int x, y;
	private int width = 60,height = 60;
	private Rectangle body, head;
	private Dimension dimension;

	private int larguraTela;
	
	private ArrayList<Point> tiros;
	
	public Personagem(Dimension dimension) {
		this.dimension = dimension;
		x=3;
		y = dimension.height-63;
		head = new Rectangle(x + 20, y, 20, 25);
		body = new Rectangle(x , y + 25, 60, 35);
		
		larguraTela = (int) (dimension.width * 0.8);
		
		tiros = new ArrayList<>();
		
	}


	public synchronized void desenhar(Graphics g){

		//		Cor = DarkRed
		g.setColor(new Color(139, 0, 0));
		
//		Desenho da cabeça
		g.fillRect(x+20, head.y, head.width, head.height);
		
//		Desenho do corpo
		g.fillRect(x, body.y, body.width, body.height);
	}
	
	public synchronized void desenharTiros(Graphics g){

		g.setColor(Color.YELLOW);
		
		for (Point point : tiros) {
			g.fillRect(point.x, point.y, 20, 10);
		}
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
	
	public synchronized void atirar(){
		tiros.add(new Point(getHead().x, getHead().y- 10 ));
	} 
	
	public synchronized void moverTiros(){
		
		for (Point point : tiros) {
			point.y-=5;
		}
	}
	
	public synchronized void removerTiro(int index){
		
		tiros.remove(index);
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
		head.x = x + 20;
		head.y = y;
		return head;
	}
	
	public Dimension getDimension() {
		return dimension;
	}


	public ArrayList<Point> getTiros() {
		return tiros;
	}
	
	
}
