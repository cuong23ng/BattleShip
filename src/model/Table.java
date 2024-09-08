package model;

import model.Ship.Direction;

public class Table {
	private Ship[] ships;
	private int alive;
	public int[][] shipsZone = new int[10][10];
	public int[][] deadZone = new int[10][10];
	
	public Table(Ship[] ships) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				deadZone[i][j] = 0;
				shipsZone[i][j] = -1;
			}
		}
		
		this.ships = ships;
		this.alive = 10;
	}
	
	public Table() {
		
	}
	
	public void setDeadZone(Ship ship) {
		if (ship.getDirection() == Ship.Direction.HORIZONTAL) {
			for (int i = 0; i < ship.getSize(); i++) {
				//this.deadZone[ship.getX() + i][ship.getY()] ++;
				
				if (ship.getY() - 1 >= 0) {
					this.deadZone[ship.getX() + i][ship.getY() - 1] ++;
				}
				if (ship.getY() + 1 < 10) {
					this.deadZone[ship.getX() + i][ship.getY() + 1] ++;
				}
			}
			if (ship.getX() - 1 >= 0) {
				this.deadZone[ship.getX() - 1][ship.getY()] ++;
				if (ship.getY() - 1 >= 0) {
					this.deadZone[ship.getX() - 1][ship.getY() - 1] ++;
				}
				
				if (ship.getY() + 1 < 10) {
					this.deadZone[ship.getX() - 1][ship.getY() + 1] ++;
				}
			}
			
			if(ship.getX() + ship.getSize() < 10) {
				this.deadZone[ship.getX() + ship.getSize()][ship.getY()] ++;
				
				if (ship.getY() - 1 >= 0) {
					this.deadZone[ship.getX() + ship.getSize()][ship.getY() - 1] ++;
				}
				
				if (ship.getY() + 1 < 10) {
					this.deadZone[ship.getX() + ship.getSize()][ship.getY() + 1] ++;
				}
			}
		} else {
			for (int i = 0; i < ship.getSize(); i++) {
				//this.deadZone[ship.getX()][ship.getY() + i] ++;
				
				if (ship.getX() - 1 >= 0) {
					this.deadZone[ship.getX() - 1][ship.getY() + i] ++;
				}
				if (ship.getX() + 1 < 10) {
					this.deadZone[ship.getX() + 1][ship.getY() + i] ++;
				}
			}
			if (ship.getY() - 1 >= 0) {
				this.deadZone[ship.getX()][ship.getY() - 1] ++;
				
				if (ship.getX() - 1 >= 0) {
					this.deadZone[ship.getX() - 1][ship.getY() - 1] ++;
				}
				
				if (ship.getX() + 1 < 10) {
					this.deadZone[ship.getX() + 1][ship.getY() - 1] ++;
				}
			}
			if (ship.getY() + ship.getSize() < 10) {
				this.deadZone[ship.getX()][ship.getY() + ship.getSize()] ++;
				
				if (ship.getX() - 1 >= 0) {
					this.deadZone[ship.getX() - 1][ship.getY() + ship.getSize()] ++;
				}
				if (ship.getX() + 1 < 10) {
					this.deadZone[ship.getX() + 1][ship.getY() + ship.getSize()] ++;
				}
			}
		}
	}

	public void returnDeadZone(Ship ship) {
		if (ship.getDirection() == Ship.Direction.HORIZONTAL) {
			for (int i = 0; i < ship.getSize(); i++) {
				//this.deadZone[ship.getX() + i][ship.getY()] ++;
				
				if (ship.getY() - 1 >= 0 && deadZone[ship.getX() + i][ship.getY() - 1] > 0) {
					this.deadZone[ship.getX() + i][ship.getY() - 1] --;
				}
				if (ship.getY() + 1 < 10 && deadZone[ship.getX() + i][ship.getY() + 1] > 0) {
					this.deadZone[ship.getX() + i][ship.getY() + 1] --;
				}
			}
			if (ship.getX() - 1 >= 0) {
				if (deadZone[ship.getX() - 1][ship.getY()] > 0) {
					this.deadZone[ship.getX() - 1][ship.getY()] --;
				}
				
				if (ship.getY() - 1 >= 0 && deadZone[ship.getX() - 1][ship.getY() - 1] > 0) {
					this.deadZone[ship.getX() - 1][ship.getY() - 1] --;
				}
				
				if (ship.getY() + 1 < 10 && deadZone[ship.getX() - 1][ship.getY() + 1] > 0) {
					this.deadZone[ship.getX() - 1][ship.getY() + 1] --;
				}
			}
			
			if(ship.getX() + ship.getSize() < 10) {
				if (deadZone[ship.getX() + ship.getSize()][ship.getY()] > 0) {
					this.deadZone[ship.getX() + ship.getSize()][ship.getY()] --;
				}
				
				if (ship.getY() - 1 >= 0 && this.deadZone[ship.getX() + ship.getSize()][ship.getY() - 1] > 0) {
					this.deadZone[ship.getX() + ship.getSize()][ship.getY() - 1] --;
				}
				
				if (ship.getY() + 1 < 10 && deadZone[ship.getX() + ship.getSize()][ship.getY() + 1] > 0) {
					this.deadZone[ship.getX() + ship.getSize()][ship.getY() + 1] --;
				}
			}
		} else {
			for (int i = 0; i < ship.getSize(); i++) {
				//this.deadZone[ship.getX()][ship.getY() + i] ++;
				
				if (ship.getX() - 1 >= 0 && deadZone[ship.getX() - 1][ship.getY() + i] > 0) {
					this.deadZone[ship.getX() - 1][ship.getY() + i] --;
				}
				if (ship.getX() + 1 < 10 && deadZone[ship.getX() + 1][ship.getY() + i] > 0) {
					this.deadZone[ship.getX() + 1][ship.getY() + i] --;
				}
			}
			if (ship.getY() - 1 >= 0) {
				if (deadZone[ship.getX()][ship.getY() - 1] > 0) {
					this.deadZone[ship.getX()][ship.getY() - 1] --;
				}
				
				if (ship.getX() - 1 >= 0 && deadZone[ship.getX() - 1][ship.getY() - 1] > 0) {
					this.deadZone[ship.getX() - 1][ship.getY() - 1] --;
				}
				
				if (ship.getX() + 1 < 10 && deadZone[ship.getX() + 1][ship.getY() - 1] > 0) {
					this.deadZone[ship.getX() + 1][ship.getY() - 1] --;
				}
			}
			if (ship.getY() + ship.getSize() < 10) {
				if (deadZone[ship.getX()][ship.getY() + ship.getSize()] > 0) {
					this.deadZone[ship.getX()][ship.getY() + ship.getSize()] --;
				}
				
				if (ship.getX() - 1 >= 0 && deadZone[ship.getX() - 1][ship.getY() + ship.getSize()] > 0) {
					this.deadZone[ship.getX() - 1][ship.getY() + ship.getSize()] --;
				}
				if (ship.getX() + 1 < 10 && deadZone[ship.getX() + 1][ship.getY() + ship.getSize()] > 0) {
					this.deadZone[ship.getX() + 1][ship.getY() + ship.getSize()] --;
				}
			}
		}
	}
	
	public int[][] getDeadZone() {
		return deadZone;
	}

	public void setShipsZone(Ship ship) {
		if (ship.getDirection() == Direction.HORIZONTAL) {
			for (int i = 0; i < ship.getSize(); i++) {
				int x = ship.getX();
				int y = ship.getY();
				shipsZone[x + i][y] = ship.getIndex();
			}
		} else {
			for (int i = 0; i < ship.getSize(); i++) {
				int x = ship.getX();
				int y = ship.getY();
				shipsZone[x][y + i] = ship.getIndex();
			}
		}
	}
	
	public int getShipIndex(int x, int y) {
		return shipsZone[x][y];
	}

	public Ship[] getShips() {
		return ships;
	}

	public int getAlive() {
		return alive;
	}

	public void setAlive(int alive) {
		this.alive = alive;
	}

}
