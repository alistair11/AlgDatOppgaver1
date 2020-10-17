package uke4.eksempelklasser;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Person implements Comparable<Person>
{
    private final String fornavn;         // personens fornavn
    private final String etternavn;       // personens etternavn

    public Person(String fornavn, String etternavn)   // konstruktør
    {
        if (etternavn.equals(0)){
            throw new NullPointerException(etternavn+" etternavn er null");
        }
        if (fornavn.equals(0)){
            throw new NullPointerException(fornavn+" fornavnnavn er null");
        }
        //Objects.requireNonNull(fornavn, "fornavn er null");
        //Objects.requireNonNull(etternavn, "etternavn er null");
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String fornavn() { return fornavn; }       // aksessor
    public String etternavn() { return etternavn; }   // aksessor

    public int compareTo(Person p)    // pga. Comparable<Person>
    {
        int cmp = etternavn.compareTo(p.etternavn);     // etternavn
        if (cmp != 0) return cmp;             // er etternavnene ulike?
        return fornavn.compareTo(p.fornavn);  // sammenligner fornavn
    }
/*
    public boolean equals(Object o)      // vår versjon av equals
    {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        return compareTo((Person)o) == 0;
    }
 */
    public boolean equals(Person p){   // Person som parametertype
        if (p==this) return true;        // er det samme objekt?
        if (p==null) return false;       // null-argument
        return etternavn.equals(p.fornavn) && fornavn.equals(p.fornavn);
    }
    //oppgave 2e
    public boolean equals(Object o){       // ny versjon av equals
        if (o==this)return true;           // er det samme objekt?
        if (o==null)return false;             //null-argument
        if (getClass()!=getClass()) return false;     // er det rett klasse?
        final Person p=(Person)o;   //typekonvertering
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);
    }
    public int hashCode() { return Objects.hash(etternavn, fornavn); }

    //public String toString() { return fornavn + " " + etternavn; }

    //oppgave 2h
    public String toString(){
        return String.join(" ",fornavn,etternavn);
    }


    public static void main(String [] args){
        Person[] p = new Person[5];                   // en persontabell

        p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali","Kahn");              // Ali Kahn
        p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari","Pettersen");        // Kari Pettersen

        int m=maks(p);
        System.out.println(p[m] + " er størst");      // skriver ut den største

        innsettingssortering(p);                        // generisk sortering
        System.out.println(Arrays.toString(p));       // skriver ut sortert


        Stream s = Arrays.stream(p);
        Optional<Person> resultat = s.max(Comparator.naturalOrder());
        resultat.ifPresent(System.out::println);
    }

// Programkode 1.4.1 a)
    public static int maks(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    // Programkode 1.4.1 b)
    public static int maks(String[] a)    // legges i class Tabell
    {
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }
    //   Programkode 1.4.2 b)
    public static <T extends Comparable<? super T>> int maks(T[] a)
    {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    } // maks

//Programkode 1.4.2 e)
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
} // class Person