package mosh;

public class MainLinked {
    public static <H> void main(String [] args){
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
        LinkedList<H> list=new LinkedList<H>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.removeLast();
        System.out.println(list.contains(10));
    }


}

