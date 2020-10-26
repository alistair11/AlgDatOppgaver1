package uke3;

import java.util.Arrays;

public class Ombytting {
    public static int antallOmbyttinger(int [] a, int s){
        int antall=0, m=s-1;
        for (int i=0; i<m; i++){
            if (a[i]>m) antall++;

        }
        return antall;
    }
    public static void main(String [] args){
        int [] a={13,2,8,10,16,9,15,4,18,14,12,11,7,5,3,6,17,1,20,19};
        System.out.println(antallOmbyttinger(a,11));

        int m=0;
        for (int i=0; i<10; i++){
            m=i;
            
        }

    }
}
