import java.util.*;
import java.io.*;

public class makingmexes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> f = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            f.put(i, 0);
        }
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            f.put(a, f.get(a) + 1);
        }
        
        int count = 0;
        for (int i = 0; i <= n; i++) {
            pw.println(Math.max(f.get(i), count));
            if (f.get(i) == 0) {
                count++;
            }
        }

        pw.close();
        br.close();
    }
}
