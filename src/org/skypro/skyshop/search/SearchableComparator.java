package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        int lengthComparison = Integer.compare(s2.getName().length(), s1.getName().length());
        if (lengthComparison != 0) {
            return lengthComparison;
        }
        return s1.getName().compareTo(s2.getName());
    }
}
