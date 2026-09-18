import java.util.*;
import java.io.*;

public class FencePainting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        PrintWriter pw = new PrintWriter("paint.out");

        StringTokenizer st = new StringTokenizer(br.readLine());

        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int three = Integer.parseInt(st.nextToken());
        int four = Integer.parseInt(st.nextToken());

        int res = two - one + four - three;

        if (one > three) {
            res -= Math.max(0, four - one);
            res += Math.max(0, four - two);
        } else {
            res -= Math.max(0, two - three);
            res += Math.max(0, two - four);
        }

        pw.println(res);

        pw.close();
        br.close();
    }
}