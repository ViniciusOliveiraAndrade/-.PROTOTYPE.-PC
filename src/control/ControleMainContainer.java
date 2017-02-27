package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.Missao;
import view.MainContainer;
import view.TelaDoJogo;

public class ControleMainContainer implements ActionListener{

	private MainContainer mainContainer;
	private Missao missao;
	private Timer time;
	
	public ControleMainContainer(MainContainer mainContainer) {
		
		this.mainContainer = mainContainer;
		time =new Timer(30, this);
		time.start();
		missao = new Missao();
		missao.gerarMissao();
		
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
					
					if(!mainContainer.getPersonagem().isAcerto1Ok()){
						mainContainer.getPersonagem().setAcerto1(mainContainer.getAlvos().get(j).getNumero());
						mainContainer.getPersonagem().setAcerto1Ok(true);
						System.out.println(mainContainer.getAlvos().get(j).getNumero());
						System.out.println(mainContainer.getAlvos().get(j).getNumero());
					}else{
						mainContainer.getPersonagem().setAcerto2(mainContainer.getAlvos().get(j).getNumero());
						mainContainer.getPersonagem().setAcerto2Ok(true);
					}
					
					mainContainer.removerAlvo(j);
					mainContainer.getPersonagem().removerTiro(i);
					System.out.println("Acertou");
					return;
				}
			}
		}
	}
	public void verificarMissao(){
		if (mainContainer.getPersonagem().isAcerto2Ok()){
			System.out.println("verificando missao");
			if(missao.checarMissao(mainContainer.getPersonagem())){
				missao.gerarMissao();
				TelaDoJogo.informationPanel.setMissao(missao.getNumeroAlvo(), missao.getOperacao());
				mainContainer.getPersonagem().setAcerto1Ok(false);
				mainContainer.getPersonagem().setAcerto2Ok(false);
			}else {
				JOptionPane.showMessageDialog(null, "Você Perdeu.");
				System.exit(0);
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		mainContainer.moverAlvos();
		mainContainer.getPersonagem().moverTiros();
		verificarAlvoFora();
		verificarTiroFora();
		verificarColisao();
		verificarMissao();
	
	}

	public Missao getMissao() {
		return missao;
	}
	
	
	
}
