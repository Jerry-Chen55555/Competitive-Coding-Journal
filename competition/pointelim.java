import java.util.*;
import java.io.*;

public class pointelim {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n % 2 == 1) {
                pw.println("NO1");
                continue;
            }
            ArrayList<Integer> xs = new ArrayList<>();
            HashMap<Integer, Integer> ys = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String[] xyStrings = br.readLine().split(" ");
                int x = Integer.parseInt(xyStrings[0]);
                int y = Integer.parseInt(xyStrings[1]);
                xs.add(x);
                ys.put(y, ys.getOrDefault(y, 0) + 1);
            }
            boolean cond = true;
            for (Integer a : ys.keySet()) {
                if (ys.get(a) % 2 == 1) {
                    cond = false;
                    break;
                }
            }
            if (!cond) {
                pw.println("NO2");
                continue;
            }
            Collections.sort(xs);
            for (int j = 0; j < xs.size(); j+=2) {
                if (xs.get(j) + 1 != xs.get(j+1)) {
                    cond = false;
                    break;
                }
            }
            if (!cond) {
                pw.println("NO3");
                continue;
            }
            pw.println("YES");
        }

        pw.close();
        br.close();
    }
}
