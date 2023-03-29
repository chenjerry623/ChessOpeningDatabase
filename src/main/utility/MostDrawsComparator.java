package utility;

import model.Opening;

import java.util.Comparator;

// Comparator used for sorting by the opening with the most draws
public class MostDrawsComparator implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o2.getDrawCount().compareTo(o1.getDrawCount());
    }
}