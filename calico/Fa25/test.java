import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Character c = in.nextLine().charAt(0);

        System.out.println(c - 'a' + 1);
        in.close();
    }
}
