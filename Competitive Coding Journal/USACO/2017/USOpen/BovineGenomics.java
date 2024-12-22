import java.util.*;
import java.io.*;

public class BovineGenomics {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter("cownomics.out");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long res = 0;

        String[] genomes = new String[2*n];

        for (int i = 0; i < genomes.length; i++) {
            genomes[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            boolean otherDoesntHave = true;

            for (int j = 0; j < n; j++) {
                for (int j2 = n; j2 < 2*n; j2++) {
                    if (genomes[j].charAt(i) == genomes[j2].charAt(i)) {
                        otherDoesntHave = false;
                        break;
                    }
                }
            }
            if (otherDoesntHave) {res++;}
        }
    
        pw.println(res);

        pw.close();
        br.close();
    }
}