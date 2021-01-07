package codingProblems;
/*
ckeck if a number is Armstrong

153: 1*1*1 + 5*5*5 + 3*3*3
 */
public class ArmstrongNumber {
    public static boolean checkArmstrong(int value){
        int temp=value;
        int order=0;
        while (temp > 0){
            temp=temp/10;
            order++;
        }
        temp= value;
        int sum=0;
        for (int i=0; i< order; i++){
            sum +=Math.pow(temp % 10, order);
            temp=temp/10;
        }
        return sum ==value;
    }

    public static void main(String [] args){

    }
}
