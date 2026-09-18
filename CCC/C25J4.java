import java.io.*;
import java.util.ArrayList;

public class C25J4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        @SuppressWarnings("unused")
        int[] f = new int[n];
        ArrayList<Integer> fConsec = new ArrayList<>();
        String currF = "N";
        int currRun = 0;

        for (int i = 0; i < n; i++) {
            String newF = br.readLine();
            if (!newF.equals(currF)) {
                fConsec.add(currRun);
                currF = newF;
            } else {
                currRun++;
            }
        }
        fConsec.add(currRun);

        

        
        pw.close();
    }
}
