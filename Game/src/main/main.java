package main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Teste");
		frame.setSize(new Dimension(800,600));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new DisplayPanel());
		frame.pack();
		frame.setVisible(true);

	}

}
