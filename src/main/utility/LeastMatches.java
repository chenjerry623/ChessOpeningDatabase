package utility;

import model.Opening;

import java.util.Comparator;

public class LeastMatches implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o1.getTotalGames().compareTo(o2.getTotalGames());
    }
}