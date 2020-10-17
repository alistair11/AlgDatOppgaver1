package uke5.oppgaver;

import uke2.Tabell;

public class Rekursjon1 {
    public static int a(int n){  // n må være et ikke-negativt tall
        if (n==0) return 1;      // a0 = 1
        else if(n==1) return 2;  // a1 = 2
        else return 2*a(n-1)+3*a(n-2);   // to rekursive kall
    }
    public static int a1(int n){
        if (n<0) throw new IllegalArgumentException("n er negativ!");

        int x=0, y=1, z=1;

        for (int i=0; i<n; i++){
            z=2*y+3*x;
            x=y;
            y=z;
        }
        return z;
    }
    public static int tverrsum(int n){     // n må være >= 0
        if (n<10) return n;       // kun ett siffer
        else return tverrsum(n/10)+(n%10);  //metoden kalles
    }
    public static int tverrsum1(int n){
        int sum=0;
      while (n>0){
          sum +=n%10;
          n/=10;
      }
      return sum;
    }
    public static int sifferrot(int n){
        while (n>=10) n=tverrsum(n);
        return n;
    }
    public static int sifferrot1(int n){
        n%=9;
        return n==0 ? 9:n;
    }

    public static int euklid(int a, int b){
        if (b==0) return a;
        int r=a%b;   //r er resten
        return euklid(b,r); // rekursivt kall
    }
    public static int euklid1(int a, int b)
    {
        while (b > 0)
        {
            int c = a % b; a = b; b = c;
        }
        return a;
    }

    public static int sum(int n)       // summen av tallene fra 1 til n
    {
        if (n == 1) return 1;            // summen av 1 er lik 1
        return sum(n - 1) + n;           // summen av de  n – 1 første + n
    }
    public static int kvadratsum(int n){
        if (n==1) return 1;
        else return kvadratsum(n-1)*n*n;
    } // Formel:  n*(n + 1)*(2*n + 1)/6

    public static int sum1(int[] a, int n)   // summen av de n første
    {
        if (n == 1) return a[0];       // summen er verdien selv
        return sum1(a,n-1) + a[n-1];    // summen av de n-1 første + a[n-1]
    }

/*
	Summen av heltallene fra 1 til n er et spesialtilfelle
	 av det å finne summen av heltallene fra k til n der k <= n.
	  Lag en metode public static int sum(int k, int n) som finner denne summen,
	  og gjør det ved å bruke «splitt og hersk».
 */
    public static int sum2(int n, int k){
        if (n==k) return n;
        int m=(n+k)/2;
        return sum2(n,m)+sum2(m+1,k);
    }
    /*
    	Lag en rekursiv metode som returnerer posisjonen
    	til den største blant de n første verdiene i en heltallstabell.
    	Kan du få det til ved en «splitt og hersk»-teknikk?
     */
    public static int maks(int[] a, int v, int h)
    {
        if (v == h) return v;
        int m = (v + h)/2;  // midten
        int mv = maks(a,v,m);
        int mh = maks(a,m+1,h);

        return a[mv] >= a[mh] ? mv : mh;
    }
    public static int maks(int[] a)
    {
        return maks(a,0,a.length-1);
    }

    public static int fakulitet(int n){
        return n<2 ? 1: fakulitet(n-1)*n;
    }
    public static long fibonacci(int n){
        long a=0, b=1, c=0;

        for (int i=0; i<n; i++){
            a=b; b=c; c=a+b;
        }
        return c;
    }

    public static void main(String [] args){
        System.out.println(a1(10));

        System.out.println(tverrsum(0));
        System.out.println(tverrsum(72416));
        System.out.println(tverrsum(2147483647));

        System.out.println(tverrsum1(0));
        System.out.println(tverrsum1(72416));
        System.out.println(tverrsum1(956847));

        System.out.println(sifferrot(956847));
        System.out.println(sifferrot1(956847));


        int a = 14036, b = 1529;
        System.out.println(euklid(a,b));

        int u=14036, v=1529;
        System.out.println(euklid1(u,v));

        System.out.println(kvadratsum(2));

        int[] w = Tabell.randPerm(100);       // en permutasjon av tallene fra 1 til 100
        System.out.println(sum1(w,w.length));

        System.out.println(sum2(5,10));

        int [] z={1,10,3,4,5,7,8,29};
        System.out.println(maks(z));

        System.out.println(fakulitet(5));


        System.out.println(fibonacci(20));
    }
}
