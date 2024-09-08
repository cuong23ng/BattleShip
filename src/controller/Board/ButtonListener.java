package controller.Board;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Ship;
import model.Ship.Direction;
import model.Table;

public class ButtonListener implements ActionListener {
	private static int turn = 40;
	private Table table;
	private JPanel tablePlay;
	
	public ButtonListener(Table table, JPanel tablePlay) {
		this.table = table;
		this.tablePlay = tablePlay;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		turn --;
		System.out.println(turn);
        JButton clickedButton = (JButton) e.getSource();
        
        // Set color
        clickedButton.setBackground(new Color(244,218,169,255));
        clickedButton.setText("•");

        // Disable the button
        clickedButton.setEnabled(false);
        
        int x = clickedButton.getX() / 47;
        int y = clickedButton.getY() / 45;
        int index = this.table.getShipIndex(x, y); 
        
        System.out.println(index);
        
        if (index >= 0) {
        	Ship[] ships = this.table.getShips();
        	ships[index].setLife(ships[index].getLife() - 1);
        	
        	if (ships[index].getLife() == 0) {
        		ships[index].setStatus(false);
        		table.setAlive(table.getAlive() - 1);
        		
        		for (JButton button : ships[index].getButtons()) {
        			button.setBackground(Color.green);
        			button.setText("x");
        		}
        		
        		if (table.getAlive() == 0) {
        			JOptionPane.showMessageDialog(new JFrame(), "You Win!", "Congratulation", JOptionPane.INFORMATION_MESSAGE);
        			this.tablePlay.setVisible(false);
        			return;
        		} 
        		
        	} else {
        		clickedButton.setBackground(Color.red);
                clickedButton.setText("-");
        	}
        }
        
        if (turn == 0) {
			JOptionPane.showMessageDialog(new JFrame(), "You Lose!", "Loser", JOptionPane.INFORMATION_MESSAGE);
			this.tablePlay.setVisible(false);
			return;
		}
    }
}
