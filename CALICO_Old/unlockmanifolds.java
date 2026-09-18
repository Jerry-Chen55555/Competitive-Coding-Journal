import java.io.*;

class unlockmanifolds {
    /**
     * Return the minimum number of actions
     * 
     * N: a non-negative integer representing the number of rows
     * M: another non-negative integer representing the number of columns
     * G: N x M array representing a grid
     */
    static int solve(int N, int M, int[][] G) {
        int[][] sorted = new int[N*M][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sorted[G[i][j] - 1][0] = i;
                sorted[G[i][j] - 1][1] = j;
            }
        }

        int[] currIndex = {0, 0};
        int result = 0;

        for (int i = 0; i < sorted.length; i++) {
            result += Math.min(Math.abs(currIndex[0] - sorted[i][0]), N - Math.abs(currIndex[0] - sorted[i][0]));
            result += Math.min(Math.abs(currIndex[1] - sorted[i][1]), M - Math.abs(currIndex[1] - sorted[i][1]));
            
            currIndex[0] = sorted[i][0];
            currIndex[1] = sorted[i][1];
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
            int[][] G = new int[N][M];
            for (int j = 0; j < N; j++) {
                temp = in.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    G[j][k] = Integer.parseInt(temp[k]);
                }
            }
            out.println(solve(N, M, G));
        }
        out.flush();
    }
}