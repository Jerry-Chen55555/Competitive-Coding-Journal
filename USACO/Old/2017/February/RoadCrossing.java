import java.util.*;
import java.io.*;

public class RoadCrossing {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("crossroad.in"));
        PrintWriter pw = new PrintWriter("crossroad.out");

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        HashMap<Integer, Integer> cows = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            if (cows.get(cow) == null) {
                cows.put(cow, road);
            }
            if (cows.get(cow) != road) {
                res++;
                cows.put(cow, (cows.remove(cow) + 1) % 2);
            }
        }
        pw.println(res);
        pw.close();
        br.close();
    }
}