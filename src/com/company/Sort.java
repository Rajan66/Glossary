package com.company;

import java.util.ArrayList;

import static com.company.Main.*;
public class Sort {


    public void sort(ArrayList<String> array) {
        if (array == null || array.size() == 0) {
            return;
        }
        list = array;
        length = array.size();
        quickSort(0, length - 1);
    }

    public void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;

        String pivot = list.get(lowerIndex + (higherIndex - lowerIndex) / 2).replaceAll("\\s+", "");

        while (i <= j) {

            while (list.get(i).replaceAll("\\s+", "").compareToIgnoreCase(pivot) < 0) {
                i++;

            }

            while (list.get(j).replaceAll("\\s+", "").compareToIgnoreCase(pivot) > 0) {
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
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
