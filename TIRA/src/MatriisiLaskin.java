
/**
 * MatriisiLaskin-luokka toteuttaa matriisilaskutoimituksia ja muita
 * operaatioita matriiseille
 */
public class MatriisiLaskin {

    /**
     * Metodi laskee kahden sille annetun matriisin matriisi-yhteenlaskun
     *
     * @param matriisi1 vasemman puoleinen yhteenlaskettavista matriiseista
     * @param matriisi2 oikean puoleinen yhteenlaskettavista matriiseista
     *
     * @return yhteenlaskun tulos matriisina tai null-arvo, jos laskutoimitusta
     * ei voitu suorittaa
     */
    public int[][] matriisiYhteenlasku(int[][] matriisi1, int[][] matriisi2) {
        if (matriisi1.length == matriisi2.length && matriisi1[0].length == matriisi2[0].length) {
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
     * Metodi laskee kahden sille annetun matriisin matriisi-vähennyslaskun
     *
     * @param matriisi1 vasemman puoleinen laskettavista matriiseista, eli se
     * matriisi, josta toinen vähennetään
     * @param matriisi2 oikean puoleinen laskettavista matriiseista, eli
     * vähennettävä matriisi
     *
     * @return yhteenlaskun tulos matriisina tai null-arvo, jos laskutoimitusta
     * ei voitu suorittaa
     */
    public int[][] matriisiVahennyslasku(int[][] matriisi1, int[][] matriisi2) {
        if (matriisi1.length == matriisi2.length && matriisi1[0].length == matriisi2[0].length) {
            int[][] tulosMatriisi = new int[matriisi1.length][matriisi1[0].length];
            for (int i = 0; i < matriisi1.length; i++) {
                for (int j = 0; j < matriisi1[0].length; j++) {
                    tulosMatriisi[i][j] = matriisi1[i][j] - matriisi2[i][j];
                }
            }
            return tulosMatriisi;
        }
        return null;
    }

    /**
     * Metodi laskee kahden sille annetun matriisin matriisi-kertolaskun. Jos
     * kyseessä on neliömatriisit, tehdään laskutoimitus Strassen algoritmilla,
     * joka on hieman tehokkaampi
     *
     * @param matriisi1 vasemman puoleinen laskettavista matriiseista
     * @param matriisi2 oikean puoleinen laskettavista matriiseista
     *
     * @return kertolaskun tulos matriisina tai null-arvo, jos laskutoimitusta
     * ei voitu suorittaa
     */
    public int[][] matriisiKertolasku(int[][] matriisi1, int[][] matriisi2) {
        if (matriisi1[0].length == matriisi2.length) {
            if (matriisi1.length == matriisi1[0].length && matriisi2.length == matriisi2[0].length) {
                return matriisiKertolaskuStrassenAlgoritmillaNeliomatriiseille(matriisi1, matriisi2);
            }
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

    /**
     * Metodi laskee kahden sille annetun neliömatriisin matriisi-kertolaskun
     * rekursiolla.
     *
     * @param matriisi1 vasemman puoleinen laskettavista matriiseista
     * @param matriisi2 oikean puoleinen laskettavista matriiseista
     *
     * @return kertolaskun tulos matriisina
     */
    public int[][] matriisiKertolaskuRekursiivisestiNeliomatriiseille(int[][] matriisi1, int[][] matriisi2) {
        int koko = matriisi1.length;
        int[][] tulosMatriisi = new int[koko][koko];
        if (koko == 1) {
            tulosMatriisi[0][0] = matriisi1[0][0] * matriisi2[0][0];
        } else {
            int uusiKoko = koko / 2;
            if (koko % 2 == 1) {
                uusiKoko++;
            }
            int[][] a11 = new int[uusiKoko][uusiKoko];
            int[][] a12 = new int[uusiKoko][uusiKoko];
            int[][] a21 = new int[uusiKoko][uusiKoko];
            int[][] a22 = new int[uusiKoko][uusiKoko];
            int[][] b11 = new int[uusiKoko][uusiKoko];
            int[][] b12 = new int[uusiKoko][uusiKoko];
            int[][] b21 = new int[uusiKoko][uusiKoko];
            int[][] b22 = new int[uusiKoko][uusiKoko];

            for (int i = 0; i < matriisi1.length; i++) {
                for (int j = 0; j < matriisi1[0].length; j++) {
                    if (j < uusiKoko && i < uusiKoko) {
                        a11[i][j] = matriisi1[i][j];
                        b11[i][j] = matriisi2[i][j];
                    }
                    if (j >= uusiKoko && i < uusiKoko) {
                        a12[i][j - uusiKoko] = matriisi1[i][j];
                        b12[i][j - uusiKoko] = matriisi2[i][j];
                    }
                    if (j < uusiKoko && i >= uusiKoko) {
                        a21[i - uusiKoko][j] = matriisi1[i][j];
                        b21[i - uusiKoko][j] = matriisi2[i][j];
                    }
                    if (j >= uusiKoko && i >= uusiKoko) {
                        a22[i - uusiKoko][j - uusiKoko] = matriisi1[i][j];
                        b22[i - uusiKoko][j - uusiKoko] = matriisi2[i][j];
                    }
                }
            }
            int[][] c11 = matriisiYhteenlasku(matriisiKertolaskuRekursiivisestiNeliomatriiseille(a11, b11), matriisiKertolaskuRekursiivisestiNeliomatriiseille(a12, b21));
            int[][] c12 = matriisiYhteenlasku(matriisiKertolaskuRekursiivisestiNeliomatriiseille(a11, b12), matriisiKertolaskuRekursiivisestiNeliomatriiseille(a12, b22));
            int[][] c21 = matriisiYhteenlasku(matriisiKertolaskuRekursiivisestiNeliomatriiseille(a21, b11), matriisiKertolaskuRekursiivisestiNeliomatriiseille(a22, b21));
            int[][] c22 = matriisiYhteenlasku(matriisiKertolaskuRekursiivisestiNeliomatriiseille(a21, b12), matriisiKertolaskuRekursiivisestiNeliomatriiseille(a22, b22));

            for (int i = 0; i < matriisi1.length; i++) {
                for (int j = 0; j < matriisi1[0].length; j++) {
                    if (j < uusiKoko && i < uusiKoko) {
                        tulosMatriisi[i][j] = c11[i][j];
                    }
                    if (j >= uusiKoko && i < uusiKoko) {
                        tulosMatriisi[i][j] = c12[i][j - uusiKoko];
                    }
                    if (j < uusiKoko && i >= uusiKoko) {
                        tulosMatriisi[i][j] = c21[i - uusiKoko][j];
                    }
                    if (j >= uusiKoko && i >= uusiKoko) {
                        tulosMatriisi[i][j] = c22[i - uusiKoko][j - uusiKoko];
                    }
                }
            }
        }
        return tulosMatriisi;
    }

    /**
     * Metodi laskee kahden sille annetun neliömatriisin matriisi-kertolaskun
     * Strassen algoritmilla, joka on hieman tehokkaampi triviaaliratkaisuun
     * verrattuna
     *
     * @param matriisi1 vasemman puoleinen laskettavista matriiseista
     * @param matriisi2 oikean puoleinen laskettavista matriiseista
     *
     * @return kertolaskun tulos matriisina
     */
    public int[][] matriisiKertolaskuStrassenAlgoritmillaNeliomatriiseille(int[][] matriisi1, int[][] matriisi2) {
        int koko = matriisi1.length;
        int[][] tulosMatriisi = new int[koko][koko];
        if (koko == 1) {
            tulosMatriisi[0][0] = matriisi1[0][0] * matriisi2[0][0];
        } else {
            int uusiKoko = koko / 2;
            if (koko % 2 == 1) {
                uusiKoko++;
            }
            int[][] a11 = new int[uusiKoko][uusiKoko];
            int[][] a12 = new int[uusiKoko][uusiKoko];
            int[][] a21 = new int[uusiKoko][uusiKoko];
            int[][] a22 = new int[uusiKoko][uusiKoko];
            int[][] b11 = new int[uusiKoko][uusiKoko];
            int[][] b12 = new int[uusiKoko][uusiKoko];
            int[][] b21 = new int[uusiKoko][uusiKoko];
            int[][] b22 = new int[uusiKoko][uusiKoko];

            for (int i = 0; i < matriisi1.length; i++) {
                for (int j = 0; j < matriisi1[0].length; j++) {
                    if (j < uusiKoko && i < uusiKoko) {
                        a11[i][j] = matriisi1[i][j];
                        b11[i][j] = matriisi2[i][j];
                    }
                    if (j >= uusiKoko && i < uusiKoko) {
                        a12[i][j - uusiKoko] = matriisi1[i][j];
                        b12[i][j - uusiKoko] = matriisi2[i][j];
                    }
                    if (j < uusiKoko && i >= uusiKoko) {
                        a21[i - uusiKoko][j] = matriisi1[i][j];
                        b21[i - uusiKoko][j] = matriisi2[i][j];
                    }
                    if (j >= uusiKoko && i >= uusiKoko) {
                        a22[i - uusiKoko][j - uusiKoko] = matriisi1[i][j];
                        b22[i - uusiKoko][j - uusiKoko] = matriisi2[i][j];
                    }
                }
            }

            int[][] s1 = matriisiVahennyslasku(b12, b22);
            int[][] s2 = matriisiYhteenlasku(a11, a12);
            int[][] s3 = matriisiYhteenlasku(a21, a22);
            int[][] s4 = matriisiVahennyslasku(b21, b11);
            int[][] s5 = matriisiYhteenlasku(a11, a22);
            int[][] s6 = matriisiYhteenlasku(b11, b22);
            int[][] s7 = matriisiVahennyslasku(a12, a22);
            int[][] s8 = matriisiYhteenlasku(b21, b22);
            int[][] s9 = matriisiVahennyslasku(a11, a21);
            int[][] s10 = matriisiYhteenlasku(b11, b12);

            int[][] p1 = matriisiKertolasku(a11, s1);
            int[][] p2 = matriisiKertolasku(s2, b22);
            int[][] p3 = matriisiKertolasku(s3, b11);
            int[][] p4 = matriisiKertolasku(a22, s4);
            int[][] p5 = matriisiKertolasku(s5, s6);
            int[][] p6 = matriisiKertolasku(s7, s8);
            int[][] p7 = matriisiKertolasku(s9, s10);

            int[][] c11 = matriisiYhteenlasku(matriisiVahennyslasku(matriisiYhteenlasku(p5, p4), p2), p6);
            int[][] c12 = matriisiYhteenlasku(p1, p2);
            int[][] c21 = matriisiYhteenlasku(p3, p4);
            int[][] c22 = matriisiVahennyslasku(matriisiVahennyslasku(matriisiYhteenlasku(p5, p1), p3), p7);

            for (int i = 0; i < matriisi1.length; i++) {
                for (int j = 0; j < matriisi1[0].length; j++) {
                    if (j < uusiKoko && i < uusiKoko) {
                        tulosMatriisi[i][j] = c11[i][j];
                    }
                    if (j >= uusiKoko && i < uusiKoko) {
                        tulosMatriisi[i][j] = c12[i][j - uusiKoko];
                    }
                    if (j < uusiKoko && i >= uusiKoko) {
                        tulosMatriisi[i][j] = c21[i - uusiKoko][j];
                    }
                    if (j >= uusiKoko && i >= uusiKoko) {
                        tulosMatriisi[i][j] = c22[i - uusiKoko][j - uusiKoko];
                    }
                }
            }
        }
        return tulosMatriisi;
    }
}