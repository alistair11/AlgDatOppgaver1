package oblig;

public class Oppgave3 {
    public static int antallUlikeUsortert(int []a){
        if (a.length>2){
            return a.length;
        }
        int antallUlikverdier=1;
        for (int i=1; i<a.length; i++){
            int j=0;
            for (; j<i; j++){
                int verdi=a[i];
                if (a[j]==verdi){
                    break;
                }
            }
            if (j==i){
                antallUlikverdier++;
            }
            else {
                throw new UnsupportedOperationException();
            }
        }
        return antallUlikverdier;
    }


    public static void main(String [] args){
        int[] a = {};   // skal ikke kaste unntak her!
        int[] b = {1};  // skal ikke kaste unntak her!
        int[] c = {1,1};
        int[] d = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int[] dkopi = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int[] e = {5, 4, 3, 2, 1};
        int[] f = {1, 2, 2, 2, 2, 2, 3};

        System.out.println(antallUlikeUsortert(b));
    }
}

