package utility;

import model.Opening;

import java.util.Comparator;

public class MostLosses implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o2.getLossCount().compareTo(o1.getLossCount());
    }
}