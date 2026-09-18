package Day2;

import java.io.*;

public class solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day2/actual.txt"));
        PrintWriter pw = new PrintWriter(System.out);

        long sum = 0;

        String[] rangeStrings = br.readLine().split(",");
        for (String string : rangeStrings) {
            int dashIndex = string.indexOf("-");
            long num1 = Long.parseLong(string.substring(0, dashIndex));
            long num2 = Long.parseLong(string.substring(dashIndex + 1));
            
            for (long i = num1; i <= num2; i++) {
                String n = "" + i;
                boolean valid = true;
                for (int j = 1; j < n.length(); j++) {
                    if (n.length() % j == 0) {
                        boolean goon = false;
                        for (int k = 0; k < (n.length()/j) - 1; k++) {
                            if (!(n.substring(k*j, (k + 1)*j)
                                .equals(n.substring((k+1)*j, (k+2)*j)))) {
                                    goon = true;
                            }
                        }
                        if (!goon) {
                            valid = false;
                            break;
                        }
                    }
                }
                if (!valid) {
                    sum += i;
                }
            }
        }
        

        pw.println(sum);
        pw.close();
        br.close();
    }
}

// 