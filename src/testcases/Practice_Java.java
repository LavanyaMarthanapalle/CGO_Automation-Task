package testcases;

public class Practice_Java {
	int x;

	private Practice_Java() {
		 x= 5;
	}
	
	public static void main(String args[]) {
		Practice_Java v1 = new Practice_Java();
		System.out.println("variable " + v1.x);
	}
}
