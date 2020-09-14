package uke4;

public class GenericSorting {
    public static class Person implements Comparable<GenericsTest.Person>{
        String fornavn;
        String etternavn;

        Person(String fornavn, String etternavn){
            this.fornavn=fornavn;
            this.etternavn=etternavn;
        }

        public int compareTo(GenericsTest.Person other){
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
            int last_compare=this.etternavn.compareTo(other.etternavn);
            if (last_compare==0){
                return this.fornavn.compareTo(other.fornavn);
            }
            else {
                return last_compare;
            }

        }
    }
    static
    <T extends Comparable<? super T>>
    int maks_generic(T[] values){
        T current_max=values[0];
        int current_indeks=0;
        for(int i=1; i<values.length; ++i){
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

        GenericsTest.Person[] d = {new GenericsTest.Person("Petter", "Petterson"), new GenericsTest.Person("Kari", "Petterson"),
                new GenericsTest.Person("Nils", "Abrahamsen")};
    }
}
