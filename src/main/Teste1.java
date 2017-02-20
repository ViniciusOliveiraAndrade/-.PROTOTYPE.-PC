package main;

import javax.swing.JFrame;

public class Teste1 {

	public static void main(String[] args) {
		JFrame f = new JFrame("test");
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setUndecorated(true);
		f.setVisible(true);
		
	}

}
