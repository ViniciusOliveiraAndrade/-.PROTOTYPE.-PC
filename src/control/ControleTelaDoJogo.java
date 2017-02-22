package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.TelaDoJogo;

public class ControleTelaDoJogo implements KeyListener{

	private TelaDoJogo telaDoJogo;
	
	public ControleTelaDoJogo(TelaDoJogo telaDoJogo) {
		this.telaDoJogo = telaDoJogo;
	
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){System.exit(0);}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){telaDoJogo.getMainContainer().getPersonagem().moverEsquerda();}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){telaDoJogo.getMainContainer().getPersonagem().moverDireita();}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){telaDoJogo.getMainContainer().getPersonagem().atirar();System.out.println("atirou");}
	}

	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}


}
