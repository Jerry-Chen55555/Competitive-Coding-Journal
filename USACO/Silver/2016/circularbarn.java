import java.io.*;
import java.util.*;

public class circularbarn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(br.readLine());
        int c[] = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }

        

        br.close();
        pw.close();
    }
}
