import java.util.*;
import java.io.*;

public class cowntact {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);


        // get input
        int N = Integer.parseInt(br.readLine());
        String inputString = br.readLine();
        // create and initialize oneGroups, which stores the lengths of clusters of 1's in the array
        ArrayList<Integer> oneGroups = new ArrayList<>();

        int currClusterLength = 0;
        for (int i = 0; i < inputString.length(); i++) {
            int currDigit = Integer.parseInt(inputString.charAt(i) + "");
            if (currDigit == 1) {
                currClusterLength++;
            } else {
                if (currClusterLength != 0) {
                    oneGroups.add(currClusterLength);
                    currClusterLength = 0;
                }
                
            }
        }

        oneGroups.add(currClusterLength);

        // find maximum number of nights so minimum number of cows
        int maxNights = 0;
        System.out.println(maxNights);
        System.out.println(N);
        // if (Collections.min(oneGroups) == oneGroups.get(0) || Collection)
        // int maxNights = (Collections.min(oneGroups) - 1) / 2;

        int initialInfected = 0;

        for (int a : oneGroups) {
            System.out.println(a);
            // initialInfected += a - maxNights * 2;
        }
        pw.println(initialInfected);
        


        br.close();
        pw.close();
    }
}
