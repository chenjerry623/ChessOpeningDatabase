package utility;

import model.Opening;

import java.util.Comparator;

// Comparator used for sorting by the opening with the least wins
public class LeastWinsComparator implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o1.getWinCount().compareTo(o2.getWinCount());
    }
}