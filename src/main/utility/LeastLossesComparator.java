package utility;

import model.Opening;

import java.util.Comparator;

// Comparator used for sorting by the opening with the least losses
public class LeastLossesComparator implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o1.getLossCount().compareTo(o2.getLossCount());
    }
}