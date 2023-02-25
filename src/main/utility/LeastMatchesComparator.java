package utility;

import model.Opening;

import java.util.Comparator;

public class LeastMatchesComparator implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o1.getTotalGames().compareTo(o2.getTotalGames());
    }
}