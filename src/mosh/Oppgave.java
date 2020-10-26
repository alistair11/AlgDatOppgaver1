package mosh;

import java.util.Arrays;

public class Oppgave {
    static void bytt(int []a,int i, int j){
        int tmp=a[i]; a[i]=a[j]; a[j]=tmp;

    }

    static void snu(int [] a){
        for (int v=0, h=a.length-1; v<h;) bytt(a,v++,h--);
    }

    public static void main(String []args){
        int[] a = {1,2,3,4,5,6}, b = {};
        snu(a); snu(b);
        System.out.println(Arrays.toString(a));
    }
}
