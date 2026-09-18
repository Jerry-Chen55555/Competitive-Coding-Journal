import java.util.*;
import java.io.*;

public class triangles {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter pw = new PrintWriter("triangles.out");

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer("aaa");
        ArrayList<int[]> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int[] xy = {x, y};
            points.add(xy);
        }

        int max = 0;

        for (int[] a : points) {
            for (int[] b :points) {
                for (int[] c : points) {
                    if (a[0] == b[0] && c[1] == a[1]) {
                        max = Math.max(max, Math.abs(a[1] - b[1])* Math.abs(c[0]-a[0]));
                    }
                }
            }
        }

        pw.println(max);
        pw.close();
    }
}