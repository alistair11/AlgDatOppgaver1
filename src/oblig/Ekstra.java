package oblig;

import java.util.Arrays;

public class Ekstra {

    public static void delsortering(int[] input) {
        int verdi = 0;
        int partall = 0;
        while(verdi < input.length) {
            if(input[verdi]%2 == 0)
                partall++;
            else
                byttNed(input, verdi, partall);
            verdi++;
        }
    }
    public static void byttNed(int[] a, int v, int verdi) {
        for(int i=0; i<verdi; i++)
            bytt(a, v-i, v-i-1);
    }
    public static void bytt(int[]a, int i, int j){
        int temp=a[i]; a[i]=a[j]; a[j]=temp;
    }
    public static void main(String[] args) {
        int [] a={6,10,9,4,1,3,8,5,2,7};
        delsortering(a);
        System.out.println(Arrays.toString(a));
    }
}
