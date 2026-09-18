import java.io.*;

public class majorityopinion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter pw = new PrintWriter(System.out);

        // int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < args.length; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] hayFaves = new int[N];
            // int result = 0;
            String[] hayFavesStrings = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                hayFaves[j] = Integer.parseInt(hayFavesStrings[j]);
            }
            for (int j = 0; j < N - 1; j++) {
                
            }
        }
    }
}
