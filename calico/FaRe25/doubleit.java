import java.io.*;

public class doubleit {
    public static int solve(int n, String s) {
        int r = 0;
        int p = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'T') {
                r += p;
                p = 1;
            } else if(s.charAt(i) == 'D') {
                p *= 2;
            }
        }

        return r;
    }
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            out.println(solve(N, S));
        }
        out.flush();
    }
}
