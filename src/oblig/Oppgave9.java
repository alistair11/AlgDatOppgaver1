package oblig;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oppgave9 {
    public static int[] tredjeMin(int[] a) {
        //throw new UnsupportedOperationException();
        int n=a.length;
        if (n<3){
            throw new NoSuchElementException("Lengden på tabellen skal være større eller lik 3");
        }
        int m=Integer.MAX_VALUE;
        int nm=Integer.MAX_VALUE;
        int nnm=Integer.MAX_VALUE;
        for (int i=0; i<a.length; i++){
            if (a[i]<m){
                nnm=nm;
                nm=m;
                m=a[i];
            }
            else if(a[i]<nm){
                nnm=nm;
                nm=a[i];
            }
            else if(a[i] <nnm){
                nnm=a[i];
            }
        }
        return new int[] {m, nm, nnm};
    }
    public static void main(String[]args){
        int [] a={1,78,98,5,4,88};
        System.out.println(Arrays.toString(tredjeMin(a)));
    }

}
