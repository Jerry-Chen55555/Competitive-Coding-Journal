import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long b = Integer.parseInt(br.readLine());
        long t = Integer.parseInt(br.readLine());
        long p = Integer.parseInt(br.readLine());
        
        if (b <= t - p) {
            System.out.println("Y " + (t - p - b));
        } else {
            System.out.println("N");
        }
    }
}
