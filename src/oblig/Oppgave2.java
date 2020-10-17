package oblig;

import java.util.Arrays;

public class Oppgave2 {
    public static int antallUlikeSortert(int [] a){
        int teller=0;
        int verdi=0;

        if (a.length==0){
            return 0;
        }

        for (int i=0; i<a.length; i++){
            if (a[i]>=verdi){
                if (a[i] !=verdi){
                    teller++;
                }
                verdi=a[i];
            }
            else {
                throw new IllegalStateException("Arrayet er ikke sortert stigende");
            }
        }
        return teller;
    }
    public static void main(String [] args){
        int [] a={1,3,4,5,5,6,7,7,7,8};
        System.out.println(antallUlikeSortert(a));
    }
}
