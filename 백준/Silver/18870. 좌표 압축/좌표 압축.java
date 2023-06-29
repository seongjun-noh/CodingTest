import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bf.readLine());
		int[] data = new int[testCase];
		HashMap<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < testCase; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int[] clone = Arrays.copyOf(data, testCase);
		Arrays.sort(clone);
		int index = 0;
		for(int n : clone) {
			if(!map.containsKey(n)) {
				map.put(n, index);
				index++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < testCase; i++) {
			sb.append(map.get(data[i])).append(" ");
		}
		System.out.println(sb);
	}

}