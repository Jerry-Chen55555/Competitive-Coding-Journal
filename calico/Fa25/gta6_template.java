import java.io.*;

class gta6_template {
    /*
     * E: The name of the event
     * Y: Year
     * M: Month
     * D: Day
     */
    static String solve(String E, int Y, int M, int D) {
        String after = "we got gta6 before " + E;
        String before = "we got " + E  + " before gta6";

        if (Y == 2026) {
            if (M == 11) {
                if (D > 19) {
                    return after;
                } else {
                    return before;
                }
            } else if (M < 11) {
                return before;
            } else {
                return after;
            }
        } else if (Y < 2026) {
            return before;
        } else {
            return after;
        }
    }
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            String E = in.readLine();   
            String[] temp = in.readLine().split(" ");
            int Y = Integer.parseInt(temp[0]), M = Integer.parseInt(temp[1]), D = Integer.parseInt(temp[2]);
            out.println(solve(E, Y, M, D));
        }
        out.flush();
    }
}

