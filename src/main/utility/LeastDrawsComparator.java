package utility;

import model.Opening;

import java.util.Comparator;

public class LeastDrawsComparator implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o1.getDrawCount().compareTo(o2.getDrawCount());
    }
}