import java.util.*;
import java.io.*;

public class SpeedingTicket {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter("speeding.out");

        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nSegments = new int[100];
        int[] mSegments = new int[100];
        int buildStart = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = buildStart; j < length + buildStart; j++) {
                nSegments[j] = speed;
            }
            buildStart += length;
        }
        buildStart = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = buildStart; j < length + buildStart; j++) {
                mSegments[j] = speed;
            }
            buildStart += length;
        }

        for (int i = 0; i < 100; i++) {
            max = Math.max(max, mSegments[i] - nSegments[i]);
        }

        pw.println(max);
         

        pw.close();
        br.close();
    }
}