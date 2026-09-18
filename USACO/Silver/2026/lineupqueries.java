import java.io.*;

public class lineupqueries {
    public static long query1(long c, long t) {
        // cow to position

        // time before c first moves is c * 2
        long currT = c * 2 - 1;
        // position when c first moves is c
        long currP = c;
        while (currT + currP + 1 <= t) {
            currT += currP + 1;
            currP = currT / 2;
        }

        if (currT < t) {
            currP -= (t - currT);
        }

        return currP;
    }

    public static long query2(long x, long t) {
        if (x > t / 2) {
            return x;
        }
        // position to cow

        // traveling backwards through time
        long currT = t;
        long currP = x;
        // travel back a until p + a = floor((t - a) / 2)

        while (!(currP > currT / 2)) {
            long a = (currT - 2*currP) / 3;
            currT -= a;
            currP += a;
            if (currP == currT /2) {
                currP = 0;
                currT -= 1;
            } else {
                currP += 1;
                currT -= 1;
            }
        }

        return currP;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] qxtString = br.readLine().split(" ");
            long[] qxt = {Long.parseLong(qxtString[0]), Long.parseLong(qxtString[1]), Long.parseLong(qxtString[2])};
            if (qxt[0] == 1) {
                pw.println(query1(qxt[1], qxt[2]));
            } else {
                pw.println(query2(qxt[1], qxt[2]));
            }
        }

        br.close();
        pw.close();
    }
}