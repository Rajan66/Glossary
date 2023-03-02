package com.company;

import java.util.ArrayList;

import static com.company.Main.*;

public class Sort {
    public void sort(ArrayList<Words> books) {
        if (books == null || books.size() == 0) {
            return;
        }
        wordList = books;
        length = books.size();
        quickSort(0, length - 1);
    }

    public void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;

        String pivot = wordList.get(lowerIndex + (higherIndex - lowerIndex) / 2).getWord().replaceAll("\\s+", "");

        while (i <= j) {

            while (wordList.get(i).getWord().replaceAll("\\s+", "").compareToIgnoreCase(pivot) < 0) {
                i++;

            }

            while (wordList.get(j).getWord().replaceAll("\\s+", "").compareToIgnoreCase(pivot) > 0) {
                j--;

            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        //call quickSort recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    public void swap(int i, int j) {
        Words temp = wordList.get(i);
        wordList.set(i, wordList.get(j));
        wordList.set(j, temp);
    }
}
