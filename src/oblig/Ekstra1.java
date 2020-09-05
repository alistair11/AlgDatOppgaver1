package oblig;

import java.util.Arrays;

public class Ekstra1 {
    public static void delsortering(int[] a) {
        int antallOddetall = finnAntallOddetall(a);
        int v = 0;
        int h = a.length - 1;
        while(v < h){
            while (v < antallOddetall && h >= antallOddetall && a[v] % 2 != 0) v++;   // h er stoppverdi for v
            while (v < antallOddetall && h >= antallOddetall && a[h] % 2 == 0) h--;
            if((a[v] % 2) == 0 && (a[h] % 2) != 0){
                bytt(a,v++,h--);

            }
            else if((a[v] % 2) == 0 && (a[h] % 2) == 0){
                h--;

            }
            else if((a[v] % 2) != 0 && (a[h] % 2) != 0){
                v++;

            }
            else if((a[v] % 2) != 0 && (a[h] % 2) == 0){
                v++;
                h--;

            }
        }
        Arrays.sort(a, 0, antallOddetall);
        Arrays.sort(a, antallOddetall, a.length);

    }

    public static int finnAntallOddetall(int[] a){
        int antallOddetall = 0;
        for (int i = 0; i < a.length; i++){
            if((a[i] % 2) != 0){

                antallOddetall++;
            }
        }
        return antallOddetall;
    }

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    public static void main(String [] args){
        int [] a={6,10,9,4,1,3,8,5,2,7};
        delsortering(a);
        System.out.println(Arrays.toString(a));
    }


}
