package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class Ship {
	private static int SHIPSNUM = 0;
	public enum Direction {
		HORIZONTAL,
		VERTICAL	    
	}
	private int index;
	private int x;
	private int y;
	private int size;
	private Direction direction;
	private int life;
	private boolean status;
	private List<JButton> buttons;
	
	public Ship(int x, int y, int size, Direction direction) {
		this.index = SHIPSNUM ++;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.size = size;
		this.life = size;
		this.status = true;
		this.buttons = new ArrayList<>();
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}
	
	public boolean getStatus() {
		return status;
	}

	public int getIndex() {
		return index;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<JButton> getButtons() {
		return buttons;
	}

	public void setButton(JButton button) {
		this.buttons.add(button);
	}

}


