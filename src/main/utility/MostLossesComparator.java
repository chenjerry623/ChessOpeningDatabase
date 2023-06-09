package utility;

import model.Opening;

import java.util.Comparator;

// Comparator used for sorting by the opening with the most losses
public class MostLossesComparator implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o2.getLossCount().compareTo(o1.getLossCount());
    }
}