package stu;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MyDrawPanel extends JPanel {

    private Polyline mPolyline;

    public void setPolyline(Polyline pline) {
        mPolyline = pline;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));  //굵기

        int numlines = mPolyline.getNumPts() - 1;

        for (int i = 0; i < numlines; i++) {
            Point p0 = mPolyline.getPoint(i);
            Point p1 = mPolyline.getPoint(i + 1);
            g.drawLine((int) p0.getX(), (int) p0.getY(), (int) p1.getX(), (int) p1.getY());
        }

        g.setColor(Color.RED);
        int numpts = mPolyline.getNumPts();
        for (int i = 0; i < numpts; i++) {
            Point p = mPolyline.getPoint(i);
            g.fillRect((int) p.getX() - 6, (int) p.getY() - 6, 10, 10);
        }

        if (mPolyline.isClosed() == true) {
            Point first = mPolyline.getPoint(0);
            Point last = mPolyline.getPoint(mPolyline.getNumPts() - 1);
            g.setColor(Color.BLACK);
            g.drawLine((int) first.getX(), (int) first.getY(), (int) last.getX(), (int) last.getY());
        }
    }
}
