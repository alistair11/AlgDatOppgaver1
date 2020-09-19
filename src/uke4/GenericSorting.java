package uke4;

import java.util.Arrays;

public class GenericSorting {
    public static class Person implements Comparable<Person>{
        String fornavn;
        String etternavn;

        Person(String fornavn, String etternavn){
            this.fornavn=fornavn;
            this.etternavn=etternavn;
        }

        public int compareTo(Person other) {
            /*
            if (this.etternavn<other.etternavn){
                return -1;
            }
            else if(this.etternavn==other.etternavn){
                return 0;
            }
            else{
                return 1;
            }
             */
            int last_compare = this.etternavn.compareTo(other.etternavn);
            if (last_compare == 0) {
                return this.fornavn.compareTo(other.fornavn);
            } else {
                return last_compare;
            }
        }
        public String toString(){
            return fornavn+" "+etternavn;
        }
    }
    static
    <T extends Comparable<? super T>>
    void sort(T[] values){
        //looper over alle untatt siste element
        for (int i=0; i<values.length-1; i++){
            //finn største element i intervallet [i, a.lenght]
             int max_index=maks(values,i,values.length);
            //bytt største element til posisjon i
            T temp=values[i];
            values[i]=values[max_index];
            values[max_index]=temp;

            // fortsett

        }
    }

    static
    <T extends Comparable<? super T>>
    int maks(T[] values, int begin, int end){
        T current_max=values[begin];
        int current_indeks=begin;
        for(int i=begin+1; i<end; ++i){
            //if (values[i]>current_Maks){
            if (values[i].compareTo(current_max)>0)
                current_max=values[i];
            current_indeks=i;
        }
        return current_indeks;
    }

    public static void main(String [] args) {
        Integer[] a = {1, 2, 9, 18, 98, 5, 6, 9};
        Character[] b = {'A', 'C', 'K', 'L', 'Z', 'Y', 'M'};
        String [] c={"ASF","Kari", "poteter","lammelår","eple","Petter"};

        Person[] d = {new Person("Petter", "Petterson"),
                new Person("Kari", "Petterson"),
                new Person("Nils", "Abrahamsen"),
                new Person("Tor","Toresen")};
        int person_max_index=maks(d,0,d.length);
        System.out.println("Siste person, leksikografisk, er "+d[person_max_index]);

        System.out.println("Sorterer personer");
        System.out.println("Før: "+Arrays.toString(d));
        sort(d);
        System.out.println("Etter: "+Arrays.toString(d));
    }
}
