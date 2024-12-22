import java.io.*;

public class Herdle {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int green = 0;
        int yellow = 0;

        String answer = br.readLine() + br.readLine() + br.readLine();
        String guess = br.readLine() + br.readLine() + br.readLine();
        
        for (int i = 0; i < guess.length(); i++) {
            for (int j = 0; j < answer.length(); j++) {
                if (guess.charAt(i) == answer.charAt(j) && i == j) {
                    green++;
                    answer = answer.substring(0, i) + "ɍ" + answer.substring(i + 1);
                    guess = guess.substring(0, j) + "Ɏ" + guess.substring(j + 1);
                    break;
                }
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            for (int j = 0; j < answer.length(); j++) {
                if (guess.charAt(i) == answer.charAt(j)) {
                    yellow++;
                    answer = answer.substring(0, j) + "Ẍ" + answer.substring(j + 1);
                    break;
                }
            }
        }
        
        pw.println(green + "\n" + yellow);
        
        pw.close();
        br.close();
    }
}