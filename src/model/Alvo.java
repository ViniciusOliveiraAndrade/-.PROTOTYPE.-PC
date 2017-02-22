package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Alvo {

	private int x, y = -20;
	private int width = 40,height = 40;
	private int numero;
	
	private Rectangle area;
	
	private int larguraTela;
	
	public Alvo(int largura) {
		
		
		this.larguraTela = largura;
		
		area = new Rectangle(x, y, width, height);
		
		gerarLocalNumero();
	
	}

	public void mover(){
		y+=2;
	}
	
	public void gerarLocalNumero(){
		Random gerar = new Random(); 
		this.numero = gerar.nextInt(10);
		this.x = gerar.nextInt(larguraTela - width);
		this.y = - height;
				
	}
	
	public synchronized void desenhar(Graphics g){

		g.setColor(Color.orange);
		g.fillOval(x, y, width, height);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Verdana", Font.BOLD, 15));
		g.drawString(""+numero, x+12, y+25);
	}
	
	public int getX() {
		return x;
	}
	
	

	public int getY() {
		return y;
	}

	public int getNumero() {
		return numero;
	}


	public Rectangle getArea() {
		area.setBounds(x, y, width, height);
		return area;
	}
	
}
