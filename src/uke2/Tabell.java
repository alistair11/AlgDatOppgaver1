package uke2;

import java.util.Arrays;
import java.util.Random;

public class Tabell {

    //1.1.8 d
    public static void bytt(int[]a, int i, int j){
        int temp=a[i]; a[i]=a[j]; a[j]=temp;
    }

    //1.1.8 e
    public static int[] randPerm(int n){
        Random r=new Random();     // en randomgenerator
        int [] a=new int[n]; // en tabell med plass til n tall
       return a;
    }
    /// 1.3.3 f
    public static void boblesortering(int [] a){
        for (int n=a.length; n>1;){
            int byttindeks=0;
            for (int i=1; i<n; i++){
                if (a[i-1]>a[i]){
                    bytt(a, i-1,i);
                }
            }
            n=byttindeks;
        }
    }

}
