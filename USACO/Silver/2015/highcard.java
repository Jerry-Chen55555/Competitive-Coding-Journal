import java.util.*;
import java.io.*;

public class highcard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
        PrintWriter pw = new PrintWriter("highcard.out");

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> e = new ArrayList<>();

        for (int i = 1; i <= 2*n; i++) {
            b.add(i);
        }
        

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            e.add(a);
            b.remove(b.indexOf(a));
        }

        System.out.println(b);
        System.out.println(e);
        Collections.sort(e);

        int bIndex = 0;
        int eIndex = 0;
        
        while (eIndex < n && bIndex < n) {
            while (bIndex < n && b.get(bIndex) < e.get(eIndex)) {
                bIndex++;
            }
            if (bIndex == n) {
                break;
            }
            bIndex++;
            eIndex++;
        }

        pw.println(eIndex);

        pw.close();
        br.close();
    }
}
