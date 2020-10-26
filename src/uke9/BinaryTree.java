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
    static void printPreOrder(BinaryTreeNode node){
        if (node==null){
            return;
        }
        System.out.print(node.value+" ");
        printPreOrder(node.leftChild);
        printPreOrder(node.rightChild);
    }
    static void printInOrder(BinaryTreeNode node){
        if (node==null){
            return;
        }
        printInOrder(node.leftChild);
        System.out.print(node.value+" ");
        printInOrder(node.rightChild);
    }
    static void printPostOrder(BinaryTreeNode node){
        if (node==null){
            return;
        }
        printPostOrder(node.leftChild);
        printPostOrder(node.rightChild);
        System.out.print(node.value + " ");


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
    static BinaryTreeNode printPost(BinaryTreeNode p){
        if (p==null){
            return null;
        }
        while (true){
            if (p.rightChild !=null) p= p.rightChild;
            else if (p.leftChild !=null) p=p.leftChild;
            else return p;
        }

    }
    static void printPreOrderNonRecursive(BinaryTreeNode root)  {
        ArrayDeque<BinaryTreeNode> stack=new ArrayDeque<BinaryTreeNode>();
        stack.addLast(root);

        while (!stack.isEmpty()){
            BinaryTreeNode current =stack.removeLast();
            if (current.rightChild!=null) {
                stack.addLast(current.rightChild);
            }
            if (current.leftChild !=null) {
                stack.addLast(current.leftChild);
            }
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

         //Kall på funksjonen
        //printLevelOrder(root);
        System.out.println("Pre-order: ");
        printPreOrder(root);
        System.out.println();
        
        System.out.println("In-order: ");
        printInOrder(root);
        System.out.println();
        System.out.println("Post order: ");
        printPostOrder(root);
        System.out.println();

        System.out.println("Pre-order non-recursive:");
        printPreOrderNonRecursive(root);

    }
}
