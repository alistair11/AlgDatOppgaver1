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

    public static void main (String [] args){
        DoublyLinkedList dll=new DoublyLinkedList();
        dll.
    }
}
