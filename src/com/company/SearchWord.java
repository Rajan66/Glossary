package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Main.*;

public class SearchWord extends JFrame{

    private JTextField tfWord;
    private JButton btnSearch;


    public SearchWord() {
        super("Search Word");
        setSize(220, 160);

        tfWord = new JTextField(30);

        btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                        sorter.sort(wordList);
                        if (!tfWord.getText().isEmpty()){
                            String input = tfWord.getText().toLowerCase();

                            int index = searcher.binarySearch(wordList, input.replaceAll("\\s+", ""));
                            if (index == -1) {
                                JOptionPane.showMessageDialog(SearchWord.this,"Word not found!");
                            }else{
                                String output = "Word: " + wordList.get(index).getWord()+
                                                "\nMeaning: " + wordList.get(index).getMeaning();
                                JOptionPane.showMessageDialog(SearchWord.this,output,"Details",JOptionPane.INFORMATION_MESSAGE);
                                tfWord.setText("");
                                tfWord.requestFocus();
                            }
                        } else {
                         JOptionPane.showMessageDialog(SearchWord.this, "Field empty!!!", "Search Word", JOptionPane.ERROR_MESSAGE);
                         tfWord.requestFocus();
                     }
                 }
             }
        );
        JLabel lWord = new JLabel("Word: ");
        JLabel blank = new JLabel();

        lWord.setBounds(10, 30, 60, 30);
        tfWord.setBounds(70, 30, 100, 30);

        blank.setBounds(10, 50, 100, 30);

        btnSearch.setBounds(30, 70, 100, 30);

        add(tfWord);
        add(btnSearch);

        add(lWord);
        add(blank);
    }
}

