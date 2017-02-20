package main;

import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Teste {

	static GraphicsDevice device = GraphicsEnvironment
	        .getLocalGraphicsEnvironment().getScreenDevices()[0];

	public static void main(String[] args) {

	    final JFrame frame = new JFrame("Display Mode");
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setUndecorated(true);

	    JButton btn1 = new JButton("Full-Screen");
	    btn1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            device.setFullScreenWindow(frame);
	        }
	    });
	    JButton btn2 = new JButton("Normal");
	    btn2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            device.setFullScreenWindow(null);
	        }
	    });

	    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    panel.add(btn1);
	    panel.add(btn2);
	    frame.add(panel);

	    frame.pack();
	    frame.setVisible(true);

	}
	
	
}
