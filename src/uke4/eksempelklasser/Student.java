package uke4.eksempelklasser;

public class Student extends Person   // Student blir subklasse til Person
{
    private final Studium studium;      // studentens studium

    public Student(String fornavn, String etternavn, Studium studium)
    {
        super(fornavn, etternavn);
        this.studium = studium;
    }

    public String toString() { return super.toString() + " " + studium.name();}

    public Studium studium() { return studium; }

    public static void main(String [] args){
        Student [] s=new Student[9]; //En studenttabell
        s[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
        s[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
        s[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
        s[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
        s[4] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen
        s[5]=new Student("Petter","Petterson",Studium.Elektro);
        s[6]=new Student("Mats","Hansen",Studium.Elektro);
        s[7]=new Student("Agi","Selliah",Studium.Enkeltemne);
        s[8]=new Student("Daisy","Edgar-Jones",Studium.Enkeltemne);

        innsettingssortering(s);
        for (Student t :s){
            System.out.println(t);
        }
    }


    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }
}  // class Student
