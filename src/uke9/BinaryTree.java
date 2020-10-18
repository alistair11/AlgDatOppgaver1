package uke9;

import java.util.ArrayDeque;

public class BinaryTree {
    static class BinaryTreeNode{
        char value;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;

        BinaryTreeNode(char value){
            this.value=value;
            this.leftChild=null;
            this.rightChild=null;
        }
        BinaryTreeNode addLeftChild(char value){
            this.leftChild=new BinaryTreeNode(value);
            return this.leftChild;
        }
        BinaryTreeNode addRightChild(char value){
            this.rightChild=new BinaryTreeNode(value);
            return this.rightChild;
        }
    }
    static void printLevelOrder(BinaryTreeNode root){
        ArrayDeque<BinaryTreeNode> queue= new ArrayDeque<BinaryTreeNode>();
       // legger til rot
        queue.addLast(root);
        while (!queue.isEmpty()){
            // 1. tar ut første fra køen
            BinaryTreeNode current=queue.removeFirst();

            // 2. legger til current sine to barn til køen
            if (current.leftChild!=null){
                queue.addLast(current.leftChild);
            }
            if (current.rightChild !=null){
                queue.addLast(current.rightChild);
            }
            //skriv ut
            System.out.print(current.value+" ");
        }
    }
    public static void main(String []args){
        // Legger rot noden
        BinaryTreeNode root=new BinaryTreeNode('A');

        // legger inn resterende noder på nivå 1
        BinaryTreeNode b=root.addLeftChild('B');
        BinaryTreeNode c=root.addRightChild('C');

        //legger inn allw noder på nivå 2
        BinaryTreeNode d =b.addLeftChild('D');
        BinaryTreeNode e=b.addRightChild('E');

        BinaryTreeNode f=c.addLeftChild('F');
        BinaryTreeNode g=c.addRightChild('G');

        printLevelOrder(root);

    }
}
