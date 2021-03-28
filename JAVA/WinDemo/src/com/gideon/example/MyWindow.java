package com.gideon.example;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 11:56 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class MyWindow extends Frame {

    public MyWindow(String title){
        super(title);
        setSize(500, 140);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
        Font sansSerifSmall = new Font("SansSerif", Font.BOLD, 12);
        g.setFont(sansSerifLarge);
        g.drawString("The Complete Java Developer Course", 60, 60);
        g.setFont(sansSerifSmall);
        g.drawString("by: Gideon Nimoh", 60, 100);
    }
}
