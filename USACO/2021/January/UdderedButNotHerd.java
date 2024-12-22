import java.io.*;

public class UdderedButNotHerd {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String cowphabet = br.readLine();
        String heard = br.readLine();

        int res = 0;

        while (heard.length() != 0) {
            for (int i = 0; i < cowphabet.length(); i++) {
                if (cowphabet.charAt(i) == heard.charAt(0)) {
                    heard = heard.substring(1);
                    if (heard.length() == 0) {
                        break;
                    }
                }
            }
            res ++;
        }

        pw.println(res);

        pw.close();
        br.close();
    }
}