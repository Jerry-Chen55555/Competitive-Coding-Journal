import java.util.*;
import java.io.*;

public class productivity {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] c = new int[n];
        int[] t = new int[n];
        int[] d = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            d[i] = c[i] - t[i] - 1;
        }
        
        Arrays.sort(d);

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            
            int a = Arrays.binarySearch(d, s);
            int b = a;
            if (b < 0) {
                b = -1 * (b + 1);
            } else {
                while (d[a] == d[b]) {
                    b--;
                }
                b++;
            }
            b = n - b;
            if (b >= v) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }

        pw.close();
        br.close();
    }
}
