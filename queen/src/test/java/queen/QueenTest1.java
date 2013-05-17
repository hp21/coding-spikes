package queen;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QueenTest1

{

    @Test
    public void Queen1Test() {

        final Queen1 queen = new Queen1();
        queen.run();

    }

    @Test
    public void check_Columns_OK() {
        final Queen1 queen = new Queen1();
        queen.getChess()[0][0] = 1;

        assertThat(queen.checkRowsFree(4, 1), is(true));
        assertThat(queen.checkRowsFree(1, 0), is(true));
        assertThat(queen.checkRowsFree(7, 0), is(true));

        assertThat(queen.checkRowsFree(0, 7), is(false));

        queen.getChess()[0][0] = 0;
        queen.getChess()[2][3] = 1;
        assertThat(queen.checkRowsFree(2, 3), is(false));
        assertThat(queen.checkRowsFree(2, 4), is(false));
        assertThat(queen.checkRowsFree(2, 5), is(false));
        assertThat(queen.checkRowsFree(2, 6), is(false));
        assertThat(queen.checkRowsFree(2, 7), is(false));

        assertThat(queen.checkRowsFree(3, 0), is(true));
        assertThat(queen.checkRowsFree(3, 7), is(true));

        assertThat(queen.checkRowsFree(1, 0), is(true));
        assertThat(queen.checkRowsFree(0, 0), is(true));

    }

    @Test
    public void check_Diagonal_OK() {
        final Queen1 queen = new Queen1();
        queen.getChess()[0][0] = 1;
        assertThat(queen.checkDiagonalOK(0, 0), is(false));
        assertThat(queen.checkDiagonalOK(1, 1), is(false));
        assertThat(queen.checkDiagonalOK(1, 2), is(true));
        assertThat(queen.checkDiagonalOK(2, 2), is(false));
        assertThat(queen.checkDiagonalOK(4, 4), is(false));

        queen.getChess()[0][0] = 0;
        queen.getChess()[2][3] = 1;
        assertThat(queen.checkDiagonalOK(3, 4), is(false));

    }

    @Test
    public void available_0_0Test() {

        final Queen1 queen = new Queen1();
        queen.getChess()[0][0] = 1;

        assertThat(queen.available(0, 1), is(false));
        assertThat(queen.available(0, 3), is(false));
        assertThat(queen.available(0, 7), is(false));

    }

    @Test
    public void available_1_0Test() {

        final Queen1 queen = new Queen1();
        queen.getChess()[1][0] = 1;

        assertThat(queen.available(2, 1), is(false));
        assertThat(queen.available(2, 3), is(true));
        assertThat(queen.available(3, 2), is(false));
        assertThat(queen.available(3, 3), is(true));

    }

    @Test
    public void available_2_3Test() {

        final Queen1 queen = new Queen1();
        queen.getChess()[2][3] = 1;

        assertThat(queen.available(2, 3), is(false));
        assertThat(queen.available(3, 4), is(false));

    }

}
