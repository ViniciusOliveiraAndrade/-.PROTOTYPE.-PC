package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class InformationPanel extends JPanel {
	private static final long serialVersionUID = 1L;


	

	public InformationPanel(Dimension dimension) {
		
		setSize((int)(dimension.width * 0.2) + 1 , dimension.height);
		setBorder(new LineBorder(Color.BLACK, 3));
		
		add(new JLabel("aaaaaa iiiiii aaaaaa"));
		

	}


	

}
