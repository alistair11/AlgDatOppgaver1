package oblig;

import java.util.Arrays;

public class Oppgave6 {
    public static void revers(char[] a, int v, int h){

        char[] tmp = a.clone();

        for (int i = v; i <= h; i++){

            a[i] = tmp[h - i + v];

        }

    }

    public static void rotasjon(char[]a, int b){
        if (b>0 && a.length!=0){
            int n=a.length;
            int steg=b%n;
            revers(a,0,n-1);
            revers(a,0,steg-1);
            revers(a,steg,n-1);

        }
        else if (b<0 && a.length !=0){
            int n=a.length;
            int steg=Math.abs(b%n);
            revers(a,0,steg-1);
            revers(a,steg,n-1);
            revers(a,0,n-1);
        }
    }

    public static void main(String [] args){
        char [] a={'A','B','C','D','E','F','G','H','I','J'};
        System.out.println(Arrays.toString(a));

        rotasjon(a,3);
        System.out.println(Arrays.toString(a));

        rotasjon(a,-2);
        System.out.println(Arrays.toString(a));
    }
}
