package uke5.oppgaver;

public class Rekursjon2 {
    public static int tverrsum(int n)
    {
        System.out.println("tverrsum(" + n + ") starter!");
        int sum = (n < 10) ? n : tverrsum(n / 10) + (n % 10);
        System.out.println("tverrsum(" + n + ") er ferdig!");
        return sum;
    }

    public static int euklid(int a, int b)
    {
        System.out.println("euklid(" + a + "," + b + ") starter!");
        if (b == 0)
        {
            System.out.println("euklid(" + a + "," + b + ") er ferdig!");
            return a;
        }
        int r = a % b;            // r er resten
        int k = euklid(b,r);       // rekursivt kall
        System.out.println("euklid(" + a + "," + b + ") er ferdig!");
        return k;
    }

    public static void main(String... args) {
        System.out.println("main() starter!");
        int sum = tverrsum(7295);
        System.out.println("main() er ferdig!");

        System.out.println(euklid(98,78));
    }
}
