import java.io.*;

public class RoundaboutRounding {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());
            long res = 0;
            for (int j = 0; j < (n + "").length(); j++) {
                long max = 5 * (long) Math.pow(10, j);
                long min = 0;
                for (int k = 0; k < j + 1; k++) {
                    min *= 10;
                    min += 4;
                }
                if (n >= max) {
                    res += max - min - 1;
                } else if (n > min) {
                    res += n - min;
                }
            }

            pw.println(res);
        }

        br.close();
        pw.close();
    }
}