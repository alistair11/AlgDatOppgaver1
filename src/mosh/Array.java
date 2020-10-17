package mosh;
public class Array {
    private int[] items;
    private int count;

    public Array(int lenght){
        items=new int[lenght];
    }

    public void insert(int item){
        // If the array is full, resize it
        if (items.length==count){
            // Create a new array (twice the size )
            int [] newItems=new int[count*2];

            //Copy all the existing items
            for (int i=0; i<count; i++){
                newItems[i]=items[i];
            }
            // Set "items" to this new array
            items=newItems;
        }
        // Add the new item at the end
        items[count]=item;
        count++;
    }
    public void removeAt(int index){
        // Validate the index
        if (index <0 || index>=count){
            throw new IllegalArgumentException();
        }
        //Shift the items to the left to fill the hole
        //[10,20,30,40]
        //index:1
        for (int i=index; i<count; i++){
            items[i]=items[i+1];
        }
        count--;
    }
    public int indexOf(int item){
        // If we find it, return index
        //Otherwise, return -1

        //the best case O(1)
        // the worst case O(n)
        for (int i=0; i<count; i++){
            if (items[i]==item){
                return i;
            }
        }
        return -1;
    }

    public void print(){
        for (int i=0; i<count; i++){
            System.out.println(items[i]);
        }
    }

}
