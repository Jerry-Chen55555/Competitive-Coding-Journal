package NextBase;

import java.util.*;

public class NextBase {
    public static String toBase(int a, int base) {
        String result = "";

        while (a > 0) {
             result = a % base + result;
             a /= base;
        }

        return result;
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        String[] intStrings = in.nextLine().split(" ");

        int n = Integer.parseInt(intStrings[0]);
        int b = Integer.parseInt(intStrings[1]);
        int sten = Integer.parseInt(intStrings[2], b);
        String s = intStrings[2];
    

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (Integer.parseInt(""+s.charAt(j)) == b - 1) {
                    count++;
                }
            }

            sten++;
            
            s = toBase(sten, b);

            System.out.println(s);
            
        }

        System.out.println(count);

        in.close();
    }
}