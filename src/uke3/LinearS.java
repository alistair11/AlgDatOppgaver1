package uke3;

public class LinearS {
    //oppgave 1
    public static int søkUsortert(int[] a, int verdi)
    {
        int sist = a.length - 1;
        int tmp = a[sist];  // tar vare på den siste
        a[sist] = verdi;    // verdi blir vaktpost

        for (int i = 0; ; i++)  // i < a.length er tatt vekk
            if (verdi == a[i])    // dette blir sant før eller senere
            {
                a[sist] = tmp;  // legger den siste tilbake
                if (i == sist) return verdi == tmp ? sist : -1;
                else return i;
            }
    }
    public static void main(String [] args){
        int [] a={7,5,9,2,10,4,1,8,6,3};
        System.out.println(søkUsortert(a,3));
    }
}
