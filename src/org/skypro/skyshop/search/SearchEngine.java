package org.skypro.skyshop.search;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new LinkedList<>();
    }

    public void add(Searchable searchable) {
        if (searchable == null) {
            throw new IllegalArgumentException("Объект не может быть null");
        }
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();
        int resultCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.put(searchable.getName(), searchable);
                resultCount++; //счётчик оставлен просто на всякий случай, на будущее. Не понадобится, уберём
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String searchTerm = searchable.getSearchTerm();
                int count = countCoincidences(searchTerm, search);

                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = searchable;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Для запроса '" + search + "' не найдено подходящего объекта.");
        }

        return bestMatch;
    }

    private int countCoincidences(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substringLength;
        }

        return count;
    }
}
