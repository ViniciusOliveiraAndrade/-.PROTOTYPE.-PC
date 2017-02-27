package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class InformationPanel extends JPanel {
	private static final long serialVersionUID = 1L;


	private JLabel numeroL, operacaoL;
	private Font font;
	public InformationPanel(Dimension dimension) {
		
		setLayout(new GridLayout(2,1));
		
		setSize((int)(dimension.width * 0.2) + 1 , dimension.height);
		setBorder(new LineBorder(Color.BLACK, 3));
		font = new Font("BOLD", Font.BOLD, 150);
		
		numeroL = new JLabel("");
		numeroL.setFont(font);
		
		operacaoL = new JLabel("");
		operacaoL.setFont(font);
		
		add(numeroL);
		add(operacaoL);

	}

	public void setMissao(int numero,String operacao){
		numeroL.setText("  "+numero);
		operacaoL.setText("  "+operacao);
	}

	

}
