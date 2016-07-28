package sicp;

/**
 * Created by hp21 on 2014.11.28..
 */
public class Summing {

    public int addIncrement(int low, int high) {
        int sum = 0;

        for (int i = low; i <= high; i++) {
            sum = sum + i;
        }

        return sum;
    }

    public int addSquare(int low, int high) {
        int sum = 0;

        for (int i = low; i <= high; i++) {
            sum = sum + i * i;
        }

        return sum;
    }

    public int addGeneral(int low, int high, INext next, IAccumulator acc) {
        int sum = 0;

        int i = low;

        while (i <= high) {
            sum = acc.acc(sum, i);
            i = next.next(i);
        }

        return sum;
    }

    public int addIncrementNew(int low, int high) {

        return addGeneral(low, high, new INext() {
            @Override
            public int next(int i) {
                return i + 1;
            }
        }, new IAccumulator() {
            @Override
            public int acc(int sum, int i) {
                return sum + i;
            }
        });
    }

    public int addSquareNew(int low, int high) {

        return addGeneral(low, high, new INext() {
            @Override
            public int next(int i) {
                return i + 1;
            }
        }, new IAccumulator() {
            @Override
            public int acc(int sum, int i) {
                return sum + i * i;
            }
        });
    }
}
