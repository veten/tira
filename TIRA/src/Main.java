
/**
 * Main-luokka
 */
public class Main {

    /**
     * Esimerkkimatriisi
     */
    public static int[][] mat1 = new int[][]{
        {0, 1, 0, 5, 12, 6, 7, 23, 9, 3},
        {1, 0, 2, 8, 4, 6, 8, 2, 1, 3},
        {0, 2, 0, 3, 4, 2, 1, 5, 8, 10},
        {4, 3, 1, 2, 5, 5, 3, 2, 1, 5},
        {5, 5, 7, 6, 9, 2, 1, 2, 12, 4},
        {1, 1, 1, 1, 1, 1, 13, 3, 3, 3},
        {6, 7, 8, 8, 9, 3, 2, 5, 2, 1},
        {3, 4, 5, 2, 5, 3, 2, 5, 6, 4},
        {0, 9, 5, 3, 7, 3, 8, 2, 6, 8},
        {5, 4, 3, 6, 4, 7, 8, 43, 4, 2}
    };
    /**
     * Esimerkkimatriisi
     */
    public static int[][] mat4 = new int[][]{
        {2, 2, 2},
        {2, 2, 2},
        {2, 2, 2}
    };
    /**
     * Esimerkkimatriisi
     */
    public static int[][] mat2 = new int[][]{
        {3, 1, 6, 6, 3, 5, 7, 9, 4, 7},
        {9, 5, 5, 1, 6, 6, 8, 4, 23, 3},
        {0, 2, 0, 3, 4, 2, 1, 5, 8, 10},
        {4, 3, 1, 2, 5, 5, 3, 2, 1, 5},
        {5, 5, 7, 6, 9, 2, 1, 2, 12, 4},
        {1, 1, 1, 1, 1, 1, 13, 3, 3, 3},
        {6, 7, 8, 8, 9, 3, 2, 5, 2, 1},
        {3, 4, 5, 2, 5, 3, 2, 5, 6, 4},
        {4, 6, 2, 2, 4, 56, 9, 0, 5, 3},
        {9, 10, 12, 6, 5, 3, 5, 6, 3, 33}
    };
    /**
     * Esimerkkimatriisi
     */
    public static int[][] mat3 = new int[][]{
        {0, 1, 7, 0, 0},
        {1, 0, 0, 4, 2},
        {7, 0, 0, 1, 0},
        {0, 4, 1, 0, 1},
        {0, 2, 0, 1, 0}
    };

    /**
     * Main-metodi
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean totuus = true;
        MatriisiLaskin laskin = new MatriisiLaskin();
        int[][] tulosMatriisi = laskin.matriisiKertolasku(mat1, mat2);
        int[][] tulosMatriisi2 = laskin.matriisiKertolaskuRekursiivisestiNeliomatriiseille(mat1, mat2);
        int[][] tulosMatriisi3 = laskin.matriisiKertolaskuStrassenAlgoritmillaNeliomatriiseille(mat1, mat2);
        if (tulosMatriisi != null) {
            for (int i = 0; i < tulosMatriisi.length; i++) {
                for (int j = 0; j < tulosMatriisi[0].length; j++) {
                    if (tulosMatriisi[i][j] != tulosMatriisi2[i][j] || tulosMatriisi2[i][j] != tulosMatriisi3[i][j]) {
                        System.out.println("JOTAIN MENI PIELEEN..");
                        totuus = false;
                    }
                }
            }
        } else {
            System.out.println("Laskutoimitus ei ollut määritelty!");
        }
        System.out.println(totuus);

    }
}
