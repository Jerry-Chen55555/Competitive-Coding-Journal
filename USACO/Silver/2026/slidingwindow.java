import java.io.*;
import java.util.*;

public class slidingwindow {
    public static int[] solve(int n, int k, String r) {
        int min = 0;
        int max = 0;

        int[] sames = new int[k];
        int[] differents = new int[k];
        for (int i = 0; i < k; i++) {
            sames[i] = 1;
            differents[i] = 0;
        }

        // list of same as or different to pos n % k
        // same = 0, different = 1
        int[] b = new int[n];
        for (int i = 0; i < k; i++) {
            b[i] = 0;
        }
        for (int i = 1; i < r.length(); i++) {
            int checkPos = i - 1;
            int currPos = i + k - 1;
            if (r.charAt(i - 1) == r.charAt(i)) {
                // same as
                b[currPos] = b[checkPos];
            } else {
                // different
                b[currPos] = (b[checkPos] + 1) % 2;
            }
            if (b[currPos] == 0) {
                sames[currPos % k]++;
            } else {
                differents[currPos % k]++;
            }
        }

        // difference between differents and sames
        int[] differences = new int[k];
        Integer[] index = new Integer[k];
        for (int i = 0; i < k; i++) {
            differences[i] = sames[i] - differents[i];
            index[i] = i;
        }

        Arrays.sort(differences);

        // System.out.println(Arrays.toString(differences));
        // System.out.println(Arrays.toString(sames));
        // System.out.println(Arrays.toString(differents));

        for (int i = 0; i < sames.length; i++) {
            min += differents[i];
            max += differents[i];
        }

        int[] ret = {min, max};

        if (Integer.parseInt("" + r.charAt(0)) == 0) {
            for (int i = 0; i < differences.length - 1; i+=2) {
                min+= differences[i];
                min+= differences[i + 1];
                ret[0] = Math.min(ret[0], min);
            }
            for (int i = differences.length - 1; i >= 1; i-=2) {
                max+= differences[i];
                max+= differences[i - 1];
                ret[1] = Math.max(ret[1], max);
            }
        } else {
            min += differences[0];
            ret[0] = min;
            for (int i = 1; i < differences.length - 1; i+=2) {
                min+= differences[i];
                min+= differences[i + 1];
                ret[0] = Math.min(ret[0], min);
            }
            max += differences[differences.length - 1];
            ret[1] = max;
            for (int i = differences.length - 2; i >= 1; i-=2) {
                max+= differences[i];
                max+= differences[i - 1];
                ret[1] = Math.max(ret[1], max);
            }
        }

        return ret;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] nq = br.readLine().split(" ");
            int n = Integer.parseInt(nq[0]);
            int k = Integer.parseInt(nq[1]);
            String r = br.readLine();

            int[] sols = solve(n, k, r);
            pw.println(sols[0] + " " + sols[1]);
        }

        pw.close();
        br.close();
    }
}
