package controller.ShipPlacementMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Ship;
import model.Table;
import view.Board;
import view.MouseMoveScale;

public class NextButtonListener implements ActionListener {
	private static int k = 0; //Số lượng player đã chọn xong
	private MouseMoveScale mouseMoveScale;
	private Table table;
	private Ship[] ships;
	private JFrame frame;
	
	public NextButtonListener(MouseMoveScale mouseMoveScale, JFrame frame) {
		this.mouseMoveScale = mouseMoveScale;
		this.table = mouseMoveScale.getTable();
		this.ships = table.getShips();
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (ships[i].getX() == 99) {
				JOptionPane.showMessageDialog(new JFrame(), "Put all the ships in the table!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (this.mouseMoveScale.checkDeadZone(ships[i])) {
				JOptionPane.showMessageDialog( new JFrame(), "Make sure that there is at least one space between them.", "Error",
											JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			table.setShipsZone(ships[i]);
		}
		
		//hàm thử
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (table.getShipIndex(j, i) >= 0) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.print("\n");
		}
		
		this.frame.setVisible(false);
		new Board(this.table);
	}

}
