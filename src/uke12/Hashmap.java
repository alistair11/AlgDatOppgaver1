package uke12;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hashmap {
    public static void main(String [] args){
        System.out.println("Hashmap test");

        int hashmap_size=7;
        ArrayList <LinkedList<String>> hash_map=new ArrayList<>(hashmap_size);

        for (int i=0; i<hashmap_size; i++){
            hash_map.add(i, new LinkedList<>());
        }
        // lager test-strenger
        String [] strings=new String[5];
        strings[0]="Hei";
        strings[1]="På deg din gamle sjokolade";
        strings[2]="Peder";
        strings[3]="test";
        strings[4]="Hallo";

        for (int i=0; i<strings.length; i++){
            int hash =hash(strings[i]);
            int hashmap_index=computeHashmapIndex(hash,hashmap_size);
            System.out.println("Legger inn "+strings[i]+" med hash "+hash+" på plass "+hashmap_index);
            hash_map.get(hashmap_index).addFirst(strings[i]);
        }

        int hash=hash("Test2");
        int hashMap_index=computeHashmapIndex(hash,hashmap_size);
        System.out.println(hash_map.get(hashMap_index).toString());
    }



    static int computeHashmapIndex(int hash, int hashmap_size){
        return hash %hashmap_size;
    }
    static int hash(String data){
        int hash=0;

        //Summ av alle boksatvene (ikke optimalt) fordi her kan vi ikke se forskjellen mellom Hei og "H", "e" "i"
       /* for (int i=0; i<data.length(); i++){
            hash=hash+(int) data.charAt(i);
        }

        */
        for (int i=data.length()-1; i>=0; i--){
            char c=data.charAt(i);
            hash=(hash+c)*31;
        }
        if (hash<0){
            hash=-hash;
        }
        return hash;
    }
}
