package uke11;

import java.util.Arrays;

public class HeapSort {
    public static void main(String [] args){
        int values[] ={-99,5,9,8,3,1};  // bruker ikke indeks 0


    }
    static void heapsort(int [] values){
        System.out.println("Array før heapify: "+ Arrays.toString(values));
        heapify(values);
        System.out.println("Array etter heapify: "+ Arrays.toString(values));

        for (int i=1; i<values.length; i++){
            int first=1;
            int last=values.length-i;
        }

    }
    static void heapify(int [] values){
        for (int i=1; i<values.length; i++){ // Gjør vi om til et minimumsheap, hopper over indeks 0
            int current=i;   // iden til indeks 0
            int parent =i/2;  // forelder noden

            while (parent >0 && values[parent] > values[current]){  // looper opp
                System.out.println("Bytter "+current+" med "+parent);
                // Bytter vi om
                int temp=values[parent];
                values[parent]=values[current];
                values[current]=temp;
                // Oppdaterer current
                current=parent;
                //Oppdaterer current
                parent=current/2;

            }
        }
    }
}
