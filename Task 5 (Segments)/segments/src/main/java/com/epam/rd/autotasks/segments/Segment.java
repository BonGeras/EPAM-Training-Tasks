package com.epam.rd.autotasks.segments;
import java.awt.Point;


public class Segment {
    public Point start;
    public Point end;
    private double k;
    private double b;

    public Segment(Point start, Point end) {
        if (start == null || end == null || start.equals(end)) {
            throw new IllegalArgumentException("no nulls must be here");
        }
        double A = start.getY() - end.getY();
        double B = end.getX() - start.getX();
        if (B == 0) throw new IllegalArgumentException("Points lay on same vertical line.");
        double C = start.getX() * end.getY() - end.getX() * start.getY();
        this.k = -A/B;
        this.b = -C/B;
        this.start = start;
        this.end = end;
    }
    public double getK() {
        return k;
    }
    public double getB() {
        return b;
    }

    double length() {
        return Math.sqrt(Math.pow(start.getX() - end.getX(), 2)  + Math.pow(start.getY()-end.getY(), 2));
    }

    com.epam.rd.autotasks.segments.Point middle() {
        int midX = (int) ((start.getX() + end.getX())/2);
        int midY = (int) ((start.getY() + end.getY())/2);
        return new Point(midX, midY);
    }

    com.epam.rd.autotasks.segments.Point intersection(Segment another) {
        if (getK() == another.getK()) throw new IllegalArgumentException("Lines are parallel and do not intersect.");
        int x = (int) ((another.getB() - getB()) / (getK() - another.getK()));
        int y = (int) (getK() * x + getB());
        return new Point(x, y);

   }

}
