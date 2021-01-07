package codingProblems;

public class Factorial {
    public static int factorial(int n){
        int nummer=1;
        for (int i=1; i<=n; i++){
            nummer=nummer*i;
        }
        return nummer;
    }
    public static int fact(int n){
        if (n==1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void main(String [] args){
        System.out.println(factorial(5));
        System.out.println(fact(5));

    }
}
