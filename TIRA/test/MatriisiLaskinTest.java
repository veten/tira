
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MatriisiLaskinTest-luokka testaa MatriisiLaskin-luokan metodit
 */
public class MatriisiLaskinTest {

    /**
     * MatriisiLaskin, jota käytetään testeissä
     */
    private static MatriisiLaskin laskin;
    /**
     * Testeissä käytettävä esimerkkimatriisi
     */
    int[][] mat1 = new int[][]{
        {2, 1, 7},
        {5, 6, 10},
        {9, 3, 0}
    };
    /**
     * Testeissä käytettävä esimerkkimatriisi
     */
    int[][] mat2 = new int[][]{
        {4, 9, 12},
        {4, 7, 8},
        {6, 2, 20}
    };
    /**
     * Testeissä käytettävä esimerkkimatriisi
     */
    int[][] mat3 = new int[][]{
        {2, 1, 7},
        {5, 6, 10},
        {9, 3, 0}
    };
    /**
     * Testeissä käytettävä esimerkkimatriisi
     */
    int[][] mat4 = new int[][]{
        {2, 1},
        {5, 6},
        {9, 3}
    };
    /**
     * Testeissä käytettävä esimerkkimatriisi
     */
    int[][] mat5 = new int[][]{
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
     * Testeissä käytettävä esimerkkimatriisi
     */
    int[][] mat6 = new int[][]{
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

    public MatriisiLaskinTest() {
    }

    /**
     * Alustetaan MatriisiLaskin
     */
    @BeforeClass
    public static void setUpClass() {
        laskin = new MatriisiLaskin();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Metodi vertaa muutamaa matriisiYhteenlaskun tuottaman matriisin arvoa
     * vastaaviin mekaanisesti laskettuihin arvoihin.
     */
    @Test
    public void matriisiYhteenlaskuTest() {
        assertTrue(laskin.matriisiYhteenlasku(mat1, mat2)[1][1] == 13);
        assertTrue(laskin.matriisiYhteenlasku(mat1, mat2)[2][1] == 5);
        assertTrue(laskin.matriisiYhteenlasku(mat1, mat2)[1][0] == 9);
    }

    /**
     * Metodi vertaa muutamaa matriisiVahennyslaskun tuottaman matriisin arvoa
     * vastaaviin mekaanisesti laskettuihin arvoihin.
     */
    @Test
    public void matriisiVahennyslaskuTest() {
        assertTrue(laskin.matriisiVahennyslasku(mat1, mat2)[1][1] == -1);
        assertTrue(laskin.matriisiVahennyslasku(mat1, mat2)[2][1] == 1);
        assertTrue(laskin.matriisiVahennyslasku(mat1, mat2)[1][0] == 1);
    }

    /**
     * Metodi vertaa muutamaa matriisiKertolaskun tuottaman matriisin arvoa
     * vastaaviin mekaanisesti laskettuihin arvoihin.
     */
    @Test
    public void matriisiKertolaskuTest() {
        assertTrue(laskin.matriisiKertolasku(mat1, mat2)[1][1] == 107);
        assertTrue(laskin.matriisiKertolasku(mat1, mat2)[2][1] == 102);
        assertTrue(laskin.matriisiKertolasku(mat1, mat2)[1][0] == 104);
    }

    /**
     * Metodi testaa muutamia laskutoimituksia, joita ei ole määritelty ja
     * tarkistaa, palauttaako metodi halutusti null-arvon
     */
    @Test
    public void matriisiLaskuEiMaariteltyTest() {
        assertTrue(laskin.matriisiKertolasku(mat3, mat4) != null);
        assertTrue(laskin.matriisiYhteenlasku(mat3, mat4) == null);
        assertTrue(laskin.matriisiKertolasku(mat4, mat3) == null);
        assertTrue(laskin.matriisiYhteenlasku(mat4, mat3) == null);
    }

    /**
     * Metodi laskee matriisikertolaskun sekä rekursiivisella metodilla että
     * Strassen algoritmilla ja vertaa indekseittäin, että kaikki arvot ovat
     * samat. Lisäksi sama vertailu on tehty triviaaliratkaisuun verraten, mutta
     * jotta tämä olisi mielekästä, täytyy ko metodista poistaa ehto, joka ohjaa
     * neliömatriisien käsittelyn Strassen algoritmille. Näin toimien on
     * testattu ja saatu vahvistus algoritmien oikeellisuudesta.
     */
    @Test
    public void matriisikertolaskuEriMetodeillaSamaanTulokseenPaatyenTest() {
        int[][] tulosMatriisi1 = laskin.matriisiKertolaskuRekursiivisestiNeliomatriiseille(mat5, mat6);
        int[][] tulosMatriisi2 = laskin.matriisiKertolaskuStrassenAlgoritmillaNeliomatriiseille(mat5, mat6);
        int[][] tulosMatriisi3 = laskin.matriisiKertolasku(mat5, mat6);

        for (int i = 0; i < tulosMatriisi1.length; i++) {
            for (int j = 0; j < tulosMatriisi1[0].length; j++) {
                assertTrue(tulosMatriisi1[i][j] == tulosMatriisi2[i][j]);
                assertTrue(tulosMatriisi2[i][j] == tulosMatriisi3[i][j]);
            }
        }
    }
}
