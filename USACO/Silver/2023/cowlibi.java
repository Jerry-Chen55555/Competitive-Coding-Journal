import java.util.*;
import java.io.*;

public class cowlibi {
    static boolean isNotInRange(int a, int b, int length) {
        return a * a + b * b >= length * length;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] gx = new int[g];
        int[] gy = new int[g];
        int[] gt = new int[g];

        for (int i = 0; i < g; i++) {
            st = new StringTokenizer(br.readLine());
            gx[i] = Integer.parseInt(st.nextToken());
            gy[i] = Integer.parseInt(st.nextToken());
            gt[i] = Integer.parseInt(st.nextToken());
        }

        
        

        int count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            int gIndex = Collections.binarySearch(Arrays.asList(gs), c);
            if (gIndex < 0) {
                gIndex *= -1;
                gIndex -= 1;
            }

            if (gIndex < gs.length && Math.abs(gs[gIndex].x - c.x) + Math.abs(gs[gIndex].y - c.y) > Math.abs(gs[gIndex].t - c.t)) {
                count++;
            } else if (gIndex > 0 && Math.abs(gs[gIndex - 1].x - c.x) + Math.abs(gs[gIndex - 1].y - c.y) > Math.abs(gs[gIndex - 1].t - c.t)) {
                count++;
            }
        }

        pw.println(count);

        pw.close();
        br.close();
    }
}