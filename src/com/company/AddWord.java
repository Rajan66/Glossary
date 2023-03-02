package com.company;

import org.json.JSONArray;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import static com.company.Helper.word;
import static com.company.Main.*;

public class AddWord extends JFrame {

    private JTextField tfWord;
    private JTextField tfMeaning;
    private JButton btnAdd;


    public AddWord() {
        super("Add Word");
        setSize(300, 200);

        tfWord = new JTextField(30);
        tfMeaning = new JTextField(30);

        btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             if (tfWord.getText().length() > 0 && tfMeaning.getText().length() > 0) {

                 Words newWord = new Words();
                 newWord.setWord(tfWord.getText());

                 newWord.setMeaning(tfMeaning.getText());

                 wordList.add(newWord);
                 try {
                     FileWriter fileWriter = new FileWriter("res\\dictionary.json");

                     JSONArray jsonArray = new JSONArray(word);

                     fileWriter.write(jsonArray.toString());

                     fileWriter.flush();
                     sorter.sort(wordList);
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
                 JOptionPane.showMessageDialog(AddWord.this, "Successfully Added a Word!!",
                         "Add Word", JOptionPane.INFORMATION_MESSAGE);
                 tfWord.setText("");
                 tfMeaning.setText("");


                 tfWord.requestFocus();
             } else {
                 JOptionPane.showMessageDialog(AddWord.this, "Please fill all the details!", "Add Word", JOptionPane.ERROR_MESSAGE);
                 tfMeaning.requestFocus();
             }
         }
     }
        );

        JLabel lWord = new JLabel("Word: ");
        JLabel lMeaning = new JLabel("Meaning: ");
        JLabel blank = new JLabel();


        lWord.setBounds(50, 20, 60, 30);
        tfWord.setBounds(150, 20, 100, 30);

        lMeaning.setBounds(50, 60, 60, 30);
        tfMeaning.setBounds(150, 60, 100, 30);


        blank.setBounds(50,80,100,30);

        btnAdd.setBounds(80, 100, 100, 30);


        add(tfWord);
        add(tfMeaning);
        add(btnAdd);

        add(lWord);
        add(lMeaning);
        add(blank);
    }
}

