import java.util.*;
import java.io.*;

class Light {
    int start;
    int end;
    int mid;

    public Light (int s, int e, int m) {
        start = s;
        end = e;
        mid = m;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String toString() {
        return "[" + start + " " + end + " " + mid + "]";
    }
}

public class S2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());

        ArrayList<Light> startingValues = new ArrayList<>();
        ArrayList<Light> endingValues = new ArrayList<>();
        

        for (int i = 0; i < l; i++) {
            String[] ps = br.readLine().split(" ");
            int pi = Integer.parseInt(ps[0]);
            int si = Integer.parseInt(ps[1]);
            
            Light newLight = new Light(Math.max(1, pi - si), Math.min(n, pi + si), pi);
            startingValues.add(newLight);
            endingValues.add(newLight);
        }
        
        ArrayList<Integer> sv = new ArrayList<>();
        ArrayList<Integer> ev = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            sv.add(startingValues.get(i).getStart());
            ev.add(endingValues.get(i).getEnd());
        }

        Collections.sort(startingValues, Comparator.comparing(Light::getStart));
        Collections.sort(endingValues, Comparator.comparing(Light::getEnd));
        
        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(br.readLine());

            int start = Collections.binarySearch(sv, query);
            int end = Collections.binarySearch(ev, query);

            if (start < 0) {
                start = -(start + 1);
            }
            if (end < 0) {
                end = -(end + 1);
            }
            start--;
            end++;

            if (start == -1) {
                pw.println("N 1");
                continue;
            }

            if (end >= l) {
                pw.println("N 2");
                continue;
            }

            if (startingValues.get(start).mid <= endingValues.get(end).mid) {
                pw.println("Y 3");
            } else {
                pw.println("N 4");
            }
        }

        pw.println(startingValues);
        pw.println(endingValues);

        pw.close();
    }
}
