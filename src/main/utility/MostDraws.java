package utility;

import model.Opening;

import java.util.Comparator;

public class MostDraws implements Comparator<Opening> {
    @Override
    public int compare(Opening o1, Opening o2) {
        return o2.getDrawCount().compareTo(o1.getDrawCount());
    }
}