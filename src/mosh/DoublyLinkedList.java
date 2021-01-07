package mosh;

public class DoublyLinkedList {
    private listNode head;
    private listNode tail;
    private int length;
    private class listNode{
        private int data;
        private listNode next;
        private listNode previous;

        public listNode(int data){
            this.data=data;
        }
    }
    public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }
    public boolean isEmpty(){
        return length==0; // head==null
    }
    public int length(){
        return length;
    }

    public void displayforward(){
        if(head==null){
            return;
        }
        listNode temp=head;
        while (temp !=null){
            System.out.print(temp.data + " --> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void displayBackward(){
        if (tail==null){
            return;
        }
        listNode temp=tail;
        while (temp !=null){
            System.out.print(temp.data + " --> ");
            temp=temp.previous;
        }
        System.out.println("null");
    }

    // legger inn i starten
    public void insertFirst(int value){
        listNode nyNode=new listNode(value);
        if (isEmpty()){
            tail=nyNode;
        }else {
            head.previous=nyNode;
        }
        nyNode.next=head;
        head=nyNode;
        length++;
    }
    public void insertLast(int value){
        listNode nyNode=new listNode(value);

        if (isEmpty()){
            head=nyNode;
        }
        else {
            tail.next=nyNode;
            nyNode.previous=tail;
        }
        tail=nyNode;
        length++;
    }
    public static void main (String [] args){
        DoublyLinkedList dll=new DoublyLinkedList();

        dll.insertFirst(2);
        dll.insertFirst(10);
        dll.insertLast(3);
        dll.displayforward();
    }
}
