package uke3;

import uke2.Tabell;

import java.util.Arrays;

public class Oppgave133 {
    //oppgave 3
    public static void boblesortering(int[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            int antall = 0;
            for (int j = a.length - 1; j >= i; j--)
            {
                if (a[j] < a[j-1])
                {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                    antall++;
                }
            }
            if (antall == 0)
                break;
        }
    }

    public static void main(String [] args){


  //1.3.4

//oppgave 3
        /*
        int [] a={7,5,9,2,10,4,1,8,6,3};

        Tabell.utvalgssortering(a);
        Tabell.snu(a);
        Tabell.skriv(a);

         */


//oppgave 4
        int[] b = Tabell.randPerm(100000);
        long tid = System.currentTimeMillis();
        Tabell.utvalgssortering(b);
        tid = System.currentTimeMillis() - tid;
        System.out.println(tid);

        //Programkode 1.3.5 c)
        int[] a = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};  // Figur 1.3.5 a)
        System.out.println(Tabell.lineærsøk(a,32));              // utskrift: 10
        System.out.println(Tabell.lineærsøk(a,31));              // utskrift: -11



    }
}
