package com.epam.rd.autotasks.figures;

class Triangle extends Figure  {
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
                        Math.sqrt(Math.pow(b.getX() - c.getX(), 2) + Math.pow(b.getY() - c.getY(), 2))) ||
                (((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY()) - a.getY()) == 0) ||
                (((c.getX() - a.getX()) * (b.getY() - a.getY()) - (b.getX() - a.getX()) * (c.getY()) - a.getY()) == 0) ||
                (((a.getX() - c.getX()) * (b.getY() - c.getY()) - (b.getX() - c.getX()) * (a.getY()) - c.getY()) == 0) ) {
            throw new IllegalArgumentException("no null or repeats are allowed");
        }
        this.A = a;
        this.B = b;
        this.C = c;

    }
//dx1 = ;
//dy1 = y2 - y1;
//       (((a.getX() - c.getX()) * (b.getY() - c.getY()) - (b.getX() - c.getX()) * (a.getY()) - c.getY()) == 0)
//dx = x - x1;
//dy = y - y1;
//A(x1, y1) и B(x2, y2), и третья точка C(x, y)
//S = (x2 - x1) * (y - y1) - (x - x1) * (y2 - y1);

    @Override
    public Point centroid() {
        double X = (A.getX() + B.getX() + C.getX()) / 3;
        double Y = (A.getY() + B.getY() + C.getY()) / 3;
        return new Point(X, Y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }
}
