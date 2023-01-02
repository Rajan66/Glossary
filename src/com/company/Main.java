package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


//TODO make menu and present a pretty UI........ the display of meanings sucks ass

public class Main {
    static ArrayList<String> list;
    static Map<String, Object> wordMap;
    static int length;


    public static void main(String[] args) throws Exception {
        GetList obj = new GetList();
        Sort sorter = new Sort();
        Search searcher = new Search();

        wordMap = obj.getList();
        list = new ArrayList<>(wordMap.keySet());

        sorter.sort(list);
        for (String word : list){
            System.out.println(word);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        String input = scanner.nextLine();

        searcher.binarySearch(list,input);

        int index = searcher.binarySearch(list, input);
        if (index == -1) {
            System.out.println(input + " not found! Please try another word.");
        } else {
            System.out.println(input + ": " + wordMap.get(input));
        }
    }
}
