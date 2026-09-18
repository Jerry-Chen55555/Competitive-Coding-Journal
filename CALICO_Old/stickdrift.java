import java.io.*;

class Solution {
    static void changeCurrseq(int[] currSeq, char change) {
        if (change == 'R') currSeq[1]++;
        if (change == 'L') currSeq[1]--;
        if (change == 'U') currSeq[0]--;
        if (change == 'D') currSeq[0]++;
    }
    /**
     * Return the minimum number of actions
     * 
     * N: a non-negative integer representing the number of rows
     * M: another non-negative integer representing the number of columns
     * S: A string representing a sequence of drift inputs
     * G: N x M array representing a grid
     */
    static int solve(int N, int M, String S, int[][] G) {
        int[][] sorted = new int[N*M + 1][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sorted[G[i][j]][0] = i;
                sorted[G[i][j]][1] = j;
            }
        }

        int result = 0;
        int currDrift = 0;
        int[] currSequence = {0, 0};

        for (int i = 1; i < sorted.length; i++) {
            // type less
            int cX = sorted[i][0], cY = sorted[i][1], pX = sorted[i][0], pY = sorted[i][1];

            
            boolean found = false;
            int beforeCurrDrift = currDrift - 1;
            while (currDrift != beforeCurrDrift) {
                // i forgot solution just put 413879 for fun
                if (Math.min(Math.abs(cX - pX), N - Math.abs(cX - pX)) + Math.min(Math.abs(cY - pY), N - Math.abs(cY - pY)) <= 413879)
                changeCurrseq(currSequence, S.charAt(currDrift));
                currDrift++;
                if (currDrift == S.length()) currDrift = 0;
            }

            
        }

        return result;
    }
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            String[] temp = in.readLine().split(" ");
            int N = Integer.parseInt(temp[0]), M = Integer.parseInt(temp[1]);
            String S = in.readLine();
            int[][] G = new int[N][M];
            for (int j = 0; j < N; j++) {
                temp = in.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    G[j][k] = Integer.parseInt(temp[k]);
                }
            }
            out.println(solve(N, M, S, G));
        }
        out.flush();
    }
}