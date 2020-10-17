package uke4.oppgaver;

public class Testprogram {

    public static void f(A a) {
        System.out.println("A");
    }


    public static void f(B b) {
        System.out.println("B");
    }



   public static void f(C c) {
        System.out.println("C");
    }



    public static void main(String... args)
    {
        f(new C());
        f(1f,1);// Feilmelding: The method f(int,float) is ambiguous.
        f(1,1f);

    }

    public static void f(int a, float b){}   // parameterliste: int, float

    public static void f(float a, int b){}   // parameterliste: float, int



}
class A {}                          // A er en klasse
interface B {}                      // B et grensesnitt
class C extends A implements B {}   // C er subtype til både A og B

