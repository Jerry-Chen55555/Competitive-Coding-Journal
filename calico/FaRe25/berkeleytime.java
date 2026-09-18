import java.io.*;

public class berkeleytime {
    /**
     * Return the appropriate text given the contest will start N minutes late.
     * 
     * N: the number of minutes late the contest will start
     */
    static String solve(int s) {
        if (s == 0) {
            return "haha good one";
        } else if (s >= 180) {
            return "canceled";
        } else {
            String ret = "";
            for (int i = 0; i < s/10; i++) {
                ret += "berkeley";
            }

            return ret + "time";
        }
    }
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(in.readLine());
            out.println(solve(N));
        }
        out.flush();
    }
}
