import java.io.*;

class fries_template {
    /**
     * Return the score of S amplified K times
     * 
     * L: Length of bag string
     * N: Target depth
     * S: Bag string (characters can be '(', ')', '|', or 'O')
     */
    static int solve(int L, int N, String S, int Layers) {
        if (N < 0) {
            return 0;
        }
        int r = 0;

        int currLayer = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                currLayer++;
            } else if (S.charAt(i) == ')'){
                currLayer--;
            } else if (S.charAt(i) == '|') {
                if (currLayer <= N) {
                    r++;
                }
            } else if (S.charAt(i) == 'O') {
                r += solve(L, N - currLayer, S, Layers);
            }
        }

        return r;
    }
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            String[] temp = in.readLine().split(" ");
            int L = Integer.parseInt(temp[0]);
            int N = Integer.parseInt(temp[1]);
            String S = in.readLine();
            int layers = 0;
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j)== '(') {
                    layers++;
                }
            }
            out.println(solve(L, N, S, layers));
        }
        out.flush();
    }
}