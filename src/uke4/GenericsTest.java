package uke4;

public class GenericsTest {
    public static void main(String [] args){
        Integer [] a={1,2,9,18,98,5,6,9};
        Character[] b={'A','C','K','L','Z','Y','M'};

        Person [] d={new Person("Petter", "Petterson"), new Person("Kari", "Petterson"),
        new Person("Nils", "Abrahamsen")};

        System.out.println("Maks av int-array");
        System.out.println(maks(a));

        System.out.println("Maks av char-array");
        System.out.println(maks(b));

        System.out.println(" Generic maks av int-array");
        System.out.println(maks_generic(a));

        System.out.println(" Generic maks av char-array");
        System.out.println(maks_generic(b));

        System.out.println(" Generic maks av Person-array");
        System.out.println(maks_generic(d));
    }
    public static class Person implements Comparable<Person>{
        String fornavn;
        String etternavn;

        Person(String fornavn, String etternavn){
            this.fornavn=fornavn;
            this.etternavn=etternavn;
        }

        public int compareTo(Person other){
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




   public static int maks(Integer[] values){
        int current_Maks=values[0];
        int current_indeks=0;
        for(int i=1; i<values.length; ++i){
            if (values[i]>current_Maks){
                current_Maks=values[i];
                current_indeks=i;
            }
        }
        return current_indeks;
    }

    public static int maks(Character[] values){
        char current_Maks=values[0];
        int current_indeks=0;
        for(int i=1; i<values.length; ++i){
            if (values[i]>current_Maks){
                current_Maks=values[i];
                current_indeks=i;
            }
        }
        return current_indeks;
    }
}
