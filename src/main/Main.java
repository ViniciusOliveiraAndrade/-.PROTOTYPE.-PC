package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import view.TelaDoJogo;

public class Main {
	
	public static Dimension dimension;
	public static void main(String[] args) {
		
		dimension = new Dimension (Toolkit.getDefaultToolkit().getScreenSize()); //pegar o tamanho da tela
		new TelaDoJogo(dimension); //criar a tela do jogo
		
		System.out.println("oi  : " + Color.BLACK);
	}

	
}
