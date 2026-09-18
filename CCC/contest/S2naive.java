import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());

        boolean illuminated[] = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            illuminated[i] = false;
        }

        for (int i = 0; i < l; i++) {
            String[] ps = br.readLine().split(" ");
            int pi = Integer.parseInt(ps[0]);
            int si = Integer.parseInt(ps[1]);
            
            for (int j = Math.max(0, pi - si); j <= Math.min(n, pi + si); j++) {
                illuminated[j] = true;
            }
        }

        for (int i = 0; i < q; i++) {
            if (illuminated[Integer.parseInt(br.readLine())]) {
                pw.println("Y");
            } else {
                pw.println("N");
            }
        }

        pw.close();
    }
}