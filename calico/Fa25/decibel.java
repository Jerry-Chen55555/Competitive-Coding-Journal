import java.io.*;

class Solution {
    /**
     * Return the score of S amplified K times
     * 
     * S: string to amplify
     * K: integer for number of times to amplify
     */
    static long solve(String S, int K) {
        
        // "digit" sum of letter types
        long dl = 0;
        long du = 0;
        // number of letter types
        long nl = 0;
        long nu = 0;
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (c >= 'a') {
                dl += c - 'a' + 1;
                nl++;
            } else {
                du += c - 'A' + 1;
                nu++;
            }
        }
        // System.out.println(dl);
        // System.out.println(du);
        // System.out.println(nl);
        // System.out.println(nu);

        // r =
        // number uppercase for lowercase = #l * fib[K] * 26
        // number uppercase for uppercase = #u * fib[K + 1] * 26
        // total = number 
        long r = 0;
        r += nl * fib[K] * 26;
        r += nu * fib[K + 1] * 26;
        r += dl * fib[K + 1];
        r += du * fib[K + 2];
        return (r % 998244353L);
    }
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static long[] fib = new long[10005];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());

        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < 10005; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 998244353L;
            
        }

        for (int i = 0; i < T; i++) {
            String[] temp = in.readLine().split(" ");
            String S = temp[0]; 
            int K = Integer.parseInt(temp[1]);
            out.println(solve(S, K));
        }
        out.flush();
    }
}
