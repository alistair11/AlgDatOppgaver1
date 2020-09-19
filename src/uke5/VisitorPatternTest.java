package uke5;

import uke4.GenericSorting;

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

    public class AscendingPersonComparator
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

    public static void main(String [] args){
        Person[] persons = {new Person("Petter", "Petterson"),
                new Person("Kari", "Petterson"),
                new Person("Nils", "Abrahamsen"),
                new Person("Tor","Toresen")};

        // 1 lage sortfunksjon som tar inn både person-arrayet og en sammenlikningsfunksjon
        sort(persons, comparator);

        System.out.println(Arrays.toString(persons));
    }
}
