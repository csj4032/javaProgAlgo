package chap03;

public class Testing {
	
	public static void main(String[] args) {
		
		Robot robita = new Robot(new Position(10, 20), "");
		//Robot robitaMKII = robita;
		Robot robitaMKII = robita.makeClone1();
		//Robot robitaMKII = robita.makeClone2();
		
		System.out.println("= " + robita);
		robita.moveX(10);
		System.out.println("= " + robita);
		System.out.println("robitaMKII = " + robitaMKII);
		
		Position a = new Position(10, 20);
		Position b = new Position(10, 20);
		
		if(a.equals(b)) {
			System.out.println(a + "" + b + "");
		} else {
			System.out.println(a + "" + b + "");
		}
	}
}