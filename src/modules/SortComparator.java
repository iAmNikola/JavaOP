package modules;

import java.util.Comparator;

public class SortComparator implements Comparator<PlumbingReport> {
	@Override
    public int compare(PlumbingReport o1, PlumbingReport o2) {
        return o1.plumberID.compareTo(o2.plumberID);
    }
}
