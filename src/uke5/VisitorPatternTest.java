package uke5;

import uke4.GenericSorting;

import java.nio.channels.AcceptPendingException;
import java.util.Arrays;

public class VisitorPatternTest {
    public static class Person {
        String fornavn;
        String etternavn;

        Person(String fornavn, String etternavn){
            this.fornavn=fornavn;
            this.etternavn=etternavn;
        }
        public String toString(){return fornavn+" "+etternavn;}

    }
    //Et interface - det lover at alle klasser som implementerer dette
    // har de foreskrevne funksjonene
    @FunctionalInterface
    public interface Komparator<T>{
        int compare(T a, T b);

    }

    public static class DesendingPersonComparator
            implements  Komparator<Person>{
       public int compare(Person a, Person b){
            int last_compare=a.etternavn.compareTo(b.etternavn);
            if (last_compare==0){
                return a.fornavn.compareTo(b.fornavn);
            }
            else {
                return last_compare;
            }
        }
    }

    public static class AscendingPersonComparator
            implements  Komparator<Person>{
        public int compare(Person a, Person b){
            int last_compare=b.etternavn.compareTo(a.etternavn);
            if (last_compare==0){
                return b.fornavn.compareTo(a.fornavn);
            }
            else {
                return last_compare;
            }
        }
    }

    public static class OddePartallKomparator
            implements Komparator<Integer>{
        public int compare(Integer a, Integer b) {
            //Først sammenlikne "etternavn" => partall eller oddetall
            //Begge er partall eller begge er oddetall
            if (a % 2 == b % 2 ) {
                return a.compareTo(b);
            }
            // a er oddetall, b er partall
            else if (a % 2 > b % 2) {
                return 1;
            }
            // b er oddetall, a er partall
            else if (b % 2 > a % 2) {
                return -1;
            }
            // Not a number, infinity, ect. Burde kaste exception
            return 0;
        }
    }


    /**
     * Denne funksjonen finner største verdi i values.
     * Bruker sammenlikningsfunksjonen i objektet comp for sammenlikning.

     */
    public static <T> int maks(T[] values, int begin, int end, Komparator<T> comp){
        T current_max=values[begin];
        int current_index=begin;

        for (int i=begin; i<end; ++i){
            //if (values[i] > current_max)
            if (comp.compare(values[i],current_max)>0){
                current_max=values[i];
                current_index=i;
            }
        }
        return current_index;
    }
    public static <T> void sort(T[] values, Komparator<T> comp){
        //looper over alle unntatt siste element.
        for (int i=0; i<values.length; ++i){
            //finn største element i intervallet [i,a.lenght]
            int max_index=maks(values,i, values.length, comp);

            //bytt største element til posisjon i
            T temp=values[i];
            values[i]=values[max_index];
            values[max_index]=temp;

        }

    }
    public static void main(String [] args){
        Person[] persons = {new Person("Petter", "Petterson"),
                new Person("Kari", "Petterson"),
                new Person("Nils", "Abrahamsen"),
                new Person("Tor","Toresen")};

        // 0 lag comarator-objektet
        // vi kan nå kjøre comp.compare(a,b)
        AscendingPersonComparator comp_asc=new AscendingPersonComparator();
        DesendingPersonComparator comp_des=new DesendingPersonComparator();

        // 1 lage sortfunksjon som tar inn både person-arrayet og en sammenlikningsfunksjon
        System.out.println("Før sortering: "+Arrays.toString(persons));
        System.out.println("Sorterer!");
        sort(persons,comp_asc);
        System.out.println("Etter sortering (Ascending): "+Arrays.toString(persons));
        sort(persons,comp_des);
        System.out.println("Etter sortering (Desending): "+Arrays.toString(persons));

        Integer integers[]={9,8,7,6,5,4,3,2,1,0};
        // Vil sortere sånn at vi får oddetall til venstre, og partall til høyre.
        // Partall og oddetall skal være inbyrdes sortert
        OddePartallKomparator odd_partall=new OddePartallKomparator();
        System.out.println("Før sortering: "+Arrays.toString(integers));
        sort(integers,odd_partall);
        System.out.println("Etter sortering: "+Arrays.toString(integers));

        //Hva skal noe være?
        // - partall og oddetall-sjekk
        // - skille mellom partall og oddetall
        //Tanke: Bruk "er det partall?" som "etternavn", og så størrelse på tallet som fornavn.
        // Noe må være en Komparator<T>
    }
}
