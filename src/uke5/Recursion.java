package uke5;
/*
er en funksjon som kalles seg selv flere ganger (uendeling mange ganger)
 */

public class Recursion {
    public static void main(String [] args){
        int value =15;
        int return_value=recursivFunction(value);
        System.out.println("Main "+return_value);
    }
    static int recursivFunction(int value) {
        System.out.println("Resursive function "+value);
        if (value <= 5) {
            return -9;
        } else {
            return recursivFunction(value-1); /// hvis vil (value+1) -> uendelig
        }
    }
}
