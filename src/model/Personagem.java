package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Personagem {

	private int x, y;
	private int width = 60,height = 60;
	private Rectangle body, head;
	private Dimension dimension;
	private int acerto1, acerto2;
	private boolean acerto1Ok = false, acerto2Ok = false;

	private int larguraTela;
	
	private ArrayList<Tiro> tiros;
	
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
		
		for (Tiro tiro : tiros) {
			tiro.desenharTiros(g);
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
		tiros.add(new Tiro(getHead().x, getHead().y- 10 ));
	} 
	
	public synchronized void moverTiros(){
		
		for (Tiro tiro : tiros) {
			tiro.mover();
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


	public ArrayList<Tiro> getTiros() {
		return tiros;
	}


	public int getAcerto1() {
		return acerto1;
	}


	public void setAcerto1(int acerto1) {
		this.acerto1 = acerto1;
	}


	public int getAcerto2() {
		return acerto2;
	}


	public void setAcerto2(int acerto2) {
		this.acerto2 = acerto2;
	}


	public boolean isAcerto1Ok() {
		return acerto1Ok;
	}


	public void setAcerto1Ok(boolean acerto1Ok) {
		this.acerto1Ok = acerto1Ok;
	}


	public boolean isAcerto2Ok() {
		return acerto2Ok;
	}


	public void setAcerto2Ok(boolean acerto2Ok) {
		this.acerto2Ok = acerto2Ok;
	}
	
	
	
	
}
