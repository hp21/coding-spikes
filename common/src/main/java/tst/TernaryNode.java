package tst;

/**
 * Created by hp21 on 2014.11.11..
 */
public class TernaryNode {

    private TernaryNode low;
    private TernaryNode mid;
    private TernaryNode high;

    private char aChar;

    public TernaryNode(TernaryNode low, TernaryNode mid, TernaryNode high, char aChar) {
        this.low = low;
        this.mid = mid;
        this.high = high;
        this.aChar = aChar;
    }

    public TernaryNode getLow() {
        return low;
    }

    public TernaryNode getMid() {
        return mid;
    }

    public TernaryNode getHigh() {
        return high;
    }

    public char getaChar() {
        return aChar;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TernaryNode{");
        sb.append("low=").append(low);
        sb.append(", mid=").append(mid);
        sb.append(", high=").append(high);
        sb.append(", aChar=").append(aChar);
        sb.append('}');
        return sb.toString();
    }
}
