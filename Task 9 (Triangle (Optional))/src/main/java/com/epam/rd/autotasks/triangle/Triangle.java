package com.epam.rd.autotasks.triangle;

class Triangle {
    Point A;
    Point B;
    Point C;

    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null || ((a.getX() == b.getX())&&(a.getY() == b.getY())) || ((a.getX() == c.getX())&&(a.getY() == c.getY()))
                || ((b.getX() == c.getX())&&(b.getY() == c.getY())) ||
                (Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2)) + Math.sqrt(Math.pow(b.getX() - c.getX(), 2) + Math.pow(b.getY() - c.getY(), 2)) <=
                        Math.sqrt(Math.pow(a.getX() - c.getX(), 2) + Math.pow(a.getY() - c.getY(), 2))) ||
                (Math.sqrt(Math.pow(b.getX() - c.getX(), 2) + Math.pow(b.getY() - c.getY(), 2)) + Math.sqrt(Math.pow(a.getX() - c.getX(), 2) + Math.pow(a.getY() - c.getY(), 2)) <=
                        Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2))) ||
                (Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2)) + Math.sqrt(Math.pow(a.getX() - c.getX(), 2) + Math.pow(a.getY() - c.getY(), 2)) <=
                        Math.sqrt(Math.pow(b.getX() - c.getX(), 2) + Math.pow(b.getY() - c.getY(), 2))) ) {
            throw new IllegalArgumentException("no null or repeats are allowed");
        }
        this.A = a;
        this.B = b;
        this.C = c;
    }
    public double area() {
        return Math.abs(
                (B.getX()-A.getX())*(C.getY() - A.getY())
                        - (C.getX() - A.getX())*(B.getY() - A.getY())
        ) / 2;
    }

    public Point centroid(){
        double X = (A.getX() + B.getX() + C.getX()) / 3;
        double Y = (A.getY() + B.getY() + C.getY()) / 3;
        return new Point(X, Y);
    }

}
