package oblig;

import java.util.Arrays;

public class Oppgave4 {
    public static void bytt(int[]a, int i, int j){
        int temp=a[i]; a[i]=a[j]; a[j]=temp;
    }
    public static void quickSort(int[] a, int v, int h){

        if (v >= h){

            return;
        }
        int pivot = (v+h)/2;
        int k = førPartisjonering(a, pivot, v, h);

        quickSort(a, v, k-1);

        quickSort(a, k+1, h);

    }
    public static int førPartisjonering(int[] a, int pivotIndex, int v, int h){
        bytt(a, pivotIndex, h);
        int pos = partisjonering(a, a[h], v, h-1);
        bytt(a, pos, h);
        return pos;

    }
    public static int partisjonering(int[] a, int pivot, int v, int h){
        while (true) {
            while (v <= h && a[v] < pivot) {
                v++;
            }
            while (h >= v && a[h] >= pivot) {
                h--;
            }
            if (v < h) {
                bytt(a, v, h);
                v++; h--;
            }else {
                return v;
            }
        }
    }
    public static void reverser(char[] c, int v, int h){
        char[] temp = c.clone();
        for (int i = v; i <= h; i++){
            c[i] = temp[h - i + v];
        }
    }
    public static void delsortering(int[] a){

        int antallOddetall = 0;

        for (int i = 0; i < a.length; i++) {

            if (Math.abs(a[i] % 2) == 1) { //Sjekker om tallet i tabellen er et oddetall

                bytt(a, i, antallOddetall); //Flytter oddetallet til venstre i tabellen

                ++antallOddetall; //Telelr antall oddetall
            }
        }
        quickSort(a, 0, antallOddetall-1); //Sorterer alle oddetallene i stigende rekkefølge
        quickSort(a, antallOddetall, a.length-1);

    }
    public static void main(String [] args){
        int [] a={6,10,9,4,1,3,8,5,2,7};
        delsortering(a);
        System.out.println(Arrays.toString(a));

    }
}
