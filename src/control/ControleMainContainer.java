package control;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import view.MainContainer;

public class ControleMainContainer implements ActionListener{

	private MainContainer mainContainer;
	private Timer time;
	
	public ControleMainContainer(MainContainer mainContainer) {
		
		this.mainContainer = mainContainer;
		time =new Timer(30, this);
		time.start();
	}
	
	public void verificarAlvoFora(){
		
		for (int i = 0; i < mainContainer.getAlvos().size(); i++) {
			if (mainContainer.getAlvos().get(i).getY() > mainContainer.getHeight()){
				mainContainer.removerAlvo(i);
			}
		}
		
	}
	
	public void verificarTiroFora(){
		
		for (int i = 0; i < mainContainer.getPersonagem().getTiros().size(); i++) {
			if (mainContainer.getPersonagem().getTiros().get(i).getY() < 0){
				mainContainer.getPersonagem().removerTiro(i);
			}
		}
		
	}
	
	public void verificarColisao(){
		
		for (int i = 0; i < mainContainer.getPersonagem().getTiros().size(); i++) {
			for (int j = 0; j < mainContainer.getAlvos().size(); j++) {
				if (mainContainer.getAlvos().get(j).getArea().intersects(mainContainer.getPersonagem().getTiros().get(i).getArea())){
					mainContainer.removerAlvo(j);
					mainContainer.getPersonagem().removerTiro(i);
					System.out.println("Acertou");

					
					return;
				}
			}
		}
		
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		mainContainer.moverAlvos();
		mainContainer.getPersonagem().moverTiros();
		verificarAlvoFora();
		verificarTiroFora();
		verificarColisao();
	
	}
}
