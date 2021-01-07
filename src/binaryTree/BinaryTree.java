package binaryTree;
class Node{
    int data;
    Node left;
    Node right;
}
public class BinaryTree {
    public Node nyNode(int value){
        Node p=new Node();
        p.data=value;
        p.left=null;
        p.right=null;
        return p;
    }

}
class Main{
    public static void main(String [] args){
        BinaryTree p=new BinaryTree();
        Node rot=p.nyNode(2);
        rot.left=p.nyNode(7);
        rot.right=p.nyNode(5);
        rot.left.left=p.nyNode(2);
        rot.left.right=p.nyNode(6);
        rot.right.left=p.nyNode(5);
        rot.right.right=p.nyNode(11);
        rot.right.right=p.nyNode(9);
        rot.right.right.left=p.nyNode(4);


    }
}
