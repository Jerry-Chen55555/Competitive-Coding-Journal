import java.util.*;
import java.io.*;

public class DoYouKnowABC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int[] ints = new int[7];
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = -1;
        int sumIndex = -1;
        for (int i = 0; i < 7; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
            if (ints[i] > sum) {
                sum = ints[i];
                sumIndex = i;
            }
        }
        for (int i = 0; i < 7; i++) {
            if (i == sumIndex) {
                continue;
            }
            for (int j = i + 1; j < 7; j++) {
                if (j == sumIndex) {
                   continue;
                }
                if (ints[i] + ints[j] == sum) {
                    ans.add(Arrays.asList(ints[i], ints[j]));
                    break;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (ans.get(0).get(i) + ans.get(1).get(j) + ans.get(2).get(k) == sum) {
                        int[] sort = {ans.get(0).get(i), ans.get(1).get(j), ans.get(2).get(k)};
                        Arrays.sort(sort);
                        pw.println(sort[0] + " " + sort[1] + " " + sort[2]);
                    }
                }
            }
        }
        pw.close();
    }
}