package uke10;

public class MyBinaryTree {
    static class Node{
        Node leftChild;
        Node rightChild;
        Node parent;
        char value;

        Node(char value, Node parent){
            this.value=value;
            this.parent=parent;
            this.leftChild=null;
            this.rightChild=null;
        }
        void insert(Node current, char value){
            // Rekursiv funksjon:
            // 1. kalle seg selv
            //2. forenkle argumentene
            // 3. ende i et basistilfelle
            if (value >= current.value){  // Hvis vi legger til en "verdi" som er større eller lik nåværende node
                                          // så går vi mot høyre i binærtreet
                if (current.rightChild==null){
                    current.rightChild=new Node(value,current);
                }
                else {
                    insert(current.rightChild, value);
                }
            }
            else {
                if (current.leftChild==null){
                    current.leftChild=new Node(value,current);
                }
                else {
                    insert(current.leftChild, value);
                }
            }
        }
        void printPreOrder(){
            // Skrive ut
            System.out.print(this.value+" ");
            // Rekursib gå til venstre
            if (this.leftChild !=null){
                this.leftChild.printPreOrder();
            }

            if (this.rightChild !=null){
                this.rightChild.printPreOrder();
            }
            // Rekursiv gå til høyre

        }
        private static Node nesteInorden(Node p)
        {
            if (p.rightChild != null)  // p har høyre barn
            {
                return forsteInorden(p.rightChild);
            }
            else  // må gå oppover i treet
            {
                while (p.parent != null && p.parent.rightChild == p)
                {
                    p = p.parent;
                }
                return p.parent;
            }
        }

        private static Node forsteInorden(Node p)
        {
            while (p.leftChild != null) p = p.leftChild;
            return p;
        }
    }
    public static void main(String [] args){
        Node root = new Node('M',null);
        root.insert(root,'D');
        root.insert(root,'P');
        root.insert(root,'C');
        root.insert(root,'E');
        root.insert(root,'N');
        root.insert(root,'Q');
        root.insert(root,'F');
        root.insert(root,'O');


        //root.printPreOrder();

       System.out.print(Node.forsteInorden(root));
       System.out.println();
       System.out.print(Node.nesteInorden(root));




    }
}
