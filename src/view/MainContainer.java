package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import model.Personagem;

public class MainContainer extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	private Timer timer;
	
	private Personagem personagem;
	
	
	public MainContainer(Dimension dimension) {
		setLayout(null);
		setSize((int) (dimension.width * 0.8),dimension.height);
		setBorder(new LineBorder(new Color(76, 63, 1), 3));
		setBackground(new Color(64, 224, 208));
		
		timer = new Timer(100,this); 
		timer.start();
		
		personagem = new Personagem(dimension);
		
		
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		personagem.desenhar(g);
		
	}
	

	public void actionPerformed(ActionEvent e) {
		repaint();
	}


	public Personagem getPersonagem() {
		return personagem;
	}


}
