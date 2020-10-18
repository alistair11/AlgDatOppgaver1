package uke8;
public class CircularBuffer2 {
    char[] buffer;
    int size;
    int head; // perker til starten av køen
    int tail; // peker til slutten av køen
    int count;

    CircularBuffer2(int size){
        this.buffer=new char[size];
        this.size=size;
        this.head=0;
        this.tail=0;
        this.count=0;
    }

    void pushBack(char value){
        if (count+1>size){
            throw new IndexOutOfBoundsException();
        }
        buffer[tail]=value;
        tail=(tail+1) % size; // Antar først at arrayet har plass til 3 elementer. indeks(0,1,2), tail starter til å være null
                              // økes til 1 også 2. når det økes igjen til 3 modules size (som er 3), da ender vi opp igjen på 0 (0,1,2: 0,1,2: 0,1,2)
        count=count+1;


    }
    char popFront(){
        if (count<=0){
            throw new IndexOutOfBoundsException();
        }
        char retval=buffer[head];
        System.out.print(head);
        head=(head+1) % size;
        count=count-1;
        return retval;
    }
    int count(){
        return count;
    }

    public static void main(String [] args){
        CircularBuffer2 buffer=new CircularBuffer2(7);

        char[] values="ABCDEFGHIJKLMNOPQRST".toCharArray();

        for (int i=0; i<values.length;){
            // legger inn tre bokstaver i bufferet
            for (int j=0; j<6; j++){
                if (values.length > i+j){
                    buffer.pushBack(values[i+j]);
                }
            }
            // ta ut alt fra bufferet
            while (buffer.count()>0){
                System.out.print(buffer.popFront());
            }
            System.out.println();

            i=i+6;
        }
    }
}
