package chap03;

public class Robot {

	private Position position;
	private String name;

	public Robot(Position pos, String nickName) {
		position = pos;
		name = nickName;
	}

	//public void moveX(int xDelta) {
	//	position.moveX(xDelta);
	//}
	
	public void moveX(int xDelta) {
		position = position.moveX(xDelta);
	}

	public void moveY(int yDelta) {
		position.moveY(yDelta);
	}

	public void moveXY(int xDelta, int yDelta) {
		position.moveXY(xDelta, yDelta);
	}

	public String getName() {
		return name;
	}

	public Position getPosition() {
		return position;
	}

	public String toString() {
		return "name :" + name + " postion : " + position;
	}
	
	//Shallow Copy
	public Robot makeClone1() {
		return new Robot(position, name+" 입니다.");
	}
	
	//Deep Copy
	public Robot makeClone2() {
		return new Robot(new Position(position.getX(), position.getY()), name+" 입니다.");
	}
}