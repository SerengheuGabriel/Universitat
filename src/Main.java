public class Main {
    public static void main(String[] args){
        //int[] Noten = {48, 21, 60, 72, 84, 95, 1, -1}; varianta care crapa la throw 
        int[] Noten = {48, 21, 60, 72, 84, 95, 1}; //varianta care merge
        for (int i=0; i<Noten.length; i++){
            if (Noten[i] <= 0) throw new IllegalArgumentException("Keine negative oder 0 Noten");
        }
        //testing aufgabe 1
        System.out.println("testing aufgabe 1");
        int[] noten_failed = aufgabe1(Noten);
        for (int i=0; i<noten_failed.length; i++){
            System.out.println(noten_failed[i]);
        }
        //testing aufgabe 2
        System.out.println("testing aufgabe 2");
        System.out.println(average(Noten));
        //testing aufgabe 3
        System.out.println("testing aufgabe 3");
        int[] noten_aufgerundet = aufgerundet(Noten);
        for (int i=0; i<noten_aufgerundet.length; i++){
            System.out.println(noten_aufgerundet[i]);
        }
        //testing aufgabe 4
        System.out.println("testing aufgabe 4");
        int note_aufgerundet_max = max_aufgerundet(Noten);
        System.out.println(note_aufgerundet_max);
    }

    /**
     * Functie care primeste un array de variabile de tip int si returneaza un alt
     * array cu toate elementele care sunt mai mici decat 40
     * @param noten array de int-uri care reprezinta notele
     * @return array cu notele care nu au trecut
     */
    public static int[] aufgabe1(int[] noten) {
        int[] noten1 = new int[noten.length];
        int j=0;
        for (int i=0; i<noten.length; i++){
            if (noten[i] < 40) {
                noten1[j]=noten[i];
                j++;
            }
        }
        int[] noten2 = new int[j];
        for (int i=0; i<j; i++) {
            noten2[i] = noten1[i];
        }
        return noten2;
    }

    /**
     * functia primeste un array de int-uri, face suma tuturor numerelor si imparte suma la lungime
     * @param noten array cu noten
     * @return media aritmetica a tuturor notelor
     */
    public static int average(int[] noten){
        int s=0;
        for (int i=0; i<noten.length; i++){
            s += noten[i];
        }
        return (s / noten.length);
    }

    /**
     * functia trece prin array si face calculeaza distanta catre cel mai apropriat
     * multiplu de al lui 5, dupa care sa ia daca sa rotunjeasca in sus sau nu
     *  @param noten
     * @return array cu note rotunjite
     */
    public static int[] aufgerundet(int[] noten){
        int[] noten1 = new int[noten.length];
        for (int i=0; i<noten.length; i++){
            if (noten[i] < 38) {
                noten1[i] = noten[i];
                continue;
            }
            int dif = 5 - noten[i] % 5;
            if (dif < 3) {
                noten1[i]=noten[i] + dif;
            } else {
                noten1[i]=noten[i];
            }
        }
        return noten1;
    }

    /**
     * functia trece prin array si calculeaza distanta catre cel mai apropriat
     * multiplu de al lui 5, dupa care sa ia daca sa rotunjeasca in sus sau nu
     * @param noten array cu noten
     * @return cel mai mare int din array-ul rotunjit
     */
    public static int max_aufgerundet(int[] noten){
        int[] noten1 = new int[noten.length];
        for (int i=0; i<noten.length; i++){
            if (noten[i] < 38) continue;
            int dif = 5 - noten[i] % 5;
            if (dif < 3) {
                noten1[i]=noten[i] + dif;
            } else {
                noten1[i]=noten[i];
            }
        }
        int max=0;
        for (int i=0; i<noten.length; i++){
            if (noten1[i]>max) max=noten1[i];
        }
        return max;
    }

}
