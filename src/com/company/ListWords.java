package com.company;

import javax.swing.*;

import static com.company.Main.wordList;

public class ListWords extends JFrame{

    public ListWords() {
        super("View Words");
        setSize(600, 300);

        String[] column = {"Word","Meaning"};
        Object[][] data = new Object[wordList.size()][];
        for (int i = 0; i < wordList.size(); i++) {
            data[i] = wordList.get(i).toObjectArray();
        }

        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 600, 300);
        JScrollPane sp = new JScrollPane(jt);

        add(sp);
    }

}