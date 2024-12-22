package Day7;
import java.io.*;

public class solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Day7/input.txt"));

        long res = 0;
        for (int i = 0; i < 850; i++) {
            String line = br.readLine();
            int j = 0;
            boolean found = false;
            for (j = 0; j < line.length(); j++) {
                if (line.charAt(j) == ':') {break;}
            }
            long n = Long.parseLong(line.substring(0, j));
            String[] numStrings = line.substring(j+2).split(" ");
            int[] nums = new int[numStrings.length];
            for (int k = 0; k < numStrings.length; k++) {nums[k] = Integer.parseInt(numStrings[k]);}
        
            for (int k = 0; k < Math.pow(3, nums.length-1); k++) {
                long code = nums[0];
                for (int l = 1; l < nums.length; l++) {
                    if (k % Math.pow(3, l) < Math.pow(3, l)/3) {
                        code += nums[l];
                    } else if (k % Math.pow(3, l) < 2*Math.pow(3, l)/3){
                        code *= nums[l];
                    } else {
                        code = Long.parseLong(code + "" + nums[l]);
                    }
                }
                if (code == n) {
                    found = true;
                    break;
                }
            }
            if (found) {res += n;}
        }

        System.out.println(res);
        br.close();
    }
}
