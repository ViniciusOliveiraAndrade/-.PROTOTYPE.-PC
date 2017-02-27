package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import control.ControleTelaDoJogo;

public class TelaDoJogo extends JFrame{
	private static final long serialVersionUID = 1L;

	private MainContainer mainContainer;
	public static InformationPanel informationPanel;
	
	private ControleTelaDoJogo controle;
	public TelaDoJogo(Dimension dimension) {
		setLayout(null);
		
		
		mainContainer = new MainContainer(dimension);
		mainContainer.setLocation(0, 0);
		
		informationPanel = new InformationPanel(dimension);
		informationPanel.setLocation(mainContainer.getWidth(), 0);
		informationPanel.setMissao(mainContainer.getMissao().getNumeroAlvo(), mainContainer.getMissao().getOperacao());
		
		add(mainContainer);
		add(informationPanel);
		
		controle = new ControleTelaDoJogo(this);
		
		addKeyListener(controle);
		
		setPreferredSize(dimension);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		
		setVisible(true);
	}

	public MainContainer getMainContainer() {
		return mainContainer;
	}

	
	
}
