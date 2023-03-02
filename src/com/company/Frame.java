package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    public Frame() throws Exception {
        super("Word Dictionary");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar mb = new JMenuBar();
        JMenu menuWord = new JMenu("Word Dictionary");
        mb.add(menuWord);

        JMenuItem option = new JMenuItem("Add Word..");
        option.setAccelerator(KeyStroke.getKeyStroke("F5"));
        menuWord.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addWord();
            }
        });

        option = new JMenuItem("Delete Word...");
        option.setAccelerator(KeyStroke.getKeyStroke("F6"));
        menuWord.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteWord();
            }
        });

        menuWord.addSeparator();

        option = new JMenuItem("Search Word...");

        option.setAccelerator(KeyStroke.getKeyStroke("F7"));
        menuWord.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchWord();
            }
        });

        menuWord.addSeparator();

        option = new JMenuItem("View Words");
        option.setAccelerator(KeyStroke.getKeyStroke("F8"));
        menuWord.add(option);
        option.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listWords();
            }
        });

        addToolbar();
        setJMenuBar(mb);

    }

    public ImageIcon getImage(String filename) {
        try {
            return new javax.swing.ImageIcon(filename);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void centerToParent(JFrame parent, JFrame child) {
        Dimension pd = parent.getSize();
        Dimension cd = child.getSize();
        int x = (int) (pd.getWidth() - cd.getWidth()) / 2;
        int y = (int) (pd.getHeight() - cd.getHeight()) / 2;
        child.setLocation(x, y);

    }

    public void addWord() {
        AddWord w = new AddWord();
        centerToParent(Frame.this, w);
        w.setVisible(true);
    }

    public void deleteWord() {
        DeleteWord w = new DeleteWord();
        centerToParent(Frame.this, w);
        w.setVisible(true);
    }

    public void searchWord() {
        SearchWord w = new SearchWord();
        centerToParent(Frame.this, w);
        w.setVisible(true);
    }

    public void listWords() {
        ListWords w = new ListWords();
        w.setVisible(true);
        centerToParent(Frame.this, w);
    }

    public void addToolbar() {
        JToolBar tb = new JToolBar();

        JButton b = new JButton(getImage("res\\add.gif"));
        b.setPreferredSize(new Dimension(32, 32));
        tb.add(b);
        b.setToolTipText("Add a book");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWord();
            }

        });

        b = new JButton(getImage("res\\delete.gif"));
        b.setPreferredSize(new Dimension(32, 32));
        tb.add(b);
        b.setToolTipText("Delete a book");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteWord();
            }

        });

        b = new JButton(getImage("res\\search.gif"));
        b.setPreferredSize(new Dimension(32, 32));
        tb.add(b);
        b.setToolTipText("Search a book");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchWord();
            }

        });


        b = new JButton(getImage("res\\list.gif"));
        b.setPreferredSize(new Dimension(32, 32));
        tb.add(b);
        b.setToolTipText("View all Books");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listWords();
            }

        });
        getContentPane().add(tb, BorderLayout.NORTH);
    }

    public void run() throws Exception {
        Frame f = new Frame();
        f.setSize(800,600);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

}
