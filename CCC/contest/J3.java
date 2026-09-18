import java.io.*;
import java.util.Arrays;
import java.util.HashMap;


public class J3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ngoc = br.readLine();
        String minh = br.readLine();
        int nIndex = 0;
        int mIndex = 0;

        int n = 0, m = 0;
        HashMap<Character, Integer> candies = new HashMap<>();
        candies.put('R', 0);
        candies.put('G', 1);
        candies.put('B', 2);
        while (ngoc.length() > nIndex && minh.length() > mIndex) {
            if (ngoc.charAt(nIndex) == minh.charAt(mIndex)) {
                n++;
                m++;
                nIndex++;
                mIndex++;
            } else if (candies.get(ngoc.charAt(nIndex)) == (candies.get(minh.charAt(mIndex)) + 1) % 3) {
                m++;
                nIndex++;
            } else {
                n++;
                mIndex++;
            }
        }


        n += ngoc.length() - nIndex;
        m += minh.length() - mIndex;

        System.out.println(n);
        System.out.println(m);
    }
}
