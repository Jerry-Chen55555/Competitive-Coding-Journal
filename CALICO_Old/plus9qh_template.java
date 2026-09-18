import java.io.*;

class plus9qh_template {
    /**
     * Find an HQ9+ program that outputs exactly the given text or return
     * IMPOSSIBLE if no solutions exist.
     * 
     * N: the number of lines of text
     * X: a list containing the lines of the text
     */
    static String solve(int N, String[] X) {
        String currInstructions = "";
        String foundQuine = "";
        for (int i = 0; i < N; i++) {
            if (X[i].equals("Hello, world!")) {
                currInstructions += "H";
            } else if (X[i].equals("99 bottles of beer on the wall, 99 bottles of beer.")) {
                if (!(i <= N - 6
                && X[i + 1].equals("Take one down and pass it around, 98 bottles of beer on the wall.")
                && X[i + 2].equals("98 bottles of beer on the wall, 98 bottles of beer.")
                && X[i + 3].equals("Take one down and pass it around, 97 bottles of beer on the wall.")
                && X[i + 4].equals("97 bottles of beer on the wall, 97 bottles of beer.")
                && X[i + 5].equals("Take one down and pass it around, 96 bottles of beer on the wall."))) {
                    return "IMPOSSIBLE";
                }
                i += 5;
                currInstructions += "9";
            } else if (X.length > 0 && (X[i].charAt(0) == '+'
            || X[i].charAt(0) == '9'
            || X[i].charAt(0) == 'Q'
            || X[i].charAt(0) == 'H')) {
                if (foundQuine.equals("")) {
                    foundQuine = X[i];
                }
                if (!X[i].equals(foundQuine)) {
                    return "IMPOSSIBLE";
                }
                currInstructions += "Q";
            } else {
                return "IMPOSSIBLE";
            }
        }

        if (!foundQuine.equals("")) {
            String checkQuine = "";
            for (int i = 0; i < foundQuine.length(); i++) {
                if (foundQuine.charAt(i) != '+') {
                    checkQuine += foundQuine.charAt(i);
                }
            }

            if (!currInstructions.equals(checkQuine)) {
                return "IMPOSSIBLE";
            }

            return foundQuine;
        }
        
        return currInstructions;
    }
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(in.readLine());
            String[] X = new String[N];
            for (int j = 0; j < N; j++) {
                X[j] = in.readLine();
            }
            out.println(solve(N, X));
        }
        out.flush();
    }
}
