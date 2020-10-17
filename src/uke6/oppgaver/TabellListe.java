package uke6.oppgaver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TabellListe<T> implements Liste<T>
{
    private T[] a;
    private int antall;

    @SuppressWarnings("unchecked")          // pga. konverteringen: Object[] -> T[]
    public TabellListe(int størrelse)       // konstruktør
    {
        a = (T[])new Object[størrelse];       // oppretter tabellen
        antall = 0;                           // foreløpig ingen verdier
    }

    public TabellListe()                    // standardkonstruktør
    {
        this(10);                             // startstørrelse på 10
    }

    public TabellListe(T[] a)               // en T-tabell som parameter
    {
        this.a = a.clone();                   // kloner parametertabellen
        antall = a.length;                    // alle i tabellen
    }
    @Override
    public boolean leggInn(T verdi)  // inn bakerst
    {
        Objects.requireNonNull(verdi, "null er ulovlig!");

        // En full tabell utvides med 50%
        if (antall == a.length)
        {
            a = Arrays.copyOf(a,(3*antall)/2 + 1);
        }

        a[antall++] = verdi;   // setter inn ny verdi

        return true;
    }
    @Override
    public void leggInn(int indeks, T verdi)
    {
        Objects.requireNonNull(verdi, "null er ulovlig!");

        indeksKontroll(indeks, true);  // true: indeks = antall er lovlig

        // En full tabell utvides med 50%
        if (antall == a.length) a = Arrays.copyOf(a,(3*antall)/2 + 1);

        // rydder plass til den nye verdien
        System.arraycopy(a, indeks, a, indeks + 1, antall - indeks);

        a[indeks] = verdi;     // setter inn ny verdi

        antall++;
    }
    @Override
    public int antall()
    {
        return antall;          // returnerer antallet
    }

    @Override
    public boolean tom()
    {
        return antall == 0;     // listen er tom hvis antall er 0
    }

    @Override
    public T hent(int indeks)
    {
        indeksKontroll(indeks, false);   // false: indeks = antall er ulovlig
        return a[indeks];                // returnerer er tabellelement
    }

    @Override
    public int indeksTil(T verdi)
    {
        for (int i = 0; i < antall; i++)
        {
            if (a[i].equals(verdi)) return i;   // funnet!
        }
        return -1;   // ikke funnet!
    }

    @Override
    public boolean inneholder(T verdi)
    {
        return indeksTil(verdi) != -1;
    }

    @Override
    public T oppdater(int indeks, T verdi)
    {
        Objects.requireNonNull(verdi, "null er ulovlig!");

        indeksKontroll(indeks, false);  // false: indeks = antall er ulovlig

        T gammelverdi = a[indeks];      // tar vare på den gamle verdien
        a[indeks] = verdi;              // oppdaterer
        return gammelverdi;             // returnerer den gamle verdien
    }
    @Override
    public T fjern(int indeks)
    {
        indeksKontroll(indeks, false);  // false: indeks = antall er ulovlig
        T verdi = a[indeks];

        antall--; // sletter ved å flytte verdier mot venstre
        System.arraycopy(a, indeks + 1, a, indeks, antall - indeks);
        a[antall] = null;   // tilrettelegger for "søppeltømming"

        return verdi;
    }

    @Override
    public boolean fjern(T verdi)
    {
        Objects.requireNonNull(verdi, "null er ulovlig!");

        for (int i = 0; i < antall; i++)
        {
            if (a[i].equals(verdi))
            {
                antall--;
                System.arraycopy(a, i + 1, a, i, antall - i);

                a[antall] = null;

                return true;
            }
        }
        return false;
    }

    @Override
    public void nullstill()
    {
        if (a.length > 10)
            a = (T[])new Object[10];
        else
            for (int i = 0; i < antall; i++)
            {
                a[i] = null;
            }

        antall = 0;
    }

    @Override
    public String toString()
    {
        if (antall == 0) return "[]";

        StringBuilder s = new StringBuilder();
        s.append('[').append(a[0]);

        for (int i = 1; i < antall; i++)
        {
            s.append(',').append(' ').append(a[i]);
        }
        s.append(']');

        return s.toString();
    }

    @Override
    public Iterator<T> iterator()
    {
        return new TabellListeIterator();
    }

    // Skal ligge som en indre klasse i class TabellListe
    private class TabellListeIterator implements Iterator<T>
    {
        private int denne = 0;             // instansvariabel
        private boolean removeOK = false;  // instansvariabel

        @Override
        public boolean hasNext()     // sjekker om det er flere igjen
        {
            return denne < antall;     // sjekker verdien til denne
        }

        @Override
        public T next()
        {
            if (!hasNext())
                throw new NoSuchElementException("Tomt eller ingen verdier igjen!");

            T denneVerdi = a[denne];   // henter aktuell verdi
            denne++;                   // flytter indeksen
            removeOK = true;           // nå kan remove() kalles

            return denneVerdi;         // returnerer verdien
        }

        @Override
        public void remove()
        {
            if (!removeOK) throw new IllegalStateException("Ulovlig tilstand!");

            removeOK = false;          // remove() kan ikke kalles på nytt

            // verdien i denne - 1 skal fjernes da den ble returnert i siste kall
            // på next(), verdiene fra og med denne flyttes derfor en mot venstre

            antall--;           // en verdi vil bli fjernet
            denne--;            // denne må flyttes til venstre

            System.arraycopy(a, denne + 1, a, denne, antall - denne);  // tetter igjen
            a[antall] = null;   // verdien som lå lengst til høyre nulles
        }
        @Override
        public void forEachRemaining(Consumer<? super T> action){
            while (denne<antall){
                action.accept(a[denne++]);
            }
        }

    } // TabellListeIterator
    @Override
    public boolean fjernHvis(Predicate<? super T> p){
        Objects.requireNonNull(p); // kaster unntak

        int nyttAntall=antall;

        for (int i=0,j=0; j<antall; j++){
            if (p.test(a[j])) nyttAntall--;  //a[j] skal fjernes
            else a[i++]=a[j];      //forskyver
        }
        for (int i=nyttAntall; i<antall; i++){
            a[i]=null; // tilrettelegger for "søppeltømming"
        }
        boolean fjernet=nyttAntall<antall;

        antall=nyttAntall;
        return fjernet;
    }
    @Override
    public void forEach(Consumer<? super T> action){
        for (int i=0; i<antall; i++){
            action.accept(a[i]);
        }
    }

    public static void main(String [] args){
        /*
        String[] s={"Sohil",null,"Per","Thanh","Ann","Kari","Jon",null};
        Liste<String> liste=new TabellListe<>(s);

        System.out.println(liste.hent(4));
        System.out.println(liste.indeksTil("Kar"));
        System.out.println(liste.inneholder("Kari"));

        String[] d = {"Sohil","Per","Thanh","Ann","Kari","Jon"};
        Liste<String> liste1 = new TabellListe<>(s);

        System.out.println(liste1);

         */
        String[] t = {"Jens","Per","Kari","Ole","Berit","Jens","Anne","Nils","Siv"};
        Liste<String> liste2 = new TabellListe<>();
        for (String navn: t) liste2.leggInn(0,navn); // legger inn først

        System.out.println("Vi henter "+liste2.hent(5)+".");
        System.out.println("Nils er på plass"+liste2.indeksTil("Nils")+"!");
        liste2.oppdater(2,"Anna"); //bytter ut Anne med Anna på plass 2
        System.out.println(liste2.fjern(0)+" er slettet");
        System.out.println("Listeinnhold: "+liste2);
        liste2.fjernHvis(x->x.equals("Jens")); //fjerner alle forekomster av Jens
        liste2.forEach(x->System.out.print(x+" "));
    }
}// TabellListe