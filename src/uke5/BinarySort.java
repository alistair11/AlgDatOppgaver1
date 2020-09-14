package uke5;

public class BinarySort {
    public static void main(String [] args){
        int [] values={1,2,4,8,17,19,22};
        for (int i=1; i<=25; i++) {
            System.out.println(i+" "+binarySearch(i, values, 0, values.length - 1));
        }
    }
    //search in the interval [left, right]
    public static int binarySearch(int search_value,int [] values, int left, int right){
        int middle=(left+right)/2;
        if (right-left==0){
            if (values[middle]<=search_value) {
                return middle;
            }
            else {
                return -middle;
            }
        }
        if (values[middle]<=search_value){
            if (values[middle]==search_value){
                return middle; ///returnerer indeksen der vi har funnet elementet
            }
            return binarySearch(search_value,values,middle+1,right);
        }
        else {
            return binarySearch(search_value, values, left,middle-1);
        }

    }
}
