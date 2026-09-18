import java.util.*;
import java.io.*;

public class rotations {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[2 * n];
        HashSet<Integer> d = new HashSet<>();

        String[] aStrings = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int ai = Integer.parseInt(aStrings[i]);
            a[i] = ai;
            a[n + i] = ai;
            d.add(ai);
        }

        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = n + 1;
        }

        HashMap<Integer, Integer> start = new HashMap<>();
        int currD = 0;
        for (int i : d) {
            start.put(i, 0);
        }
        for (int i = 0; i < d.size(); i++) {
            start.put(a[i], start.get(a[i]) + 1);
            if (start.get(a[i]) == 1) {
                currD++;
            }
        }
        
        for (int i = d.size(); i <= n; i++) {

            for (int j = 0; j < n; j++) {
                // System.out.println("i: " + i + " j: " + j + " start: " + start + " currD: " + currD);
                if (currD == d.size()) {

                    for (int j2 = 0; j2 < i/2; j2++) {
                        ret[(j+j2) % n] = Math.min(ret[(j+j2) % n], j2 + i);
                    }
                    for (int j2 = i/2; j2 < i; j2++) {
                        ret[(j+j2) % n] = Math.min(ret[(j+j2) % n], (i - j2) + i - 1);
                    }
                }
                
                start.put(a[j], start.get(a[j]) - 1);
                if (start.get(a[j]) == 0) {
                    currD--;
                }
                start.put(a[j + i], start.get(a[j + i]) + 1);
                if (start.get(a[j + i]) == 1) {
                    currD++;
                }
            }

            start.put(a[i], start.get(a[i]) + 1);
            if (start.get(a[i]) == 1) {
                currD++;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            pw.print((ret[i] - 1) + " ");
        }
        pw.print(ret[n - 1] - 1);


        br.close();
        pw.close();
    }
}