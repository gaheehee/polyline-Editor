package stu;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Polyline extends MouseAdapter implements MouseListener, MouseMotionListener {

    private ArrayList<Point> mPts = new ArrayList();
    private boolean mClosed = false;
    int x, y;
    boolean dragged = false;

    public void clear() {
        mPts.clear();
        mClosed = false;
        dragged=false;
    }

    public boolean isClosed() {
        return mClosed;
    }

    public void setClosed() {
        mClosed = true;
        dragged = true;
    }


    public int getNumPts() {
        return mPts.size();
    }

    // mPts의 i번째 포인트 리턴
    public Point getPoint(int i) {
        return mPts.get(i);
    }

    public void mousePressed(MouseEvent e) {
        if(dragged==false) {
            x = e.getX();
            y = e.getY();
            mPts.add(new Point(x, y));
            ((JPanel) e.getSource()).repaint();
        }
    }
    public void mouseDragged(MouseEvent e) {
        int x1 = e.getX();
        int y2 = e.getY();
        Point p = new Point(x1,y2);


        for (int i = 0; i < mPts.size(); i++) {
            if (mPts.get(i).getX() +10 > e.getX() &&
                    mPts.get(i).getX() -10 < e.getX() &&
                    mPts.get(i).getY() +10 > e.getY() &&
                    mPts.get(i).getY() -10 < e.getY())
            {
                dragged = true;
                mPts.set(i,p);
                break;
            }
            ((JPanel) (e.getSource())).repaint();
            dragged = false;

        }

    }

}


