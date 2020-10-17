package uke5;

public class Hanoi {
    private int diskNum;
    private int[] pegs;
    private int steps;

    public Hanoi(int a){
        diskNum=a;
        pegs=new int[] {0,a,0,0};
        steps=0;
    }

    public int getDiskNum() {
        return diskNum;
    }

    public void move(int a, int b){
        pegs[a]--;
        pegs[b]++;
        System.out.println("from "+a+" to "+b);
        steps++;
    }

    public void solve(int num, int begin,int trans, int end){
        if (num==2){
            move(begin,trans);
            move(begin,end);
            move(trans,end);
        }
        else {
            solve(num-1,begin,end,trans);
            move(begin,end);
            solve(num-1, trans,begin,end);
        }
        if (pegs[1]==0 && pegs[2]==0 && pegs[3]==diskNum){
            System.out.println("Solved");
            System.out.println("Step"+steps);
            return;
        }
    }
    public static void main (String [] args){
        
    }
}
