import java.util.*;
import java.io.*;

public class S1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        long a = Long.parseLong(br.readLine());
        long b = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());
        long t = Long.parseLong(br.readLine());
        
        long diff = Math.abs(b - a);

        long bigHops = diff / k;
        long smallHops = diff % k;

        long bigHops2 = (diff / k) + 1;
        long smallHops2 = k - smallHops;

        if (t == 1) {
            System.out.println(Math.min(smallHops + bigHops, smallHops2 + bigHops2));
        } else {
            if (smallHops + bigHops == smallHops2 + bigHops2) {
                System.out.println(Math.min(smallHops + bigHops, smallHops2 + bigHops2) + 2);
            } else {
                System.out.println(Math.min(
                    Math.max(smallHops + bigHops, smallHops2 + bigHops2),
                    Math.min(smallHops + bigHops, smallHops2 + bigHops2) + 2));
            }
        }
    }
}
