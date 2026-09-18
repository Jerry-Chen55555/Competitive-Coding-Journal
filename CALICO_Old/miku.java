import java.io.*;
import java.util.*;

class miku {
    /**
     * Return the number of subsequences of owo and uwu
     * 
     * S: string of characters
     */
    static long solve(String S) {
        int uLeft = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'u') uLeft++;
        }

        long total = 0;
        int uMultiplier = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'u') {
                uLeft--;
                uMultiplier++;
            } else if (S.charAt(i) == 'w') {
                total += uMultiplier * uLeft;
                uMultiplier = 0;
            }
        }

        return total;
    }
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            String S = in.readLine();
            out.println(solve(S));
        }
        out.flush();
    }
}