import java.io.*;

class birthday_template {
    /**
     * Return the number of days between Year 0 and Big Ben's Birthday
     *
     * N: The number of years before Big Ben's Birthday
     */
    static long solve(long N) {
        return ((2*N*N*N + 3*N*N + N) / 6) - N;
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
