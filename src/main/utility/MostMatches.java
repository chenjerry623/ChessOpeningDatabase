package utility;

import model.Opening;

import java.util.Comparator;

public class MostMatches implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o2.getTotalGames().compareTo(o1.getTotalGames());
    }
}