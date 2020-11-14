package uke11;

import java.util.PriorityQueue;

public class HeapApp {
    public static void heapSort(int[] array){
        PriorityQueue<Integer> minHeap =new PriorityQueue<>();

        for(int i=0; i<array.length; i++){
            minHeap.add(array[i]);
        }
        for (int i=0; i<array.length; i++){
            array[i]=minHeap.poll();
        }
    }
    public static void main(String [] args){
        int [] array={10,7,11,30,8,38,2,45};

        heapSort(array);

        for (int i=0; i<array.length; i++){
            System.out.print(array[i] +" ");
        }
    }
}
