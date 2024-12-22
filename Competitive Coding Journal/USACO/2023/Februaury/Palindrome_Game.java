import java.io.*;

public class Palindrome_Game {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String num = br.readLine();
            if (num.charAt(num.length()-1) == '0') pw.println('E');
            else pw.println('B');
        }
        pw.close();
        br.close();
    }
}
