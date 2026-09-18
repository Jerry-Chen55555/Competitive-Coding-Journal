import java.util.*;
import java.io.*;

public class canefeast {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);


        // get input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] cowHeights = new long[N];
        long[] caneHeights = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cowHeights.length; i++) {
            cowHeights[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < caneHeights.length; i++) {
            caneHeights[i] = Long.parseLong(st.nextToken());
        }

        // brute force
        for (int caneIndex = 0; caneIndex < caneHeights.length; caneIndex++) {
            long initialCaneHeight = caneHeights[caneIndex];
            for (int cowIndex = 0; cowIndex < cowHeights.length; cowIndex++) {
                long caneEaten;
                if (cowHeights[cowIndex] >= initialCaneHeight) {
                    caneEaten = caneHeights[caneIndex];
                    cowHeights[cowIndex] += caneEaten;
                    caneHeights[caneIndex] -= caneEaten;
                    break;
                }
                else {
                    caneEaten = Math.max(caneHeights[caneIndex] + cowHeights[cowIndex] - initialCaneHeight, 0);
                    cowHeights[cowIndex] += caneEaten;
                    caneHeights[caneIndex] -= caneEaten;
                }
            }
        }

        for (long l : cowHeights) {
            pw.println(l);
        }

        br.close();
        pw.close();
    }
}