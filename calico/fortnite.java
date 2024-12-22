import java.io.*;

class fortnite {
    static int gcd(int a, int b)
    {
        int i;
        if (a < b) {i = a;} else {i = b;}
 
        for (i = i; i > 1; i--) {
 
            if (a % i == 0 && b % i == 0)
                return i;
        }
        return 1;
    }
    public static void main(String[] args) throws IOException {
        int counter = 1;
        for (int i = 2; i < 20; i++) {
            for (int j = 1; j < i; j++) {
                if (j == 1 || j == i -1) {
                    System.out.print(i-j + ",");
                    counter ++;
                }
                else if (gcd(j, i-j) == 1) {
                    System.out.print(i-j + ",");
                    counter++;
                }
            }
        }
        System.out.println("counter: " + counter);
    }
}