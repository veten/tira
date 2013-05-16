
/**
 * Main-luokka
 */
public class Main {

    /**
     * Esimerkkimatriisi
     */
    public static int[][] mat1 = new int[][]{
        {0, 1, 0},
        {1, 0, 2},
        {0, 2, 0}
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
        {0, 1, 0, 0},
        {1, 0, 0, 0},
        {0, 0, 0, 2},
        {0, 0, 2, 0}
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
        MatriisiLaskin laskin = new MatriisiLaskin(mat4, mat1);
        int[][] tulosMatriisi = laskin.matriisiKertolasku();
        if (tulosMatriisi != null) {
            for (int i = 0; i < tulosMatriisi.length; i++) {
                for (int j = 0; j < tulosMatriisi[0].length; j++) {
                    System.out.print(tulosMatriisi[i][j] + " ");
                }
                System.out.println("");
            }
        } else {
            System.out.println("Laskutoimitus ei ollut määritelty!");
        }
    }
}
