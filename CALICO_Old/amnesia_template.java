import java.io.*;

class amnesia_template {
    static BufferedReader br;
    /**
     * Phase 1: Initialize N.
     * 
     * Return a string of digits denoting the initial persistent value.
     */
    static String start() { 
        return "0000";
    }

    /**
     * Phase 2: Observe each brick.
     * 
     * N: a digit string denoting the persistent value from the previous run
     * color: a letter ("B", "S", or "G") denoting the color of the current
     * brick
     * 
     * Return a string of digits denoting the updated persistent value for the
     * next run. This string must have the same length as the given N.
     */
    static String observe(String N, String color) {
        int newVal;
        if (color.equals("G")) {
            newVal = Integer.parseInt(N.substring(0, 2)) + 1;
            if (newVal == 100) {
                newVal = 60;
            }
            N = String.format("%02d", newVal) + N.substring(2);
        } else if (color.equals("S")) {
            newVal = Integer.parseInt(N.substring(2, 4)) + 1;
            if (newVal == 100) {
                newVal = 60;
            }
            N = N.substring(0, 2) + String.format("%02d", newVal);
        }

        return N;
    }

    /**
     * Phase 3: Submit the final answer.
     * 
     * N: a digit string denoting the persistent value from the previous run
     * 
     * Return a string of length 3 containing each of the characters "B", "S",
     * and "G" exactly once, denoting the types from least to most frequent. For
     * example, if silver was the least frequent, gold was in the middle, and
     * bronze was the most frequent, then you should output 'SGB'
     */
    static String answer(String N) {
        char[] result = {' ', ' ', ' '};
        
        int G = Integer.parseInt(N.substring(0, 2));
        int S = Integer.parseInt(N.substring(2, 4));
        
        // find in range
        if (G > 40 && G < 60) {
            result[0] = 'G';
        } else if (G > 75 && G < 95) {
            result[1] = 'G';
        } else {
            result[2] = 'G';
        }

        if (S > 40 && S < 60) {
            result[0] = 'S';
        } else if (S > 75 && S < 95) {
            result[1] = 'S';
        } else {
            result[2] = 'S';
        }

        // add bronze
        for (int i = 0; i < 3; i++) {
            if (result[i] == ' ') {
                result[i] = 'B';
            }
        }
        

        // return
        String stringResult = "";
        for (int i = 0; i < 3; i++) {
            stringResult += result[i];
        }
        
        return stringResult;
    }

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String phase = in.readLine();
        if (phase.equals("START")) {
            out.println(start());
        } else if (phase.equals("OBSERVE")) {
            String N = in.readLine();
            String color = in.readLine();
            out.println(observe(N, color));
        } else {
            String N = in.readLine();
            out.println(answer(N));
        }
        out.flush();
    }
}
