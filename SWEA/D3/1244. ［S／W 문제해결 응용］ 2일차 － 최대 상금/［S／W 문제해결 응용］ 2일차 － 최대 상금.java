import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] str = bf.readLine().split(" ");

			Integer[] arr = Stream.of(str[0].split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

			int exchangeNum = Integer.parseInt(str[1]);

			Integer[] sorted = arr.clone();
			Arrays.sort(sorted, Collections.reverseOrder());

			sb.append("#" + test_case + " ");

			for (int i = exchangeNum; i > 0; i--) {
				if (Arrays.equals(arr, sorted)) {
					if (i % 2 != 0) {
						Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr));
						if (set.size() == arr.length) {
							int temp = arr[arr.length - 1];
							arr[arr.length - 1] = arr[arr.length - 2];
							arr[arr.length - 2] = temp;
						}
					}
					break;
				} else {
					for (int j = 0; j < arr.length; j++) {
						if (arr[j] == sorted[j]) {
							continue;
						} else {
							for (int k = arr.length - 1; k > 0; k--){
								if(arr[k] == sorted[j]) {
									for(int l = 1; l <= exchangeNum; l++) {
										if(arr[k - l] == sorted[j] && arr[j] > arr[j + 1]) {
											k = k - l;
										} else {
											break;
										}
									}
									int temp = arr[k];
									arr[k] = arr[j];
									arr[j] = temp;
									break;
								}
							}	
							break;
						}
					}
				}
			}
			sb.append(Arrays.toString(arr).replace(", ", "").replace("[", "").replace("]", ""));
			sb.append("\n");
		}

		System.out.println(sb);
	}
}