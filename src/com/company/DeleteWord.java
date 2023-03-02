package com.company;

import org.json.JSONArray;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import static com.company.Main.*;
import static com.company.Helper.*;


public class DeleteWord extends JFrame {

    private JTextField tfWord;
    private JButton btnDelete;

    public DeleteWord() {
        super("Delete Word");
        setSize(220, 160);


        tfWord = new JTextField(30);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sorter.sort(wordList);
                    if (!tfWord.getText().isEmpty()){
                        String input = tfWord.getText().toLowerCase();

                        int index = searcher.binarySearch(wordList, input.replaceAll("\\s+", ""));
                        if (index == -1) {
                            JOptionPane.showMessageDialog(DeleteWord.this,"Word not found!");
                        } else {
                            try {
                                JSONArray jsArray = new JSONArray();
                                for (Words item : wordList) {
                                    jsArray.put(item);
                                }
                                FileWriter fileWriter = new FileWriter("res\\dictionary.json");

                                word.remove(index);
                                jsArray = new JSONArray(word);

                                fileWriter.write(jsArray.toString());
                                fileWriter.flush();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            JOptionPane.showMessageDialog(DeleteWord.this, "Successfully Deleted: " + tfWord.getText(),
                                    "Delete Book", JOptionPane.INFORMATION_MESSAGE);
                            tfWord.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(DeleteWord.this, "Field empty!!!", "Delete Word", JOptionPane.ERROR_MESSAGE);
                    }
                    tfWord.requestFocus();
                }
            }
        );

        JLabel lWord = new JLabel("Word: ");
        JLabel blank = new JLabel();

        lWord.setBounds(10, 30, 60, 30);
        tfWord.setBounds(70, 30, 100, 30);

        blank.setBounds(10, 50, 100, 30);

        btnDelete.setBounds(30, 70, 100, 30);

        add(tfWord);
        add(btnDelete);

        add(lWord);
        add(blank);
    }
}