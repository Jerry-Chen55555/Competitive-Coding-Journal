import java.io.*;
import java.util.*;

class bigben {
    /**
     * Return a length 2 List containing the coordinates X and Y.
     * 
     * N: a positive integer, the address of your house
     */
    static List<Integer> solve(int N) {
        int[] x = {0, 1,1,2,1,3,1,2,3,4,1,5,1,2,3,4,5,6,1,3,5,7,1,2,4,5,7,8,1,3,7,9,1,2,3,4,5,6,7,8,9,10,1,5,7,11,1,2,3,4,5,6,7,8,9,10,11,12,1,3,5,9,11,13,1,2,4,7,8,11,13,14,1,3,5,7,9,11,13,15,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,1,5,7,11,13,17,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        int[] y = {0, 1,2,1,3,1,4,3,2,1,5,1,6,5,4,3,2,1,7,5,3,1,8,7,5,4,2,1,9,7,3,1,10,9,8,7,6,5,4,3,2,1,11,7,5,1,12,11,10,9,8,7,6,5,4,3,2,1,13,11,9,5,3,1,14,13,11,8,7,4,2,1,15,13,11,9,7,5,3,1,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,17,13,11,7,5,1,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        return Arrays.asList(x[N], y[N]);
    }
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            String[] temp = in.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            List<Integer> ans = solve(N);
            out.println(ans.get(0) + " " + ans.get(1));
        }
        out.flush();
    }
}
