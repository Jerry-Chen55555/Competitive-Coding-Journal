import java.io.*;

class scv_template {
    /**
     * Return the shape of displayed by ASCII string G of dimensions N x M
     *
     * G: a string representing an ASCII picture
     * N: integer for number of rows
     * M: integer for number of columns
     */
    static String solve(int N, int M, String[] G) {
        int firstLength = 0;
        int currLength = 0;
        for (int i = 0; i < N; i++) {
            currLength = 0;
            for (int j = 0; j < M; j++) {
                if (G[i].charAt(j) == '#') {
                    currLength++;
                }
            }
            if (firstLength == 0) {
                firstLength = currLength;
            } else {
                if (currLength != firstLength) {
                    return "phineas";
                } else {
                    return "ferb";
                }
            }
        }

        return "ferb";
    }
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            String[] dimensions = in.readLine().split(" ");
            int N = Integer.parseInt(dimensions[0]), M = Integer.parseInt(dimensions[1]);
            String[] G = new String[N];
            for (int j = 0; j < N; j++) {
                String row = in.readLine();
                G[j] = row;
                }
            out.println(solve(N, M, G));
            }
        out.flush();
        }
    }
