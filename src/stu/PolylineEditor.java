package stu;

import javax.swing.*;
import java.awt.*;

public class PolylineEditor {

    public static void main(String[] args) {
        PolylineEditor gui = new PolylineEditor();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();
        Polyline pline = new Polyline();
        drawPanel.setPolyline(pline);
        drawPanel.addMouseListener(pline);
        drawPanel.addMouseMotionListener(pline);

        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);

        JButton clearButton = new JButton("Clear");
        JButton closedButton = new JButton("Closed");

        clearButton.addActionListener(
                (event)-> { pline.clear(); drawPanel.repaint();}
        );

        closedButton.addActionListener(
                (event)-> { pline.setClosed(); drawPanel.repaint();}
        );


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add( (JButton) clearButton);
        panel.add( (JButton) closedButton);
        frame.add(panel,"South");

        BorderLayout layout = (BorderLayout)frame.getContentPane().getLayout();
        layout.setHgap(10);
        layout.setVgap(10);

        frame.setSize(800,800);
        frame.setVisible(true);
    }
}
