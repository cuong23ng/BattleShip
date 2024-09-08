package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Board.ButtonListener;
import model.Ship;
import model.Table;

public class Board extends JFrame {
	private JFrame frame;
	private Table table;
	private Ship[] ships;

	public Board(Table table) {
		this.table = table;
		this.ships = this.table.getShips();
		
		JPanel tablePlay = new JPanel(new GridLayout(10, 10));
		this.addButtons(tablePlay);
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		//panelButtons_1.setPreferredSize(new Dimension(500, 500));
		//panelButtons_2.setPreferredSize(new Dimension(500, 500));
		
		container.add(tablePlay, BorderLayout.CENTER);
		//cp.add(panelButtons_2, BorderLayout.EAST);
		
		this.setTitle("BattleShip");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	private void addButtons(JPanel tablePlay) {
		JButton buttons[][] = new JButton[10][10]; 
		ButtonListener buttonListener = new ButtonListener(this.table, tablePlay);
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				buttons[i][j] = new JButton();
				
				int index = this.table.getShipIndex(j, i);
				if (index >= 0) {
					ships[index].setButton(buttons[i][j]);
				}
				
				tablePlay.add(buttons[i][j]);
				buttons[i][j].addActionListener(buttonListener);
			}
		}
		this.add(tablePlay);
	}

	public Table getTable() {
		return table;
	}
	
}