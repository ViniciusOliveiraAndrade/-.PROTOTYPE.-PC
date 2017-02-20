package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import view.TelaDoJogo;

public class Main {
	
	public static Dimension dimension;
	public static void main(String[] args) {
		
		dimension = new Dimension (Toolkit.getDefaultToolkit().getScreenSize()); 
		new TelaDoJogo(dimension);
		
		System.out.println("oi  : " + Color.BLACK);
	}

	
}
