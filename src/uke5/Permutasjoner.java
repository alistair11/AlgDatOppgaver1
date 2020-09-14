package uke5;

import java.util.Arrays;

public class Permutasjoner {
    public static void main(String [] args){
        System.out.println("Resursive permutations");

        int values[]={1,2,3};
        //1,2,3
        //1,3,2
        //2,1,2
        //2,3,1
        //3,1,2
        //3,2,1
        recursivePermutation(values,0);
    }
    static void recursivePermutation(int[]values, int k){
        if (k==values.length-1){
            System.out.println(Arrays.toString(values));
        }
     //[1],2,3 -> 1,3,2
     //2,[1],3 -> 2,3,1
     //3,2,[1] -> 3,1,2
        for (int i=k; i<values.length; i++){
            bytt(values,i,k);
            recursivePermutation(values, k+1);
            bytt(values,i,k);

        }
    }

    public static void bytt(int[] value, int m, int n){
        // eksempel: m=2, n=3
        //temp=value[2]
        int temp=value[m];

        //value[2]=value[3]
        value[m]=value[n];

        // value[3]=temp=value[2]
        value[n]=temp;
    }
}
