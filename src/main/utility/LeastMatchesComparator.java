package utility;

import model.Opening;

import java.util.Comparator;

// Comparator used for sorting by the opening with the least matches
public class LeastMatchesComparator implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o1.getTotalGames().compareTo(o2.getTotalGames());
    }
}