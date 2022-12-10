package com.company;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;

public class Main {

    static List<Word> dictionary;

    public static void main(String[] args) {
        getWordList();
        System.out.println(dictionary.get(0).getSynonyms().toString());
    }


    public static void getWordList() {
        int i = 0;
        try {
            for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
                Object obj = new JSONParser().parse(new FileReader("C:\\Users\\Radhika\\IdeaProjects\\Word Dictionary\\" +
                        "res\\data\\D" + alphabet + ".json"));
                JSONObject jo = (JSONObject) obj;
                dictionary = new ArrayList<>();
                Word a = new Word();
                dictionary.add(a);
                JSONArray synonyms = (JSONArray) jo.get("SYNONYMS");
                String[] syn = {(String) synonyms.get(0), (String) synonyms.get(1), (String) synonyms.get(2)};
                dictionary.get(0).setSynonyms(syn);
            }// TODO maybe need to get the parent first(word) then the childs(meanings, antonym, synonym)
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
