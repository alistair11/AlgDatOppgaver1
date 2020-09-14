package uke5;
// 5-> 5*4*3*2*1

public class Factorial {
    public static void main(String [] args){
        int facto=factorial(5);
        System.out.println("5!"+facto);
        System.out.println("8!"+factorial(8));
        System.out.println("52!"+factorial(52));

        int n=5;
        System.out.println(fakulitet(n));
    }
    /*
    denne metoden returnerer (n fakulitet). denne bruker
    resursive funksjon call
     */
    static int fakulitet(int n){
        int n_fakulitet = 1;
        for (int i = 2; i < n; i++) {
            n_fakulitet = n_fakulitet * n;
        }
        return n_fakulitet;
    }
    static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);


        }

    }
}
