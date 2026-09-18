public class test {
    public static void main(String[] args) {
        long a = 1000000000000000L;
        System.out.println(((a)/14)*2);
        a -= (a/14 * 14);
        System.out.println(a);
    }
}
