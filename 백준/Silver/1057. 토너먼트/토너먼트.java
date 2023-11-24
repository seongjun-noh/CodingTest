import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double n = sc.nextDouble();
		double kim = sc.nextDouble();
		double lim = sc.nextDouble();
		int result = 1;

		while(true) {
			kim = modNum(n, kim);
			lim = modNum(n, lim);

			if (kim == lim) {
				break;
			} else {
				result++;
			}

			n = Math.ceil(n / 2);
		}

		System.out.println(result);
	}

	public static double modNum(double n, double num) {
		if (n == num) {
			num = Math.ceil(n / 2);
		} else if (num % 2 == 1) {
			num = Math.ceil(num / 2);
		} else {
			num = Math.floor(num / 2);
		}

		return num;
	}
}