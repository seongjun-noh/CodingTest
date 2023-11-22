import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double d = sc.nextDouble();
		double h = sc.nextDouble();
		double w = sc.nextDouble();

		double x = Math.sqrt(Math.pow(d, 2) / ((Math.pow(h, 2) + Math.pow(w, 2))));
		int height = (int) Math.floor(h * x);
		int width = (int) Math.floor(w * x);

		System.out.println(height + " " + width);
	}
}