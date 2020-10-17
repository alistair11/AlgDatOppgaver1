package mosh;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args){
        /*
        Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);

        //numbers.removeAt(-1);

        System.out.println(numbers.indexOf(10));

        numbers.print();

         */
///Dynamic Arrays
        ArrayList<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.remove(0);

        System.out.println(list);

    }
}
