package mosh;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value=value;
        }
    }
    private Node first;
    private Node last;

    //addFirst
    public void addFirst(int item){
        var node =new Node(item);

        if (isEmpty()){
            first=last=node;
        }
        else {
            node.next=first;
            first=node;
        }
    }
    private boolean isEmpty(){
        return first==null;
    }

    //addLast
    public void addLast(int item){
        Node node=new Node(item);
        //var node = new Node();
        if (first==null){
            first=node;
            last=node;
        }
        else {
            last.next=node;
            last=node;
        }
    }
    //deleteFirst
    public void removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        // [10-> 20 -> 30]
        // first -> 10 : we want first -> 20
        if (first==last){
            first=last=null;
            return;
        }
        var second =first.next;
        first.next=null;
        first=second;
    }
    //deleteLast
    public void removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (first==last){
            first=last=null;
            return;
        }
        //previous -> 20
        var previous=getPrevious(last);
        last=previous;
        last.next=null;

    }
    private Node getPrevious(Node node){
        // [10-> 20 -> 30]
        // last -> 30
        var current =first;
        while (current !=null){
            if (current.next==node) return current;
            current=current.next;
        }
        return null;
    }
    //contains
    public boolean contains(int item){
        return indexOf(item) != -1;
    }
    //indexOf
    public int indexOf(int item){
        int index=0;
        var current=first;
        while(current !=null){
            if (current.value==item){
                return index;
            }
            current=current.next;
            index++;
        }
        return -1;
    }

}
