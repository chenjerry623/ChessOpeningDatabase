package utility;

import model.Opening;

import java.util.Comparator;

// Comparator used for sorting by the opening with the most wins
public class MostWinsComparator implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o2.getWinCount().compareTo(o1.getWinCount());
    }
}