package uke3;

import uke2.Tabell;

import java.util.Arrays;

public class KvikkSort {
    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h
            if (v < h) Tabell.bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }
    private static int sParter0(int []a, int v, int h, int indeks){
        Tabell.bytt(a,indeks,h);
        int pos=parter0(a,v,h-1,a[h]);
        Tabell.bytt(a,pos,h);
        return pos;
    }
    private static void kvikksortering0(int [] a, int v, int h){
        if (v>=h)return;
        int k=sParter0(a,v,h,(v+h)/2);
        kvikksortering0(a,v,k-1);
        kvikksortering0(a,k+1,h);

    }
    public static void kvikksortering(int []a, int fra, int til){
        Tabell.fratilKontroll(a.length,fra,til);
        kvikksortering0(a,fra,til-1);
    }
    public static void kvikksortering(int[]a){
        kvikksortering(a,0,a.length-1);
    }

    public static void main (String [] args){
        int[] a = Tabell.randPerm(20);
        System.out.println(Arrays.toString(a));
        kvikksortering(a);
        System.out.println(Arrays.toString(a));
    }
}
