package com.company;

import java.util.ArrayList;

public class Main {

    static ArrayList<Words> wordList;
    static int length;
    static Helper obj = new Helper();
    static Sort sorter = new Sort();
    static Search searcher = new Search();
    static Frame frame;

    public static void main(String[] args) throws Exception {
        wordList = (ArrayList<Words>) obj.getList();

        frame = new Frame();
        frame.run();
    }
}
