package uke11;

import mosh.Array;

import java.util.Arrays;

public class HeapSort {
    public static void main(String [] args){
        int values[] ={-99,5,9,8,3,1};  // bruker ikke indeks 0

        heapsort(values);


    }
    static void heapsort(int [] values){
        System.out.println("Array før heapify: "+ Arrays.toString(values));
        heapify(values);
        System.out.println("Array etter heapify: "+ Arrays.toString(values));

        for (int i=1; i<values.length; i++){
            int first=1;
            int last=values.length-i;

            System.out.println("Bytter "+first+ " med "+last);

            int tmp=values[first];
            values[first]=values[last];
            values[last]=tmp;

            int current=first;
            int leftChild=current*2;
            int rightChild=current*2+1;
            while (true){
                // Venstre barn er minst av barna, og mindre enn parent
                if (leftChild < last
                        && values[leftChild] < values[rightChild]
                        && values[leftChild] < values[current]){
                    System.out.println("Bytter "+current+" med "+leftChild);
                    int tmp2=values[leftChild];
                    values[leftChild]=values[current];
                    values[current]=tmp2;
                    // flytter til venstre
                    current=leftChild;
                }
                //Høyre barn er minst av barna, og mindre enn parent
               else if (rightChild <last
                       &&values[rightChild] < values[rightChild]
                        && values[rightChild] <values[current]){
                   System.out.println("Bytter "+current+" med "+rightChild);
                    int tmp2=values[rightChild];
                    values[rightChild] =values[current];
                    values[current]=tmp2;
                    //flytter til høyre
                    current=rightChild;

                }
               // Vi har funnet riktig plass til elementet
               else {
                   break;
                }
               leftChild=current*2;
               rightChild=current*2+1;
            }
        }
        System.out.println("Array etter uttak "+ Arrays.toString(values));

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
