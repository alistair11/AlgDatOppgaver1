package oblig;

import uke2.Tabell;

import java.util.Arrays;

public class Oppgave10 {
    public static boolean inneholdt(String a, String b){
        if (a.length() > b.length()){
            return false;
        }
        char [] aChar = a.toCharArray();
        char [] bChar = b.toCharArray();
        Arrays.sort(aChar);
        boolean inneholder = true;
        int gammelTeller = 0;
        for (int i = 0; i < aChar.length; i++){
            char undersøkElement = aChar[i];
            int teller = 0;
            inneholder = false;
            if (i > 0) {
                if (undersøkElement == aChar[i - 1]) {
                    teller = gammelTeller + 1;
                    gammelTeller = teller;
                }
                else {
                    gammelTeller = 0;

                }
            }

            for (int j = 0; j < bChar.length; j++){

                if (teller > 0 && undersøkElement == bChar[j]){

                    j+=teller-1;

                    teller = 0;

                }else if (undersøkElement == bChar[j]){

                    inneholder = true;

                    break;

                }

            }

            if (!inneholder){

                break;

            }

        }

        return inneholder;

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

        Tabell.bytt(a, pivotIndex, h);

        int pos = partisjonering(a, a[h], v, h-1);

        Tabell.bytt(a, pos, h);

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

                Tabell.bytt(a, v, h);
                v++; h--;
            }
            else {
                return v;
            }

        }

    }

}


