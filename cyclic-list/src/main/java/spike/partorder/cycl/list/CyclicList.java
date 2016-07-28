package spike.partorder.cycl.list;

import java.util.List;

import com.google.common.base.Preconditions;

/**
 * User: P Horvath Date: 2013.04.14. Time: 13:28
 */
public class CyclicList {

    public CyclicList() {
    }

    public boolean checkLists(List<?> aList, List<?> bList) {
        Preconditions.checkNotNull(aList, "aList can not be null");
        Preconditions.checkNotNull(bList, "bList can not be null");

        if (aList.size() != bList.size()) {
            return false;
        }

        boolean ret = false;

        for (int i = 0; i < aList.size(); i++) {
            if (aList.get(i).equals(bList.get(0))) {
                // found an offset
                ret = check(aList, bList, i);
                if (ret) {
                    break;
                }
            }
        }

        return ret;
    }

    private boolean check(List<?> aList, List<?> bList, int offset) {
        boolean result = true;

        for (int z = 0; z < bList.size(); z++) {
            if (!bList.get(z).equals(aList.get((z + offset) % aList.size()))) {
                result = false;
                break;
            }
        }

        return result;
    }
}
