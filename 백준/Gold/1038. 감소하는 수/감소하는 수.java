import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		List<Long> reduceNumList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			findReduceNum(reduceNumList, (long)i, 1);
		}

		Collections.sort(reduceNumList);

		if (N < reduceNumList.size()) {
			System.out.println(reduceNumList.get(N));
		} else {
			System.out.println(-1);
		}

	}

	private static void findReduceNum(List<Long> reduceNumList, Long currentNum, int length) {
		if (length > 10) {
			return;
		}

		reduceNumList.add(currentNum);

		for (int i = 0; i < currentNum % 10; i++) {
			findReduceNum(reduceNumList, currentNum * 10 + i, length + 1);
		}
	}
}
