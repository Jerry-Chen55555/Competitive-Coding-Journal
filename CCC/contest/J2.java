import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s[] = new long[5];
        for (int i = 0; i < 5; i++) {
            s[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(s);

        long d = Long.parseLong(br.readLine());
        System.out.println((s[1] + s[2] + s[3]) * d);
    }
}
