package utility;

import model.Opening;

import java.util.Comparator;

public class LeastWinsComparator implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o1.getWinCount().compareTo(o2.getWinCount());
    }
}