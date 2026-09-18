package Day2;

import java.io.*;

public class solution1 {
    static long nextInvalid(String s) {
        // get the next invalid index higher than s
        long a = Long.parseLong(s);
        if (s.length() % 2 == 1) {
            String b = "1";
            for (int i = 0; i < (s.length() -1) /2; i++) {
                b += "0";
            }
            return Long.parseLong(b + b);
        } else {
            String b = s.substring(0, s.length()/2);
            long c = Long.parseLong(b + b);
            while (c <= a) {
                b = "" + (Long.parseLong(b) + 1);
                return Long.parseLong(b + b);
            }

            return c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Day2/actual.txt"));
        PrintWriter pw = new PrintWriter(System.out);

        long sum = 0;

        String[] rangeStrings = br.readLine().split(",");
        double startTime = System.nanoTime();
        for (String string : rangeStrings) {
            int dashIndex = string.indexOf("-");
            long num1 = Long.parseLong(string.substring(0, dashIndex));
            long num2 = Long.parseLong(string.substring(dashIndex + 1));
            
            for (long i = num1; i <= num2; i++) {
                String n = "" + i;
                if (n.length() % 2 == 0 && 
                n.substring(0, n.length()/2).equals(n.substring(n.length()/2))) {
                    sum += i;
                }
            }
        }
        System.out.println("first time: " + (System.nanoTime() - startTime)/1000000000);
        System.out.println(sum);
        sum = 0;
        startTime = System.nanoTime();
        for (String string : rangeStrings) {
            int dashIndex = string.indexOf("-");
            long num1 = Long.parseLong(string.substring(0, dashIndex));
            long num2 = Long.parseLong(string.substring(dashIndex + 1));

            long next = num1 - 1;
            next = nextInvalid("" + next);
            while (next <= num2) {
                sum += next;
                next = nextInvalid("" + next);
            }
        }

        System.out.println("second time: " + (System.nanoTime() - startTime)/1000000000);
        System.out.println(sum);
        
        pw.close();
        br.close();
    }
}

// 55916882972

// solution2 about 20x faster