import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		Integer[] weightLimit = Arrays.stream(bf.readLine().split(" "))
			.map(Integer::parseInt)
			.toArray(Integer[]::new);
		int m = Integer.parseInt(bf.readLine());
		List<Integer> weight = Arrays.stream(bf.readLine().split(" "))
			.map(Integer::parseInt).collect(Collectors.toList());

		int result = 0;

		Arrays.sort(weightLimit, Collections.reverseOrder());
		weight.sort(Collections.reverseOrder());

		if (weight.get(0) > weightLimit[0]) {
			result = -1;
		} else {
			while (!weight.isEmpty()) {
				result++;
				for (int i = 0; i < n; i++) {
					for (Integer w : weight) {
						if (weightLimit[i] >= w) {
							weight.remove(w);
							break;
						}
					}
				}
			}
		}

		System.out.println(result);
	}
}
