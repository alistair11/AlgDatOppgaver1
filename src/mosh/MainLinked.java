package mosh;

import java.util.Arrays;

public class MainLinked {
    public static void main(String [] args){
        /*
        LinkedList list=new LinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);

        System.out.println(list.contains(10));
        System.out.println(list);

        //convert to array
        var array=list.toArray();
        System.out.println(Arrays.toString(array));

         */

        LinkedList list=new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.removeLast();
        System.out.println(list.contains(10));
    }
}
