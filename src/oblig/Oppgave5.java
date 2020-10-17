package oblig;

import java.util.Arrays;

/*
Det kan være aktuelt å «rotere» elementene i en tabell.
En rotasjon på én enhet gjøres ved at det siste elementet
 blir det første og alle de andre forskyves én enhet mot høyre.

A	B	C	D	E	F	G	H	I	J
    Tabell 2 : Bokstavene fra A til I
J	A	B	C	D	E	F	G	H	I
    Tabell 3 : Elementene i Tabell 2 forskjøvet én enhet

På figuren over har elementene i den første tabellen blitt «rotert»
én enhet. Lag metoden public static void rotasjon(char[] a).
Den skal «rotere» innholdet i tabellen a én enhet.
En rotasjon i en tom tabell eller i en tabell med nøyaktig ett
element er ingen feilsituasjon. Men rotasjonen vil da ikke endre noe.
 */
public class Oppgave5 {
    public static void rotasjon(char[]a){
        if (a.length==0){
            return;
        }
        char last=a[a.length-1];
        for (int i=a.length-1; i>0; i--){
            a[i]=a[i-1];
        }
        a[0]=last;
    }
    public static void main(String [] args){
        char [] a={'A','B','C','D','E','F','G','H','I','J'};
        rotasjon(a);
        System.out.print(Arrays.toString(a));
    }
}
