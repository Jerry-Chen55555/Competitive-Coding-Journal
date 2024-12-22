import java.util.*;
import java.io.*;;

public class Candy_Cane_Feast {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(firstLine.nextToken());
        int m = Integer.parseInt(firstLine.nextToken());

        long[] cows = new long[n];
        long[] canes = new long[m];
        StringTokenizer secondLine = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cows[i] = Long.parseLong(secondLine.nextToken());
        }
        StringTokenizer thirdLine = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            canes[i] = Long.parseLong(thirdLine.nextToken());
        }

        long currCandyStart = 0, currCandyEnd = 0, newCandyStart;

        for (int i = 0; i < m; i++) {
            currCandyStart = 0;
            currCandyEnd = canes[i];
            for (int j = 0; j < n; j++) {
                if (cows[j] > currCandyStart) {
                    newCandyStart = cows[j] - Math.max(0, cows[j] - currCandyEnd);
                    cows[j] += cows[j] - currCandyStart - Math.max(0, cows[j] - currCandyEnd);
                    currCandyStart = newCandyStart;
                }
                if (currCandyStart == currCandyEnd) {
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            pw.println(cows[i]);
        }

        pw.close();
        br.close();
    }
}