import java.io.*;

public class mooclearreactor {
    public static int solve(int n, int m, int[] r, int[] l, int[][] ms) {
        int[] values = new int[ms.length];
        int ret = 0;
        for (int i = 0; i < ms.length; i++) {
            values[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < ms.length; i++) {
            if (values[ms[i][0] - 1] == Integer.MAX_VALUE) {
                values[i] = ms[i][2] / 2;
                if (values[i] >= l[i] && values[i] <= r[i]) {
                    ret++;
                }
            } else if (values[i] != ms[i][2] * 2) {
                return -1;
            }
        }

        for (int i = 0; i < values.length; i++) {
            if (values[i] == Integer.MAX_VALUE) {
                ret++;
            }
        }

        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int[] l = new int[n];
            int[] r = new int[n];
            String[] lString = br.readLine().split(" ");
            String[] rString = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                l[j] = Integer.parseInt(lString[j]);
                r[j] = Integer.parseInt(rString[j]);
            }
            int[][] ms = new int[m][3];
            for (int j = 0; j < m; j++) {
                String[] mString = br.readLine().split(" ");
                ms[j][0] = Integer.parseInt(mString[0]);
                ms[j][1] = Integer.parseInt(mString[1]);
                ms[j][2] = Integer.parseInt(mString[2]);
            }

            pw.println(solve(n, m, r, l, ms));
        }

        br.close();
        pw.close();
    }
}