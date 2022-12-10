package com.company;
import java.util.Map;

public class Word {
    private Map<String, Meaning[]> meanings;
    private String[] antonyms;
    private String[] synonyms;


    public Map<String, Meaning[]> getMeanings() { return meanings; }

    public void setMeanings(Map<String, Meaning[]> value) { this.meanings = value; }


    public String[] getAntonyms() { return antonyms; }

    public void setAntonyms(String[] value) { this.antonyms = value; }


    public String[] getSynonyms() { return synonyms; }

    public void setSynonyms(String[] value) { this.synonyms = value; }
}

