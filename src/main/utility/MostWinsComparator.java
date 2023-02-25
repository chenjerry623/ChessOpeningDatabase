package utility;

import model.Opening;

import java.util.Comparator;

public class MostWinsComparator implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o2.getWinCount().compareTo(o1.getWinCount());
    }
}