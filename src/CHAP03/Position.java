package CHAP03;

public class Position {

	private int x;
	private int y;

	public Position(int xPos, int yPos) {
		x = xPos;
		y = yPos;
	}

	// X
	// public void moveX(int xDelta) {
	// x += xDelta;
	// }

	//
	public Position moveX(int xDelta) {
		return new Position(x + xDelta, y);
	}

	//
	public void moveY(int yDelta) {
		y += yDelta;
	}

	// XY
	public void moveXY(int xDelta, int yDelta) {
		x += xDelta;
		y += yDelta;
	}

	// X
	public int getX() {
		return x;
	}

	// Y
	public int getY() {
		return y;
	}

	//
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public boolean equals(Position pos) {
		return this.x == pos.x && this.y == pos.y;
	}
}
