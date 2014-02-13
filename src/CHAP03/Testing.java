package CHAP03;

public class Testing {
	
	public static void main(String[] args) {
		
		Robot robita = new Robot(new Position(10, 20), "로비타");
		//Robot robitaMKII = robita;
		Robot robitaMKII = robita.makeClone1();
		//Robot robitaMKII = robita.makeClone2();
		
		System.out.println("이동 전의 로비타 = " + robita);
		robita.moveX(10);
		System.out.println("이동 후의 로비타 = " + robita);
		System.out.println("robitaMKII = " + robitaMKII);
		
		Position a = new Position(10, 20);
		Position b = new Position(10, 20);
		
		if(a.equals(b)) {
			System.out.println(a + "와" + b + "은 같다.");
		} else {
			System.out.println(a + "와" + b + "은 같지 않다.");
		}
	}
}