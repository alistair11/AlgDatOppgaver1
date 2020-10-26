package mosh;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;
/*
public class BinTre<T> implements Iterable<T>  // et generisk binærtre
{
    private static final class Node<T>  // en indre nodeklasse
    {
        private T verdi;            // nodens verdi
        private Node<T> venstre;    // peker til venstre barn/subtre
        private Node<T> høyre;      // peker til høyre barn/subtre

        private Node(T verdi, Node<T> v, Node<T> h)    // konstruktør
        {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
        }

        private Node(T verdi)  // konstruktør
        {
            this.verdi = verdi;
        }

    } // class Node<T>

    private Node<T> rot;      // peker til rotnoden
    private int antall;       // antall noder i treet

    public BinTre()           // standardkonstruktør
    {
        rot = null;
        antall = 0;
    }

    public BinTre(int[] posisjon, T[] verdi)  // konstruktør
    {
        if (posisjon.length > verdi.length) throw new
                IllegalArgumentException("Verditabellen har for få elementer!");

        for (int i = 0; i < posisjon.length; i++)
        {
            leggInn(posisjon[i],verdi[i]);
        }
    }

    public BinTre(final BinTre<T> tre)  // kopieringskonstruktør
    {
        rot = kopi(tre.rot);  // kaller den rekursive kopieringsmetoden
        antall = tre.antall;
    }

    private static <T> Node<T> kopi(Node<T> p)
    {
        if (p == null) return null;    // ingenting å kopiere
        return new Node<>(p.verdi,kopi(p.venstre),kopi(p.høyre));
    }

    public final void leggInn(int k, T verdi)
    {
        if (k < 1) throw new
                IllegalArgumentException("Posisjon k(" + k + ") < 1!");

        Node<T> p = rot, q = null;               // hjelpepekere

        int n = Integer.highestOneBit(k >> 1);   // n = 100...00

        while (p != null && n > 0)
        {
            q = p;
            p = (n & k) == 0 ? p.venstre : p.høyre;
            n >>= 1;  // bitforskyver n
        }

        if (n > 0) throw new
                IllegalArgumentException("Posisjon k(" + k + ") mangler forelder!");
        else if (p != null) throw new
                IllegalArgumentException("Posisjon k(" + k + ") finnes fra før!");

        p = new Node<>(verdi);  // ny node

        if (q == null) rot = p;   // tomt tre - ny rot
        else if ((k & 1) == 0)    // sjekker siste siffer i k
            q.venstre = p;
        else
            q.høyre = p;

        antall++;  // en ny verdi i treet
    }

    public int antall()
    {
        return antall;   // returnerer antallet
    }

    public boolean tom()
    {
        return antall == 0;
    }

    private Node<T> finnNode(int k)    // henter noden i posisjon k
    {
        if (k < 1) return null;

        Node<T> p = rot;                         // hjelpepeker
        int n = Integer.highestOneBit(k >> 1);   // n = 100...00

        for (; p != null && n > 0; n >>= 1)
        {
            p = (k & n) == 0 ? p.venstre : p.høyre;
        }

        return p;   // p blir null hvis k ikke er i treet
    }

    public boolean finnes(int k)
    {
        return finnNode(k) != null;
    }

    public T hent(int k)
    {
        Node<T> p = finnNode(k);

        if (p == null) throw new
                IllegalArgumentException("Posisjon k(" + k + ") er ukjent!");

        return p.verdi;
    }

    public T oppdater(int k, T nyverdi)
    {
        Node<T> p = finnNode(k);

        if (p == null) throw new
                IllegalArgumentException("Posisjon k(" + k + ") er ukjent!");

        T gammelverdi = p.verdi;
        p.verdi = nyverdi;
        return gammelverdi;
    }

    private static <T> boolean inneholder(Node<T> p, T verdi)
    {
        if (p == null) return false;  // kan ikke ligge i et tomt tre
        return verdi.equals(p.verdi) || inneholder(p.venstre,verdi)
                || inneholder(p.høyre,verdi);
    }

    public boolean inneholder(T verdi)
    {
        return inneholder(rot,verdi); // kaller den private metoden
    }

    private static <T> int posisjon(Node<T> p, int k, T verdi)
    {
        if (p == null) return -1;                  // ligger ikke i et tomt tre
        if (verdi.equals(p.verdi)) return k;       // verdi ligger i p
        int i = posisjon(p.venstre,2*k,verdi);     // leter i venstre subtre
        if (i > 0) return i;                       // ligger i venstre subtre
        return posisjon(p.høyre,2*k+1,verdi);      // leter i høyre subtre
    }

    public int posisjon(T verdi)
    {
        return posisjon(rot,1,verdi);  // kaller den private metoden
    }

    public T fjern(int k)
    {
        if (k < 1) throw new
                IllegalArgumentException("Posisjon k(" + k + ") < 1!");

        Node<T> p = rot, q = null;               // hjelpepekere
        int n = Integer.highestOneBit(k >> 1);   // binært siffer

        while (p != null && n > 0)
        {
            q = p;
            p = (n & k) == 0 ? p.venstre : p.høyre;
            n >>= 1;
        }

        if (p == null) throw new
                IllegalArgumentException("Posisjon k(" + k + ") er utenfor treet!");

        if (p.venstre != null || p.høyre != null) throw new
                IllegalArgumentException("Posisjon k(" + k + ") er ingen bladnode!");

        if (p == rot) rot = null;
        else if (p == q.venstre) q.venstre = null;
        else q.høyre = null;

        antall--;  //
        return p.verdi;
    }

    public void nullstill()
    {
        if (!tom()) nullstill(rot);  // nullstiller
        rot = null; antall = 0;      // treet er nå tomt
    }

    private void nullstill(Node<T> p)
    {
        if (p.venstre != null)
        {
            nullstill(p.venstre);      // venstre subtre
            p.venstre = null;          // nuller peker
        }
        if (p.høyre != null)
        {
            nullstill(p.høyre);        // høyre subtre
            p.høyre = null;            // nuller peker
        }
        p.verdi = null;              // nuller verdien
    }


    //// nivåorden //////////////////////////////////

    public void nivåorden(Oppgave<? super T> oppgave)
    {
        if (rot == null) return;  // tomt tre
        Kø<Node<T>> kø = new TabellKø<>();   // Se Avsnitt 4.2.3
        kø.leggInn(rot);

        while (!kø.tom())
        {
            Node<T> p = kø.taUt();
            oppgave.utførOppgave(p.verdi);   // den generiske oppgaven

            if (p.venstre != null) kø.leggInn(p.venstre);
            if (p.høyre != null) kø.leggInn(p.høyre);
        }
    }

    public String toNivåString()
    {
        StringJoiner s = new StringJoiner(", ", "[", "]");
        if (!tom()) nivåorden(x -> s.add(x.toString()));
        return s.toString();
    }

    //// preorden /////////////////////////////////////

    public T førstPreorden()
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        return rot.verdi;  // roten kommer først i preorden
    }

    private static <T> void preorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        oppgave.utførOppgave(p.verdi);
        if (p.venstre != null) preorden(p.venstre,oppgave);
        if (p.høyre != null) preorden(p.høyre,oppgave);
    }

    public void preorden(Oppgave<? super T> oppgave)
    {
        if (rot != null) preorden(rot,oppgave);
    }

    public String toPreString()
    {
        StringJoiner s = new StringJoiner(", ", "[", "]");
        if (!tom()) preorden(x -> s.add(x.toString()));
        return s.toString();
    }

    public void preorden2(Oppgave<? super T> oppgave)   // iterativ versjon
    {
        if (tom()) return;

        Stakk<Node<T>> stakk = new TabellStakk<>();
        Node<T> p = rot;    // starter i roten

        while (true)
        {
            oppgave.utførOppgave(p.verdi);

            if (p.venstre != null)
            {
                if (p.høyre != null) stakk.leggInn(p.høyre);
                p = p.venstre;
            }
            else if (p.høyre != null)  // her er p.venstre lik null
            {
                p = p.høyre;
            }
            else if (!stakk.tom())     // her er p en bladnode
            {
                p = stakk.taUt();
            }
            else                       // p er en bladnode og stakken er tom
                break;                   // traverseringen er ferdig
        }
    }

    //// inorden /////////////////////////////////

    public T førstInorden()
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;
        while (p.venstre != null) p = p.venstre;

        return p.verdi;
    }

    private static <T> void inorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        if (p.venstre != null) inorden(p.venstre,oppgave);
        oppgave.utførOppgave(p.verdi);
        if (p.høyre != null) inorden(p.høyre,oppgave);
    }

    public void inorden(Oppgave <? super T> oppgave)
    {
        if (rot != null) inorden(rot,oppgave);
    }

    @Override
    public String toString()
    {
        StringJoiner s = new StringJoiner(", ", "[", "]");
        if (!tom()) inorden(x -> s.add(x.toString()));  // et lamda-uttrykk
        return s.toString();
    }

    public void inorden2(Oppgave<? super T> oppgave)  // iterativ versjon
    {
        if (tom()) return;            // tomt tre

        Stakk<Node<T>> stakk = new TabellStakk<>();
        Node<T> p = rot;   // starter i roten og går til venstre
        for ( ; p.venstre != null; p = p.venstre)
        {
            stakk.leggInn(p);
        }

        while (true)
        {
            oppgave.utførOppgave(p.verdi);      // oppgaven utføres

            if (p.høyre != null)          // til venstre i høyre subtre
            {
                for (p = p.høyre; p.venstre != null; p = p.venstre)
                {
                    stakk.leggInn(p);
                }
            }
            else if (!stakk.tom())
            {
                p = stakk.taUt();   // p.høyre == null, henter fra stakken
            }
            else break;          // stakken er tom - vi er ferdig

        } // while
    }

    //// postorden //////////////////////////////

    public T førstPostorden()
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;
        while (true)
        {
            if (p.venstre != null) p = p.venstre;
            else if (p.høyre != null) p = p.høyre;
            else return p.verdi;
        }
    }

    private static <T> void postorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        if (p.venstre != null) postorden(p.venstre,oppgave);
        if (p.høyre != null) postorden(p.høyre,oppgave);
        oppgave.utførOppgave(p.verdi);
    }

    public void postorden(Oppgave<? super T> oppgave)
    {
        if (rot != null) postorden(rot,oppgave);
    }

    public String toPostString()
    {
        // bruker den rekursive postorden-metoden
        StringJoiner s = new StringJoiner(", ", "[", "]");
        if (!tom()) postorden(x -> s.add(x.toString()));
        return s.toString();
    }

    public void postorden2(Oppgave<? super T> oppgave)  // iterativ versjon
    {
        if (tom()) return;
        Stakk<Node<T>> stakk = new TabellStakk<>();

        Node<T> p = rot;

        while (true)  // går til den første i postorden
        {
            if (p.venstre != null)
            {
                stakk.leggInn(p);
                p = p.venstre;
            }
            else if (p.høyre != null)
            {
                stakk.leggInn(p);
                p = p.høyre;
            }
            else break;
        }

        oppgave.utførOppgave(p.verdi);

        while (true)
        {
            if (stakk.tom()) return;

            Node<T> f = stakk.taUt();

            if (f.høyre == null || p == f.høyre)
            {
                p = f;
            }
            else
            {
                stakk.leggInn(f);

                p = f.høyre;

                while (true)  // går til den første i postorden i subtreet med p som rot
                {
                    if (p.venstre != null)
                    {
                        stakk.leggInn(p);
                        p = p.venstre;
                    }
                    else if (p.høyre != null)
                    {
                        stakk.leggInn(p);
                        p = p.høyre;
                    }
                    else
                        break;
                }
            }

            oppgave.utførOppgave(p.verdi);
        }
    }

    //// InordenIterator ///////////////////

    @Override
    public Iterator<T> iterator()
    {
        return new InordenIterator();
    }

    private class InordenIterator implements Iterator<T>
    {
        private final Stakk<Node<T>> stakk = new TabellStakk<>();
        private Node<T> p = rot;           // nodepeker

        private Node<T> først(Node<T> q)   // en hjelpemetode
        {
            while (q.venstre != null)        // starter i q
            {
                stakk.leggInn(q);              // legger q på stakken
                q = q.venstre;                 // går videre mot venstre
            }
            return q;                        // q er lengst ned til venstre
        }

        public InordenIterator()           // konstruktør
        {
            if (tom()) return;               // tomt tre
            p = først(rot);                  // bruker hjelpemetoden
        }

        @Override
        public T next()
        {
            if (!hasNext()) throw new NoSuchElementException("Ingen verdier!");

            T verdi = p.verdi;               // tar vare på verdien i noden p

            if (p.høyre != null) p = først(p.høyre);  // p har høyre subtre
            else if (!stakk.tom()) p = stakk.taUt();  // p har ikke høyre subtre
            else p = null;                            // p var den siste

            return verdi;                             // returnerer verdien
        }

        @Override
        public boolean hasNext()
        {
            return p != null;
        }
    }  // InordenIterator


    //// OmvendtInordenIterator /////////////////////

    public Iterator<T> omvendtiterator()
    {
        return new OmvendtInordenIterator();
    }

    private class OmvendtInordenIterator implements Iterator<T>
    {
        private final Stakk<Node<T>> stakk = new TabellStakk<>();
        private Node<T> p = rot;

        private Node<T> sist(Node<T> q)    // en hjelpemetode
        {
            while (q.høyre != null)          // starter i q
            {
                stakk.leggInn(q);                  // legger q på stakken
                q = q.høyre;                   // går videre mot høyre
            }
            return q;                        // q er lengst ned til høyre
        }

        public OmvendtInordenIterator()    // konstruktør
        {
            if (tom()) return;               // treet er tomt
            p = sist(rot);                   // bruker hjelpemetoden
        }

        @Override
        public T next()
        {
            if (!hasNext()) throw new NoSuchElementException("Ingen verdier!");

            T verdi = p.verdi;               // tar vare på verdien i noden p

            if (p.venstre != null) p = sist(p.venstre);  // p har venstre subtre
            else if (!stakk.tom()) p = stakk.taUt();     // p har ikke venstre subtre
            else p = null;                               // p var den siste

            return verdi;                    // returnerer verdien
        }

        @Override
        public boolean hasNext()
        {
            return p != null;
        }
    }  // OmvendtInordenIterator


    // PreordenIterator

    public Iterator<T> preiterator()
    {
        return new PreordenIterator();
    }

    private class PreordenIterator implements Iterator<T>
    {
        private final Stakk<Node<T>> stakk = new TabellStakk<>();
        private Node<T> p = rot;

        @Override
        public boolean hasNext()
        {
            return p != null;
        }

        @Override
        public T next()
        {
            if (!hasNext()) throw new NoSuchElementException("Ingen verdier!");

            T tempverdi = p.verdi;

            if (p.venstre != null)
            {
                if (p.høyre != null) stakk.leggInn(p.høyre);
                p = p.venstre;
            }
            else if (p.høyre != null) p = p.høyre;
            else if (!stakk.tom()) p = stakk.taUt();
            else p = null;  // p var den siste

            return tempverdi;
        }

    } // slutt på class PreordenIterator

    //// PostordenIterator ///////////////

    public Iterator<T> postiterator()
    {
        return new PostordenIterator();
    }

    private class PostordenIterator implements Iterator<T>
    {
        private final Stakk<Node<T>> stakk = new TabellStakk<>();
        private Node<T> p;

        private Node<T> postførst(Node<T> q)
        {
            // går til første i postorden relativt til q
            while (true)
            {
                if (q.venstre != null)
                {
                    stakk.leggInn(q);
                    q = q.venstre;
                }
                else if (q.høyre != null)
                {
                    stakk.leggInn(q);
                    q = q.høyre;
                }
                else
                    return q;
            }
        }
        private Node <T> postNest(Node <T> p){
            if (p==null) return null;
            while (true){
                if (p.høyre !=null) p=p.høyre;
                else if(p.venstre !=null) p=p.venstre;
                else return p;
            }
        }

        private PostordenIterator()  // konstruktør
        {
            if (tom()) return;  // ingenting å gjøre hvis treet er tomt
            p = postførst(rot);
        }

        @Override
        public boolean hasNext()
        {
            return p != null;
        }

        @Override
        public T next()
        {
            if (!hasNext()) throw new NoSuchElementException("Ingen verdier!");

            T tempverdi = p.verdi;

            if (stakk.tom()) p = null;
            else
            {
                Node<T> f = stakk.kikk();
                if (f.høyre == null || p == f.høyre) p = stakk.taUt();
                else p = postførst(f.høyre);
            }

            return tempverdi;
        }
    } // slutt på class PostordenIterator

//// NivåordenIterator ///////////////

    public Iterator<T> nivåiterator()
    {
        return new NivåordenIterator();
    }

    private class NivåordenIterator implements Iterator<T>
    {
        private Kø<Node<T>> kø = new TabellKø<>();
        private Node<T> p = null;

        // konstruktør
        private NivåordenIterator()
        {
            if (rot == null) return;
            p = rot;
        }

        @Override
        public boolean hasNext()
        {
            return p != null;
        }

        @Override
        public T next()
        {
            if (!hasNext()) throw new NoSuchElementException("Ingen verdier!");

            T temp = p.verdi;

            if (p.venstre != null) kø.leggInn(p.venstre);
            if (p.høyre != null) kø.leggInn(p.høyre);
            p = kø.tom() ? null : kø.taUt();

            return temp;
        }
    } // slutt på class NivåordenIterator

    private static int høyde(Node<?> p)       // ? betyr vilkårlig type
    {
        if (p == null) return -1;        // et tomt tre har høyde -1
        return 1 + Math.max(høyde(p.venstre), høyde(p.høyre));
    }

    public int høyde()
    {
        return høyde(rot);  // kaller den private metoden
    }

    private static boolean isomorf(Node<?> p, Node<?> q)
    {
        if (p == null && q == null) return true;     // to tomme trær
        if (p == null ^ q == null) return false;     // tomt og ikke tomt
        return isomorf(p.venstre,q.venstre) && isomorf(p.høyre,q.høyre);
    }

    public boolean isomorf(BinTre<?> tre)
    {
        if (this == tre) return true;             // ett og samme tre
        if (antall != tre.antall) return false;   // må ha samme antall
        return isomorf(rot,tre.rot);              // den private metoden
    }

    private static boolean equals(Node<?> p, Node<?> q)
    {
        if (p == null && q == null) return true;   // to tomme trær
        if (p == null ^ q == null) return false;   // tomt og ikke tomt
        return p.verdi.equals(q.verdi) &&
                equals(p.venstre, q.venstre) && equals(p.høyre, q.høyre);
    }

    @Override
    public boolean equals(Object objekt)
    {
        if (this == objekt) return true;                 // samme objekt
        if (!(objekt instanceof BinTre)) return false;   // feil type!

        @SuppressWarnings("unchecked")
        BinTre<T> tre = (BinTre<T>)objekt;        // gjør om til BinTre
        if (antall != tre.antall) return false;   // må ha samme antall

        return equals(rot,tre.rot);  // kaller den private equals-metoden
    }

} // class BinTre<T>


 */