package uke8;
public class CircularBuffer {
    char[] values;
    int back=0;
    int front =0;
    int size=0;

    public static void main(String []args){
        System.out.println("Hello world");

        CircularBuffer buffer=new CircularBuffer();
        char[] chars="ABCDEFGHIJKLMNOPQRSTUVW".toCharArray();
        for (int i=0; i<chars.length; i++){
            for (int j=0; j<5; j++) {
                buffer.pushBack(chars[i]);
            }
            for (int j=0; j<5; j++){
                System.out.print(buffer.popFront());
            }
            System.out.println();
        }

    }
    CircularBuffer(){
        size=14;
        values=new char[size];
    }

    void pushBack(char value){
        values[back]=value;
        back=(back+1)%size;
    }

    char popFront(){
        char retval=values[front];
        front=(front+1)%size;
        return retval;
    }
}
