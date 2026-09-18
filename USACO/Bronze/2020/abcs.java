import java.io.*;
import java.util.*;

public class abcs {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] intStrings = br.readLine().split(" ");
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ints.add(Integer.parseInt(intStrings[i]));
        }

        Collections.sort(ints);

        // least = a, 2nd least = b, c = most - (a + b)
        System.out.printf("%d %d %d", ints.get(0), ints.get(1), ints.get(6) - (ints.get(0) + ints.get(1)));

        pw.close();
        br.close();
    }
}