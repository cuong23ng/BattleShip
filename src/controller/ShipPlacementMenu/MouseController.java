package controller.ShipPlacementMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import model.Ship;
import model.Table;
import view.MouseMoveScale;

public class MouseController implements MouseListener, MouseMotionListener {
	private int x;
	private int y;
	private MouseMoveScale mouseMoveScale;
	private Rectangle2D.Float[] myRect ;
	private Ship[] ships;
	private Table table;
	
	public MouseController(MouseMoveScale mouseMoveScale) {
		super();
		this.mouseMoveScale = mouseMoveScale;
		this.myRect = mouseMoveScale.getMyRect();
		this.ships = mouseMoveScale.getShips();
		this.table = mouseMoveScale.getTable();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		float temp;
		
		for(int i = 0; i < 10; i++) {
			if (myRect[i].getBounds2D().contains(x, y)) {
				Ship oldShip = new Ship(ships[i].getX(), ships[i].getY(), 
										ships[i].getSize(), ships[i].getDirection());
				
				temp = myRect[i].width;
				myRect[i].width = myRect[i].height;
				myRect[i].height = temp;

				if (myRect[i].y + myRect[i].height > 525) {
					myRect[i].y = 577 - myRect[i].height;
					ships[i].setY(10 - ships[i].getSize());
				}

				if (myRect[i].x + myRect[i].width > 578 && oldShip.getX() < 99) {
					myRect[i].x = 577 - myRect[i].width;
					ships[i].setX(10 - ships[i].getSize());
				}
				
				if (ships[i].getDirection() == Ship.Direction.HORIZONTAL) {
					ships[i].setDirection(Ship.Direction.VERTICAL);
				} else {
					ships[i].setDirection(Ship.Direction.HORIZONTAL);
				}
				
				if (myRect[i].x + myRect[i].width < 578) {
					ships[i].setX((int)(myRect[i].x / 58));
					ships[i].setY((int)(myRect[i].y / 58));
				}
				
				if (oldShip.getX() < 99) {
					if (ships[i].getX() < 99) {
						if (mouseMoveScale.checkDeadZone(oldShip) == false) {
							this.table.returnDeadZone(oldShip);
						}
						
						if (mouseMoveScale.checkDeadZone(ships[i]) == false) {
							this.table.setDeadZone(ships[i]);
						}
					} else if (ships[i].getX() == 99) {
						this.table.returnDeadZone(oldShip);
					}
				}
				
				mouseMoveScale.repaint();
				break;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int dx = e.getX() - x;
		int dy = e.getY() - y;
		
		for(int i = 0; i < 10 ; i++) {
			if (myRect[i].getBounds2D().contains(x, y)) {
				if(dy % 58 != 0) {
					dy -= dy % 58;
				}
				
				if(dx % 58 != 0) {
					dx -= dx % 58;
				}
				
				myRect[i].x += dx;
				myRect[i].y += dy;
				Ship oldShip = new Ship(ships[i].getX(), ships[i].getY(), ships[i].getSize(), ships[i].getDirection());
				
				if(myRect[i].x < 1) {
					myRect[i].x = 1;
				}

				if(myRect[i].y + myRect[i].height > 577) {
					myRect[i].y = 577 - myRect[i].height;
				}

				if(myRect[i].x + myRect[i].width > 1100) {
					myRect[i].x = (1120 - myRect[i].width) - (1120 - myRect[i].width) % 29 + 1;
				}

				if(myRect[i].y < 1) {
					myRect[i].y = 1;
				}
				
				if (myRect[i].x + myRect[i].width < 578) {
					ships[i].setX((int)(myRect[i].x / 58));
					ships[i].setY((int)(myRect[i].y / 58));
				} else {
					ships[i].setX(99);
					ships[i].setY(99);
				}
				
				if (oldShip.getX() < 99) {
					if (ships[i].getX() < 99) {
						if (mouseMoveScale.checkDeadZone(oldShip) == false) {
							this.table.returnDeadZone(oldShip);
						}
						
						if (mouseMoveScale.checkDeadZone(ships[i]) == false) {
							this.table.setDeadZone(ships[i]);
						}
					} else if (ships[i].getX() == 99) {
						this.table.returnDeadZone(oldShip);
					}
				}
				
				mouseMoveScale.repaint();
				break;
			}
		}

		x += dx;
		y += dy;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}