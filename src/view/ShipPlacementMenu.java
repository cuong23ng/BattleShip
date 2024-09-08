package view;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.ShipPlacementMenu.NextButtonListener;

public class ShipPlacementMenu {
	private JFrame frame;
	public ShipPlacementMenu(JFrame frame) {
		this.frame = frame;
		//this.frame.getContentPane().removeAll();
		//this.frame.repaint(); //VẼ RA MÀN HÌNH
		
		MouseMoveScale mouseMoveScale = new MouseMoveScale();
		
		JButton nextButton = new JButton();
		nextButton.setBounds(885, 498, 130, 60);
		nextButton.setText("Next");
		NextButtonListener nextButtonListener = new NextButtonListener(mouseMoveScale, this.getFrame()); 
		nextButton.addActionListener(nextButtonListener);
	
		//mouseMoveScale.setDoubleBuffered(true);
		this.frame.setContentPane(mouseMoveScale);	
		this.frame.getContentPane().add(nextButton);
		this.frame.setVisible(true);
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
