package uke12;

public class Hashmap {
    public static void main(String [] args){
        System.out.println("Hashmap test");
    }
    int hash(String data){
        int hash=0;

        //Summ av alle boksatvene (ikke optimalt) fordi her kan vi ikke se forskjellen mellom Hei og "H", "e" "i"
        for (int i=0; i<data.length(); i++){
            hash=hash+(int) data.charAt(i);
        }
    }
}
