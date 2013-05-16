
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatriisiLaskinTest {

    private static MatriisiLaskin laskin;

    public MatriisiLaskinTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        int[][] mat1 = new int[][]{
            {2, 1, 7},
            {5, 6, 10},
            {9, 3, 0}
        };
        int[][] mat2 = new int[][]{
            {4, 9, 12},
            {4, 7, 8},
            {6, 2, 20}
        };
        laskin = new MatriisiLaskin(mat1, mat2);
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

    @Test
    public void matriisiYhteenlaskuTest() {
        assertTrue(laskin.matriisiYhteenlasku()[1][1] == 13);
        assertTrue(laskin.matriisiYhteenlasku()[2][1] == 5);
        assertTrue(laskin.matriisiYhteenlasku()[1][0] == 9);
    }

    @Test
    public void matriisiKertolaskuTest() {
        assertTrue(laskin.matriisiKertolasku()[1][1] == 107);
        assertTrue(laskin.matriisiKertolasku()[2][1] == 102);
        assertTrue(laskin.matriisiKertolasku()[1][0] == 104);
    }

    @Test
    public void matriisiLaskuEiMaariteltyTest() {
        int[][] mat3 = new int[][]{
            {2, 1, 7},
            {5, 6, 10},
            {9, 3, 0}
        };
        int[][] mat4 = new int[][]{
            {2, 1},
            {5, 6},
            {9, 3}
        };
        MatriisiLaskin laskin2 = new MatriisiLaskin(mat3, mat4);
        assertTrue(laskin2.matriisiKertolasku() != null);
        assertTrue(laskin2.matriisiYhteenlasku() == null);
        MatriisiLaskin laskin3 = new MatriisiLaskin(mat4, mat3);
        assertTrue(laskin3.matriisiKertolasku() == null);
        assertTrue(laskin3.matriisiYhteenlasku() == null);
        MatriisiLaskin laskin4 = new MatriisiLaskin(mat4);
        assertTrue(laskin4.matriisiKertolasku() == null);
        assertTrue(laskin4.matriisiYhteenlasku() == null);
    }
}
