package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import control.ControleMainContainer;
import model.Alvo;
import model.Personagem;

public class MainContainer extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	private Timer timer;
	
	private Personagem personagem;
	
	private ArrayList<Alvo> alvos; 
	
	private boolean jogoAtivo;
	
	private GerarAlvo gerarAlvo;
	
	private ControleMainContainer controle; 
	
	public MainContainer(Dimension dimension) {
		setLayout(null);
		setSize((int) (dimension.width * 0.8),dimension.height);
		setBorder(new LineBorder(new Color(76, 63, 1), 3));
		setBackground(new Color(64, 224, 208));
		
		alvos = new ArrayList<>();
		
		timer = new Timer(30,this); 
		timer.start();
		
		personagem = new Personagem(dimension);
		
		jogoAtivo = true;
		
		gerarAlvo = new GerarAlvo();
		
		gerarAlvo.start();
		
		controle = new ControleMainContainer(this);
	}
	//uso de thread pra gerar o alvo a cada seg de milesimo gerar um alvo
	public class GerarAlvo extends Thread{
		
		public void run() {
			
			while (jogoAtivo){
				
				alvos.add(new Alvo(getWidth()));
				
				try {
					Thread.sleep(1100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			super.run();
		}
		
	}
	
//////////////////////////////////////////////////////////////Draw
	
	public void paint(Graphics g) {
		super.paint(g);
		
		desenharAlvos(g);
		
		personagem.desenharTiros(g);
		
		personagem.desenhar(g);
		
	}
	
	public void removerAlvo(int index){
		alvos.remove(index);
	}
	
	public synchronized void moverAlvos(){
		for (Alvo alvo : alvos) {
			alvo.mover();
		}
	}
	
	public synchronized void desenharAlvos(Graphics g){

		for (Alvo alvo : alvos) {
			alvo.desenhar(g);
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		repaint();
	}
///////////////////////////////////////////////////////////////////Gets

	public Personagem getPersonagem() {
		return personagem;
	}


	public ArrayList<Alvo> getAlvos() {
		return alvos;
	}


}
