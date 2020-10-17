package uke4.eksempelklasser;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class Heltall implements Comparable<Heltall>
{
    private final int verdi;    // et heltall som instansvariabel

    public Heltall(int verdi) { this.verdi = verdi; }   // konstruktør

    public int intVerdi() { return verdi; }             // aksessor

    public int compareTo(Heltall h)        // Heltall som parameter
    {
       // return verdi < h.verdi ? -1 : (verdi == h.verdi ? 0 : 1);
        if (verdi < h.verdi) return -1;
        else if (verdi ==h.verdi) return 0;
        else return verdi-h.verdi;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;   // sammenligner med seg selv
        if (!(o instanceof Heltall)) return false;  // feil datatype
        return verdi == ((Heltall)o).verdi;
    }



    public boolean equals(Heltall h) { return verdi == h.verdi; }

    public int hashCode() { return 31 + verdi; }

    public String toString() { return Integer.toString(verdi); }

// Programkode 1.4.2 e)
    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    public static void main(String [] args){
        int[] a = {5,2,7,3,9,1,8,10,4,6};          // en int-tabell
        Heltall[] h = new Heltall[a.length];       // en Heltall-tabell

        for (int i=0; i< h.length; i++) h[i]=new Heltall(a[i]);
        innsettingssortering(h); //generisk sortering
        System.out.println(Arrays.toString(h));

        //Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
       // System.out.println(x.compareTo(y) + "  " + x.equals(y));

        Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
        System.out.println(x.hashCode() + "  " + y.hashCode());

    }

} // class Heltall
