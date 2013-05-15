
public class MatriisiLaskin {

    private int[][] matriisi1;
    private int[][] matriisi2;

    public MatriisiLaskin(int[][] matriisi1, int[][] matriisi2) {
        this.matriisi1 = matriisi1;
        this.matriisi2 = matriisi2;
    }

    public MatriisiLaskin(int[][] matriisi1) {
        this.matriisi1 = matriisi1;
        this.matriisi2 = null;
    }
    
    
    
    public int[][] pluslasku() {
        if (matriisi2 != null && matriisi1.length == matriisi2.length && matriisi1[0].length == matriisi2[0].length) {
            int[][] tulos = new int[matriisi1.length][matriisi1[0].length];
            for (int i = 0; i < matriisi1.length; i++) {
                for (int j = 0; j < matriisi1[0].length; j++) {
                    tulos[i][j] = matriisi1[i][j] + matriisi2[i][j];
                }
            }
            return tulos;
        }
        return null;
    }
    
}
