package uke3;

public class Sort {
    public static int inversjoner(int[]a){
        int antall=0;
        for (int i=0; i<a.length-1; i++){
            for(int j=i+1; j<a.length; i++){
                if (a[i]>a[j]){
                    antall++;
                }
            }
        }
        return antall;
    }
    public static void main(String [] args){
        int[] a={1,2,4,3,6,7,9,5,8,10};
        System.out.println(inversjoner(a));
    }
}
