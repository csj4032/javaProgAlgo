package Chap05;

public class Cell {

	Cell next;
	Object data;
	
	public Cell(Object aData) {
		next = null;
		this.data = aData;
	}
}