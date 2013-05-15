
public class Main {

    public static int[][] esim1 = new int[][]{
        {0, 1, 0},
        {1, 0, 2},
        {0, 2, 0}
    };
    public static int[][] esim2 = new int[][]{
        {0, 1, 0, 0},
        {1, 0, 0, 0},
        {0, 0, 0, 2},
        {0, 0, 2, 0}
    };
    public static int[][] esim3 = new int[][]{
        {0, 1, 7, 0, 0},
        {1, 0, 0, 4, 2},
        {7, 0, 0, 1, 0},
        {0, 4, 1, 0, 1},
        {0, 2, 0, 1, 0}
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatriisiLaskin laskin = new MatriisiLaskin(esim3, esim3);
        int[][] tulos = laskin.pluslasku();
        for (int i = 0; i < tulos.length; i++) {
            for (int j = 0; j < tulos[0].length; j++) {
                System.out.print(tulos[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
