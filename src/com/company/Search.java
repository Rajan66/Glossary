package com.company;

import java.util.ArrayList;

public class Search {

    public int binarySearch(ArrayList<Words> data, String x) {
        int low = 0;
        int high = data.size() - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            String word  = data.get(mid).getWord().replaceAll("\\s+", "");
            int result = x.compareTo(word.toLowerCase());
            if (result == 0)
                return mid;
            if (result > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
