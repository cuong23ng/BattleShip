package test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import view.ShipPlacementMenu;

public class Test {
	private static JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				frame.setTitle("Battleship");
				
				try {
					frame.setBounds(100, 100, 1120, 630);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					new ShipPlacementMenu(frame);
					//shipPlacementMenu.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
