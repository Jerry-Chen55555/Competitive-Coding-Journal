import java.util.*;
import java.io.*;

public class WordProcessor {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("word.in"));
        PrintWriter pw = new PrintWriter("word.out");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        String[] words = new String[st.countTokens()];
        for (int i = 0; i < n; i++) {
            words[i] = st.nextToken();
        }

        String res = words[0];
        
        int currNumCharacters = words[0].length();

        for (int i = 1; i < n; i++) {
            if (currNumCharacters + words[i].length() > k) {
                currNumCharacters = words[i].length();
                res += "\n" + words[i];
            } else {
                currNumCharacters += words[i].length();
                res += " " + words[i];
            }
        }
        pw.println(res);
        
        pw.close();
        br.close();
    }
}