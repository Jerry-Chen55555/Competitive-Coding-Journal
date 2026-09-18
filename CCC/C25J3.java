import java.io.*;

public class C25J3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String result = "";
            String s = br.readLine();
            int finalNumber = 0;
            String currNumber = "";
            for (int j = 0; j < s.length(); j++) {
                char nextChar = s.charAt(j);
                if (!(nextChar >= '0' && nextChar <= '9') && currNumber.length() > 0) {
                    finalNumber += Integer.parseInt(currNumber);
                    currNumber = "";
                }
                if ((nextChar >= '0' && nextChar <= '9') || (nextChar == '-')) {
                    currNumber += nextChar;
                } else if (nextChar >= 'A' && nextChar <= 'Z') {
                    result += nextChar;
                }
            }
            if (currNumber.length() > 0) {
                finalNumber += Integer.parseInt(currNumber);
                currNumber = "";
            }
            pw.println(result + finalNumber);
        }

        pw.close();
    }
}
