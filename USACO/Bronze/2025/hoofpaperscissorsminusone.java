import java.io.*;
import java.util.*;

public class hoofpaperscissorsminusone {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] rules = new char[n+1][n+1];

        for (int i = 1; i < n + 1; i++) {
            String s = br.readLine();
            for (int j = 1; j < s.length() + 1; j++) {
                Character c = s.charAt(j - 1);
                rules[i][j] = c;
                if (c == 'W') {
                    rules[j][i] = 'L';
                } else if (c == 'L') {
                    rules[j][i] = 'W';
                } else {
                    rules[j][i] = 'L';
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ret = 0;
            for (int j = 1; j <= n; j++) {
                if (rules[j][a] == 'W' && rules[j][b] == 'W') {
                    ret++;
                }
            }
            if (ret == 0) {
                pw.println(0);
            } else {
                pw.println((2*ret * n) - ret*ret);
            }
        }

        pw.close();
    }
}
