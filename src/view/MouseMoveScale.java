package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import controller.ShipPlacementMenu.MouseController;
import model.Ship;
import model.Table;

public class MouseMoveScale extends JComponent {
	private Rectangle2D.Float[] myRect ;
	private static final int ROWS = 10;
	private static final int COLUMNS = 10;
	
	private static final long serialVersionUID = 1L;{
		myRect = new Rectangle2D.Float[10];
		//WIDTH = 1
		myRect[0] = new Rectangle2D.Float(697, 0, 54, 54); 
		myRect[1] = new Rectangle2D.Float(755, 0, 54, 54); 
		myRect[2] = new Rectangle2D.Float(813, 0, 54, 54); 
		myRect[3] = new Rectangle2D.Float(871, 0, 54, 54); 
		//WIDTH = 2
		myRect[4] = new Rectangle2D.Float(697, 1*58 + 1, 2*55 + 2, 54);
		myRect[5] = new Rectangle2D.Float(813, 1*58 + 1, 2*55 + 2, 54);
		myRect[6] = new Rectangle2D.Float(929, 1*58 + 1, 2*55 + 2, 54);
		//WIDTH = 3
		myRect[7] = new Rectangle2D.Float(697, 2*58 + 1, 3*56 + 2, 54);
		myRect[8] = new Rectangle2D.Float(871, 2*58 + 1, 3*56 + 2, 54);
		//WITDTH = 4
		myRect[9] = new Rectangle2D.Float(697, 3*58 + 1, 4*56 + 4, 54);
		
	}
	
	private Ship[] ships = new Ship[10];
	private Table table;
	
	private MouseController mouseController;
	
	public MouseMoveScale() {
		for (int i = 0; i < 10; i++) {
			ships[i] = new Ship(99, 99, (int)(myRect[i].width / 54), Ship.Direction.HORIZONTAL);
		}
		table = new Table(ships);
		mouseController = new MouseController(this);
		this.addMouseListener(mouseController);
		this.addMouseMotionListener(mouseController);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;
		
		//Vẽ bảng
		for(int i = 0; i < ROWS; i++) { 
			for(int j = 0; j < COLUMNS; j++) {
				int x = i * 58 + 1;
				int y = j * 58 + 1;

				g.setColor(Color.black);
				g.drawRect(x, y, 53, 53);
			}
		}	

		//Vẽ ship
		for(int i = 0; i < 10; i++) {
			g2d.setColor(Color.gray);
			g2d.fill(myRect[i]);
			
			if (myRect[i].x + myRect[i].width < 578) {
				if (checkDeadZone(ships[i])) {
					g2d.setColor(Color.RED);
					g2d.fill(myRect[i]);
				} else {
					g2d.setColor(new Color(255, 190, 152));
					g2d.fill(myRect[i]);
				}
			}
			repaint();
		}
	}

	public boolean checkDeadZone(Ship ship) {
		int x = ship.getX();
		int y = ship.getY();
		if (ship.getDirection() == Ship.Direction.HORIZONTAL) {
			for (int k = 0; k < ship.getSize(); k++) {
				if (this.table.deadZone[x + k][y] > 0) {
					return true;
				}
			}
		} else {
			for (int k = 0; k < ship.getSize(); k++) {
				if (this.table.deadZone[x][y + k] > 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Rectangle2D.Float[] getMyRect() {
		return myRect;
	}

	public Ship[] getShips() {
		return ships;
	}

	public Table getTable() {
		return table;
	}
	
}
