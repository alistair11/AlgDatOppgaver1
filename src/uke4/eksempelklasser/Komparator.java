package uke4.eksempelklasser;

import uke2.Tabell;

import java.util.Arrays;

@FunctionalInterface                // legges i mappen eksempelklasser
public interface Komparator<T>      // et funksjonsgrensesnitt
{
    int compare(T x, T y);            // en abstrakt metode

    public static void main(String... args)
    {
        Person[] p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        class FornavnKomparator implements Komparator<Person>
        {
            public int compare(Person p1, Person p2)        // to personer
            {
                return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
            }
        }
/*
        Komparator<Person> c = new FornavnKomparator();   // en instans av klassen
        Tabell.innsettingssortering(p,c);               // se Programkode 1.4.6 b)

        System.out.println(Arrays.toString(p));           // Utskrift av tabellen p
        // [Ali Kahn, Azra Zukanovic, Boris Zukanovic, Kari Svendsen, Kari Pettersen]

 */

//Programkode 1.4.6 d) lamda-uttrykk
        Komparator<Person> c = (p1,p2) -> p1.fornavn().compareTo(p2.fornavn());
        Tabell.innsettingssortering(p, c);                // se Programkode 1.4.6 b)
        System.out.println(Arrays.toString(p));           // Utskrift av tabellen p
//  Programkode 1.4.6 f)
        Tabell.innsettingssortering(p, (p1,p2) -> p1.fornavn().compareTo(p2.fornavn()));
        System.out.println(Arrays.toString(p));


        Student[] s = new Student[9];                             // en studenttabell
        s[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
        s[1] = new Student("Boris","Zukanovic", Studium.IT);      // Boris Zukanovic
        s[2] = new Student("Ali","Kahn", Studium.Anvendt);        // Ali Kahn
        s[3] = new Student("Azra","Zukanovic", Studium.IT);       // Azra Zukanovic
        s[4] = new Student("Kari","Pettersen", Studium.Data);     // Kari Pettersen
        s[5] = new Student("Anders","Åsen",Studium.Elektro);     // Anders Åsen
        s[6] = new Student("Kari","Østsiden",Studium.Elektro);   // Kari Østsiden
        s[7] = new Student("Per","Jensen",Studium.Enkeltemne);   // Per Jensen
        s[8] = new Student("Kari","Lie",Studium.Enkeltemne);     // Kari Lie
/*
        Tabell.innsettingssortering(s, (s1,s2) -> s1.studium().compareTo(s2.studium()));
        System.out.println(Arrays.toString(s));
 */

        Tabell.innsettingssortering(s,
                (s1,s2)->
        {
          int k=s1.studium().compareTo(s2.studium());
            return k !=0? k: s1.compareTo(s2);
        }
        );
        for (Student t: s) System.out.println(t);
    }

}
