package codingProblems;
/*
check if a given number is palindrome
Number = 12321
S= s * 10 + number % 10
Number =number /10;
S         Number
0         12321
1         12321
12        123
123       12
1232       1
12321      0
 */
public class Palindrome {
    public static boolean palindrom(int value){
        int t=value;
        int s=0;

        while (t >0){
            s=s * 10 + t % 10;
            t=t/t;
        }
        return s ==value;
    }
    public static void main(String [] args){


    }
}
