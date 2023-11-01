import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T;
        T = Integer.parseInt(bf.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(bf.readLine());
            int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Set<Integer> set = new HashSet<>();
            set.add(0);

            for(int i = 0; i < arr.length; i++) {
                Set<Integer> copy = new HashSet<>();
                copy.addAll(set);

                Iterator it = copy.iterator();
                while(it.hasNext()) {
                    int num = (int) it.next();
                    set.add(num + arr[i]);
                }
                set.add(arr[i]);
            }

            int size = set.size();
            sb.append("#" + test_case + " " + size + "\n");
        }

        System.out.println(sb);
    }
}