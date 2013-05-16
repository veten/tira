
/**
 * MatriisiLaskin-luokka toteuttaa sille annetuille matriiseille
 * matriisilaskutoimituksia
 */
public class MatriisiLaskin {

    /**
     * Laskimen matriisi jolle laskutoimitus tehdään
     */
    private int[][] matriisi1;
    /**
     * Laskimen matriisi jolle laskutoimitus tehdään
     */
    private int[][] matriisi2;

    /**
     * Konstruktori, jossa alustetaan laskimelle syötetyt matriisit
     *
     * @param matriisi1 Käyttäjän syötteeksi antama matriisi
     * @param matriisi2 Käyttäjän syötteeksi antama matriisi
     *
     */
    public MatriisiLaskin(int[][] matriisi1, int[][] matriisi2) {
        this.matriisi1 = matriisi1;
        this.matriisi2 = matriisi2;
    }

    /**
     * Vaihtoehtoinen konstruktori tilanteeseen, jossa tarvitaan laskimelle vain
     * yksi matriisi, esimerkiksi jos halutaan laskea matriisin determinantti.
     * Tällöin toinen matriisi jätetään null-arvoiseksi.
     *
     * @param matriisi1 Käyttäjän laskimelle syötteeksi antama matriisi
     *
     */
    public MatriisiLaskin(int[][] matriisi1) {
        this.matriisi1 = matriisi1;
        this.matriisi2 = null;
    }

    /**
     * Metodi laskee kahden sille annetun matriisin matriisi-yhteenlaskun
     *
     * @return yhteenlaskun tulos matriisina tai null-arvo, jos laskutoimitusta
     * ei voitu suorittaa
     */
    public int[][] matriisiYhteenlasku() {
        if (matriisi2 != null && matriisi1.length == matriisi2.length && matriisi1[0].length == matriisi2[0].length) {
            int[][] tulosMatriisi = new int[matriisi1.length][matriisi1[0].length];
            for (int i = 0; i < matriisi1.length; i++) {
                for (int j = 0; j < matriisi1[0].length; j++) {
                    tulosMatriisi[i][j] = matriisi1[i][j] + matriisi2[i][j];
                }
            }
            return tulosMatriisi;
        }
        return null;
    }

    /**
     * Metodi laskee kahden sille annetun matriisin matriisi-kertolaskun
     *
     * @return kertolaskun tulos matriisina tai null-arvo, jos laskutoimitusta
     * ei voitu suorittaa
     */
    public int[][] matriisiKertolasku() {
        if (matriisi2 != null && matriisi1[0].length == matriisi2.length) {
            int[][] tulosMatriisi = new int[matriisi1.length][matriisi2[0].length];
            for (int i = 0; i < matriisi1.length; i++) {
                for (int j = 0; j < matriisi2[0].length; j++) {
                    tulosMatriisi[i][j] = 0;
                    for (int k = 0; k < matriisi1[0].length; k++) {
                        tulosMatriisi[i][j] += matriisi1[i][k] * matriisi2[k][j];
                    }
                }
            }
            return tulosMatriisi;
        }
        return null;
    }
}
